package com.murat.gky401.model;

public class YemekList_Model {
    private String yemekadi;
    private int pismeSuresi,hazirlamaSuresi,kisiSayisi;

    public YemekList_Model(String yemekadi, int pismeSuresi, int hazirlamaSuresi, int kisiSayisi) {
        this.yemekadi = yemekadi;
        this.pismeSuresi = pismeSuresi;
        this.hazirlamaSuresi = hazirlamaSuresi;
        this.kisiSayisi = kisiSayisi;
    }

    public String getYemekadi() {
        return yemekadi;
    }

    public void setYemekadi(String yemekadi) {
        this.yemekadi = yemekadi;
    }

    public int getPismeSuresi() {
        return pismeSuresi;
    }

    public void setPismeSuresi(int pismeSuresi) {
        this.pismeSuresi = pismeSuresi;
    }

    public int getHazirlamaSuresi() {
        return hazirlamaSuresi;
    }

    public void setHazirlamaSuresi(int hazirlamaSuresi) {
        this.hazirlamaSuresi = hazirlamaSuresi;
    }

    public int getKisiSayisi() {
        return kisiSayisi;
    }

    public void setKisiSayisi(int kisiSayisi) {
        this.kisiSayisi = kisiSayisi;
    }
}
