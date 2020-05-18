
package kargo9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Grup 9, Kargo Projesi
 * @author op
 */
public class Main {
    
    public static ArrayList<String> getKullanicilar(){
        //Kullanci.txt'yi ArrayList<String> olarak döndürür
        ArrayList<String> kullaniciList = new ArrayList<String>();
        try{
            File kulFile = new File("src/kargo9/kullanicilar.txt");
            Scanner kulScan = new Scanner(kulFile);
            while(kulScan.hasNext()){
                kullaniciList.add(kulScan.nextLine());
            }
            kulScan.close();
        }catch(FileNotFoundException e){
            System.out.println("Dosya bulunamadı");
        }
        return kullaniciList;
    }
    
    public static ArrayList<String[]> findSatir(
            ArrayList<String> Liste, int konum, String aranıcak){
        /*
        Konumlar={0 : ID,   1 : username,   2 : pass,   3 : yetki}
        */
        
        ArrayList<String[]> sonuclar = new ArrayList<String[]>();
        
        
        for (int i = 0; i < Liste.size(); i++) {
            String[] satir = Liste.get(i).split(" ");
            if (satir[konum].contains(aranıcak)){
                //burda return, bulduğu ilk satırı döndürüyo,
                //aranacak tutarlaştırılırsa kolaylaşır.
                sonuclar.add(satir);
            }
        }
        return sonuclar;
        //
    }
  
    public static void main(String[] args) {
        
        //abomination
        ArrayList<String[]> istek = findSatir(getKullanicilar(), 2, "123"); 
        for (int i = 0; i < istek.size()  ; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(istek.get(i)[j]);
                
            }
            System.out.println("");
        }
        //Açılacak ekranlar ve işleyiş
        //LoginFrame login = new LoginFrame();
        //login.setVisible(true);
    }
    
}
