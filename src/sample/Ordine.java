package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalTime;
import java.util.ArrayList;

public class Ordine {
    private ObservableList <String> pizze;
    private Indirizzo indirizzo;
    private String nome;
    private String cognome;
    private LocalTime oraConsegna;

    public Ordine(){ this.pizze = FXCollections.observableArrayList();}

    public Ordine(Ordine o){
        this.indirizzo = o.getIndirizzo();
        this.nome = o.getNome();
        this.cognome = o.getCognome();
        this.pizze = o.getPizze();
        this.oraConsegna = o.getOraConsegna();
    }
    public Indirizzo getIndirizzo(){
        return indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalTime getOraConsegna() {
        return oraConsegna;
    }

    public void setIndirizzo(Indirizzo i){
        this.indirizzo = i;
    }
    public void setNome(String n){
        nome = n;
    }
    public void setCognome(String c){
        cognome = c;
    }
    public void setOraConsegna(LocalTime ora){
        oraConsegna = ora;
    }
    public void setPizze(ObservableList <String> pizze){
        this.pizze = pizze;
    }
    public ObservableList <String> getPizze(){
        return pizze;
    }

    @Override
    public String toString() {
        return "Ordine di "+ nome + " " + cognome;
    }
}
