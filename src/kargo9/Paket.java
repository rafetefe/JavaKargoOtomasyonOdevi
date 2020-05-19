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
    int gonderenid;
    int alacakid;
    String gonderenadres;
    String alacakadres;
    int fiyat;
    double uzunluk;
    double genislik;
    double yukseklik;

    public Paket(int id, int gönderenid, int alacakid,
            String gonderenadres, String alacakadres,
            double uzunluk, double genislik, double yukseklik) {

    }

    public int getKargoid() {
        return kargoid;
    }

    public void setKargoid(int kargoid) {
        this.kargoid = kargoid;
    }

    public int getGönderenid() {
        return gonderenid;
    }

    public void setGönderenid(int gönderenid) {
        this.gonderenid = gönderenid;
    }

    public int getAlacakid() {
        return alacakid;
    }

    public void setAlacakid(int alacakid) {
        this.alacakid = alacakid;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = (int) ((uzunluk * genislik * yukseklik) / 1000);
    }

    public int getGonderenid() {
        return gonderenid;
    }

    public void setGonderenid(int gonderenid) {
        this.gonderenid = gonderenid;
    }

    public String getGonderenadres() {
        return gonderenadres;
    }

    public void setGonderenadres(String gonderenadres) {
        this.gonderenadres = gonderenadres;
    }

    public String getAlacakadres() {
        return alacakadres;
    }

    public void setAlacakadres(String alacakadres) {
        this.alacakadres = alacakadres;
    }
}
