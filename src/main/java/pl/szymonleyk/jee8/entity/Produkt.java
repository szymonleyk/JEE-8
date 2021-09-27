package pl.szymonleyk.jee8.entity;

import javax.persistence.*;

@Table(name = "produkt")
@Entity
public class Produkt {

    public Produkt() {}

    public Produkt(String nazwa, double cena, int ilosc) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nazwa;
    private double cena;
    private int ilosc;
}
