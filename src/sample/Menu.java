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

    public ObservableList<Pizza> getPizze(){
        return pizze;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addPizza(Pizza p){
        pizze.add(p);
    }
    public void eliminaPizza(Pizza p){
        pizze.remove(p);
    }
}
