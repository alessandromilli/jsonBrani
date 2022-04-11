package com.example.jsonbrani;

public class Brano {
    private String genere;
    private String titolo;
    private String autore;
    private String durata;

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "Brano{" +
                "genere='" + genere + '\'' +
                ", titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", durata='" + durata + '\'' +
                '}';
    }
}

