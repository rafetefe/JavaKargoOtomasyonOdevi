/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kargo9;

/**
 *
 * @author op
 */
public class Paket {
    /*
    Kargo ID,   Yollayan ID,    Alıcı ID,   Adres,  Fiyat
    Int,        Int,            Int,        String, Int
    */
    int kargoid;
    int gönderenid;
    int alacakid;
    String adres;
    int fiyat;
    double uzunluk;
    double genislik;
    double yukseklik;
    
    public Paket(int id, int gönderenid, int alacakid, String adres,double uzunluk,double genislik,double yukseklik){
        
    }
    public int getKargoid() {
        return kargoid;
    }

    public void setKargoid(int kargoid) {
        this.kargoid = kargoid;
    }

    public int getGönderenid() {
        return gönderenid;
    }

    public void setGönderenid(int gönderenid) {
        this.gönderenid = gönderenid;
    }

    public int getAlacakid() {
        return alacakid;
    }

    public void setAlacakid(int alacakid) {
        this.alacakid = alacakid;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = (int) ((uzunluk + genislik + yukseklik)/10) ;
    }
}
