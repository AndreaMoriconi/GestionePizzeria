package sample;

public class Pizza {
    private String nome;
    private String ingredienti;
    private double prezzo;

    public Pizza(String nome, double prezzo){
        this.nome = nome;
        this.prezzo = prezzo;
    }
    public Pizza (){}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getIngredienti() {
        return ingredienti;
    }

    @Override
    public String toString() {
        return nome + " " +prezzo+"€" ;
    }
}
