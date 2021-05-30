package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Menu {
    String nome;
    ObservableList<Pizza> pizze;
    public Menu(){
        pizze = FXCollections.observableArrayList();
    }
    public Menu(String nome){
        this.nome = nome;
    }
    public Menu(Menu menu){
        this.nome= menu.getNome();
    }

    public ObservableList<Pizza> getPizze(){
        return pizze;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addPizze(ObservableList<Pizza> p){
        pizze = p;
    }
    public void eliminaPizza(Pizza p){
        pizze.remove(p);
    }

    public String getNome() {
        return nome;
    }
}
