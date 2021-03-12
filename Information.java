package com.company;

import java.util.ArrayList;

class Information {
    private String nume;
    private String prenume;
    private String email;
    private String telefon;
    private String data_nastere;
    private String sex;
    private ArrayList<String> limbi_cunoscute;
    private ArrayList<String> nivel_cunoastere;


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume(){
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getData_nastere() {
        return data_nastere;
    }

    public void setData_nastere(String data_nastere) {
        this.data_nastere = data_nastere;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ArrayList<String> getLimbi_cunoscute() {
        return limbi_cunoscute;
    }

    public void setLimbi_cunoscute(ArrayList<String> limbi_cunoscute) {
        this.limbi_cunoscute = limbi_cunoscute;
    }

    public ArrayList<String> getNivel_cunoastere() {
        return nivel_cunoastere;
    }

    public void setNivel_cunoastere(ArrayList<String> nivel_cunoastere) {
        this.nivel_cunoastere = nivel_cunoastere;
    }
}
