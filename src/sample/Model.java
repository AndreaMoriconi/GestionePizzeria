package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
    ObservableList <Ordine> ordini;

    public Model(){ordini = FXCollections.observableArrayList();}

    public boolean add(Ordine o) { return ordini.add(o); }
    public void cancella(Ordine o) {
        ordini.remove(o);
    }
    public ObservableList<Ordine> getOrdine() { return ordini;}
    public void setOrdini(ObservableList<Ordine> ordine) {
        this.ordini = ordini;
    }
    @Override
    public String toString() {
        return "Model [elenco=" + ordini + "]";
    }
}
