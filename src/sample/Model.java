package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
    ObservableList <Ordine> ordini;
    ObservableList <Menu> menus;

    public Model(){
        ordini = FXCollections.observableArrayList();
        menus = FXCollections.observableArrayList();
    }

    public boolean add(Ordine o) { return ordini.add(o); }
    public boolean addMenu(Menu m) { return menus.add(m); }
    public void cancella(Ordine o) {
        ordini.remove(o);
    }
    public void cancellaMenu(Menu m) { menus.remove(m); }
    public ObservableList<Ordine> getOrdine() { return ordini;}
    public ObservableList<Menu> getMenus() { return menus;}
    public void setOrdini(ObservableList<Ordine> ordine) {
        this.ordini = ordini;
    }
    public void setMenus(ObservableList<Menu> menus) {
        this.menus = menus;
    }
    public Menu getMenu(String name){
            /*menus.forEach((Menu menu) -> {
                if (menu.getNome().equals(name)) {
                    //return menu;
                }
            });*/
            for(int i = 0; i<menus.size(); i++){
                if(menus.get(i).getNome().equals(name)){
                    return menus.get(i);
                }
            }
            return new Menu();

    }
    @Override
    public String toString() {
        return "Model [elenco=" + ordini + "]";
    }
}
