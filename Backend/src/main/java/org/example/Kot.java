package org.example;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Date;


@Document(collection = "Kot")
public class Kot {
    @Id
    private String id;

    @Field("Cena")
    private double cena;

    @Field("DataUrodzenia")
    private Date dataUrodzenia;

    @Field("HodowlaID")
    private String hodowlaID;

    @Field("Imie")
    private String imie;

    @Field("MatkaID")
    private String matkaID;

    @Field("OjciecID")
    private String ojciecID;

    @Field("RasaID")
    private String rasaID;

    @Field("Status")
    private String status;
    @Field("obrazek")
    private String obrazek;
    @Field("CzasRezerwacji")
    private Date czasRezerwacji;


    public Kot() {
    }

    public Kot(String id, double cena, Date dataUrodzenia, String hodowlaID, String imie,
               String matkaID, String ojciecID, String rasaID, String status, String obrazek) {
        this.id = id;
        this.cena = cena;
        this.dataUrodzenia = dataUrodzenia;
        this.hodowlaID = hodowlaID;
        this.imie = imie;
        this.matkaID = matkaID;
        this.ojciecID = ojciecID;
        this.rasaID = rasaID;
        this.status = status;
        this.obrazek = obrazek;
    }

    // Gettery i Settery

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getHodowlaID() {
        return hodowlaID;
    }

    public void setHodowlaID(String hodowlaID) {
        this.hodowlaID = hodowlaID;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getMatkaID() {
        return matkaID;
    }

    public void setMatkaID(String matkaID) {
        this.matkaID = matkaID;
    }

    public String getOjciecID() {
        return ojciecID;
    }

    public void setOjciecID(String ojciecID) {
        this.ojciecID = ojciecID;
    }

    public String getRasaID() {
        return rasaID;
    }

    public void setRasaID(String rasaID) {
        this.rasaID = rasaID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getObrazek() {
        return obrazek;
    }

    public void setObrazek(String obrazek) {
        this.obrazek = obrazek;
    }
    public Date getCzasRezerwacji() {
        return czasRezerwacji;
    }

    public void setCzasRezerwacji(Date czasRezerwacji) {
        this.czasRezerwacji = czasRezerwacji;
    }
}
