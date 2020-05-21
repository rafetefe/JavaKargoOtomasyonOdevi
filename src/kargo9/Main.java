package kargo9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Grup 9, Kargo Projesi
 *
 * @author op
 */
public class Main {

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

    //Dosyalarda belirtilen satırı bulur
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

    static LoginFrame login = new LoginFrame();
    //Programda 2 ayrı anamenü var, giriş yapıldıktan sonra
    //iç katmanlardaki bir ekrandan, ana menüye geri dönmek istediğinde
    //hangi menüye dönmesi gerektiğini burdan hatırlıyo
    static int yetki;

    public static void main(String[] args) {
        //Açılacak ekranlar ve işleyiş
        login.setVisible(true);
        
        
    }

}
