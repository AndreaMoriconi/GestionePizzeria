package sample;

public class Indirizzo {
    private String via;
    private String paese;
    private String nCivico;
    public Indirizzo(){}
    public Indirizzo(String paese, String via, String n){
        this.paese = paese;
        this.via = via;
        this.nCivico = n;
    }
    public String getNCivico(){
        return nCivico;
    }
    public String getVia(){
        return via;
    }
    public String getPaese(){
        return paese;
    }
    public String toString(){
        return "via "+via+" paese "+paese+" numero civico "+nCivico;
    }
}
