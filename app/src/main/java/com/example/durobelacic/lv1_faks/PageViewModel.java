package com.example.durobelacic.lv1_faks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<String> sDatum = new MutableLiveData<>();
    private MutableLiveData<String> sIme = new MutableLiveData<>();
    private MutableLiveData<String> sPrezime = new MutableLiveData<>();
    private MutableLiveData<String> sImeProf = new MutableLiveData<>();
    private MutableLiveData<String> sAkadGod = new MutableLiveData<>();
    private MutableLiveData<String> sPredmet = new MutableLiveData<>();
    private MutableLiveData<String> sBrojPred = new MutableLiveData<>();
    private MutableLiveData<String> sBrojLv = new MutableLiveData<>();


    public void setIme(String ime){
        sIme.setValue(ime);
    }

    public LiveData<String> getIme() {
        return sIme;
    }

    public void setDatum(String datum){
        sDatum.setValue(datum);
    }

    public LiveData<String> getDatum() {
        return sDatum;
    }

    public void setPrezime(String prezime){
        sPrezime.setValue(prezime);
    }

    public LiveData<String> getPrezime(){
        return sPrezime;
    }

    public void setImeProf(String imeProf){
        sImeProf.setValue(imeProf);
    }

    public LiveData<String> getImeProf() {
        return sImeProf;
    }
    public void setAkadGod(String akadGod){
        sAkadGod.setValue(akadGod);
    }

    public LiveData<String> getAkadGod() {
        return sAkadGod;
    }
    public void setPredmet(String predmet){
        sPredmet.setValue(predmet);
    }

    public LiveData<String> getPredmet() {
        return sPredmet;
    }
    public void setBrojPred(String brojPred){
        sBrojPred.setValue(brojPred);
    }

    public LiveData<String> getBrojPred() {
        return sBrojPred;
    }


    public void setBrojLv(String brojLv){
        sBrojLv.setValue(brojLv);
    }

    public LiveData<String> getBrojLv()
    {
        return sBrojLv;
    }

}
