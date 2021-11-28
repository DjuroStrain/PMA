package com.example.durobelacic.lv1_faks;

public class Student {
    private String sIme;
    private String sPrezime;
    private String sPredmet;

    public Student(String sIme, String sPrezime, String sPredmet) {
        this.sIme = sIme;
        this.sPrezime = sPrezime;
        this.sPredmet = sPredmet;
    }

    public String getsIme() {
        return sIme;
    }

    public void setsIme(String sIme) {
        this.sIme = sIme;
    }

    public String getsPrezime() {
        return sPrezime;
    }

    public void setsPrezime(String sPrezime) {
        this.sPrezime = sPrezime;
    }

    public String getsPredmet() {
        return sPredmet;
    }

    public void setsPredmet(String sPredmet) {
        this.sPredmet = sPredmet;
    }
}
