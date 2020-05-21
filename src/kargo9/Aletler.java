package kargo9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import static kargo9.Main.login;

/**
 *
 * @author op
 */
public class Aletler {
    
        //Ana Menü
    
    //Ana menü çağırıcı
    public static void anaMenuAc(int x) {
        if (x == 1) {
            //yönetici için main menu
            YoneticiAnaMenu anaMenu = new YoneticiAnaMenu();
            anaMenu.setVisible(true);
        } else {
            //musteri için main menu
            MusteriAnaMenu anaMenu = new MusteriAnaMenu();
            anaMenu.setVisible(true);
        }
        login.setVisible(false);
    }
    
        //Login
   
    public static int[] enterValidate(String username, String password) {
        //şifre username kombinasyonu doğrumu kontrol etsin, true false dönsün
        //Verilen usernamein olduğu satırı çeker
        //kullanıcının şifresiyle, yazılan şifreyi karşılaştırır.
        try {
            //Sorgu
            String[] query = Aletler.findSatir(
                    Aletler.getKullanicilar(), 1, username).get(0);
            if (query[2].equals(password)) {//Doğru Şifre
                //return true, yetki, id (session bilgileri)
                int[] tmp = {1, Integer.parseInt(query[3]), Integer.parseInt(query[0])};
                return tmp;
            }
        } catch (Exception e) {

        }
        //Yanlış şifre
        int[] tmp = {0, 0, 0};
        return tmp;
    }
    
        //Genel kullanım

    //Veritabanı Query: Dosyalarda belirtilen satırı bulur
    public static ArrayList<String[]> findSatir(
            ArrayList<String> Liste, int konum, String aranıcak) {
        /*
        Konumlar={0 : ID,   1 : username,   2 : pass,   3 : yetki}
         */
        //-----Dönen veri: findSatir().get(bulunan satir sayisi)[0-4];-------
        ArrayList<String[]> sonuclar = new ArrayList<String[]>();

        for (int i = 0; i < Liste.size(); i++) {
            String[] satir = Liste.get(i).split(" ");
            if (satir[konum].contains(aranıcak)) {
                sonuclar.add(satir);
            }
        }
        return sonuclar;
    }
    
    //Seçilen veritabanının en yük IDsini döndürür
    //Keywords : veritabanı= "kullanici" xor "paket"
    public static int sonEklenenID(String veritabani_adi){
        //Sorting algorithması olsa güzel olurdu
        
        int max = 0;
        ArrayList<String[]> src = null;
        
        //Keyword parametre
        if(veritabani_adi == "kullanici"){
            src = findSatir(getPaketler(), 0, "");
        }else if(veritabani_adi == "paket"){
            src = findSatir(getKullanicilar(), 0, "");
        }
        
        //tüm paketler kadar dönücek
        for (int i = 0; i < src.size(); i++) {
            int tmp = Integer.parseInt(src.get(i)[0]);
            if (tmp > max){
                max = tmp;
            }
        }
        
        return max;
    }

        //Kullanıcılar
    
    //Kullanicilar dosyasını çeker
    public static ArrayList<String> getKullanicilar() {
        //kullanciliar.txt'yi ArrayList<String> olarak döndürür
        ArrayList<String> kullaniciList = new ArrayList<String>();
        try {
            File kulFile = new File("src/kargo9/kullanicilar.txt");
            Scanner kulScan = new Scanner(kulFile);
            while (kulScan.hasNext()) {
                kullaniciList.add(kulScan.nextLine());
            }
            kulScan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı");
        }
        return kullaniciList;
    }
    
    public static void ekleSatirKullanicilar(String satir) throws IOException{
        File kulFile = new File("src/kargo9/kullanicilar.txt");
        FileWriter fileWriter = new FileWriter(kulFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        printWriter.println(satir);
        printWriter.close();
        bufferedWriter.close();
        fileWriter.close();
    }
    
    public static String[] getirTumKullanicilar(){
        return getKullanicilar().toArray(new String[0]);        
    }
    //Override + id
    public static String[] getirTumKullanicilar(int id){
        String tmp = String.valueOf(id);
        return findSatir(getKullanicilar(), 0, tmp).get(0);        
    }
    
        //Paketler
    
    //Paketler dosyasını çeker
    public static ArrayList<String> getPaketler(){
        //paketler.txt'yi ArrayList<String> olarak döndürür
        //Dönen veri: findSatir().get(bulunan satir sayisi)[0-6];
        ArrayList<String> paketList = new ArrayList<String>();
        try {
            File pakFile = new File("src/kargo9/paketler.txt");
            Scanner pakScan = new Scanner(pakFile);
            while (pakScan.hasNext()) {
                paketList.add(pakScan.nextLine());
            }
            pakScan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı");
        }
        return paketList;        
    }
    
    public static String[] getirTumPaketler(){
        return findSatir(getPaketler(), 0, "").toArray(new String[0]);
    }
    //override + id
    public static String[] getirTumPaketler(int id){
        String strID = String.valueOf(id);
        ArrayList<String> sonuc = new ArrayList<String>();
        //Kullanıcın yolladığı paketler
        ArrayList<String[]> kullanicidan = findSatir(getPaketler(),1,strID);
        //Kullanın alıcağı paketler
        ArrayList<String[]> kullaniciya = findSatir(getPaketler(),2,strID);
        
        for (int i = 0; i < kullanicidan.size(); i++) {
            sonuc.add(String.join(" ", kullanicidan.get(i)));
        }
        
        for (int j = 0; j < kullaniciya.size(); j++) {
            sonuc.add(String.join(" ", kullaniciya.get(j)));
        }
        
        return sonuc.toArray(new String[0]);
    }
      
    public static void ekleSatirPaketler(String satir) throws IOException{
        File pakFile = new File("src/kargo9/paketler.txt");
        FileWriter fileWriter = new FileWriter(pakFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        printWriter.println(satir);
        printWriter.close();
        bufferedWriter.close();
        fileWriter.close();
    }
    

}
