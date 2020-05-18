
package kargo9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Grup 9, Kargo Projesi
 * @author op
 */
public class Main {

    
    
    public static void main(String[] args) {
        
        //Veri yapıları ve fonksiyonlar buraya gelicek. Olabildiğince temiz
        //tutalım.
        boolean hesapYetki;
        
        LoginFrame login = new LoginFrame();
        login.setVisible(true);
    }
    
    public void anaMenuAc(boolean yetki){
        if (yetki){
            //yönetici anamenüsü
        }else{
            //müşteri anamenüsü
        }
    }
    
    public void getKullanicilar(){
        try{
        File kulFile = new File("./kullanicilar.txt");
        Scanner kulScan = new Scanner(kulFile);
        while(kulScan.hasNext()){
            String satir = kulScan.nextLine();
        }
        
        
        }catch(FileNotFoundException e){
            System.out.println("Dosya bulunamadı");
        }
    }
    
    
    
}
