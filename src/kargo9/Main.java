package kargo9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Grup 9, Kargo Projesi
 *
 * @author op
 */
public class Main {
        
    static LoginFrame login = new LoginFrame();
    //Programda 2 ayrı anamenü var, giriş yapıldıktan sonra
    //iç katmanlardaki bir ekrandan, ana menüye geri dönmek istediğinde
    //hangi menüye dönmesi gerektiğini burdan hatırlıyo
    static int yetki;
    static int id;
    

    public static void main(String[] args) throws IOException {
        //Açılacak ekranlar ve işleyiş
        login.setVisible(true);
    }

}
