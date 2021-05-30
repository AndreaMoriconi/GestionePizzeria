package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller3{
    @FXML private TextField menuName;
    @FXML private TextField pizzaName;
    @FXML private TextField prezzo;
    @FXML private TextField ingredienti;
    @FXML private ListView<Pizza> pizzeListView;
    ObservableList<Pizza> pizze;
    Model model;
    MenuButton menuSelector;
    private Controller controller;
    public Controller3(){
        pizze = FXCollections.observableArrayList();
    }

    public void util(Model model, MenuButton menuSelector, Controller controller){
        this.model = model;
        this.menuSelector = menuSelector;
        this.controller = controller;
    }
    public void aggiungi(ActionEvent e){
        Pizza pizza = new Pizza(pizzaName.getText(), Double.parseDouble(prezzo.getText()));
        if (ingredienti != null){
            pizza.setIngredienti(ingredienti.getText());
            ingredienti.clear();
        }
        pizzaName.clear();
        prezzo.clear();

        pizze.add(pizza);
        pizzeListView.setItems(pizze);
    }
    public void salva(ActionEvent e){
        Menu m = new Menu(menuName.getText());
        m.addPizze(pizze);
        model.addMenu(m);
        Node source = (Node)  e.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        MenuItem menu = new MenuItem(menuName.getText());
        menu.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                System.out.println("Opening Database Connection...");
                controller.cliccaMenuSelezionato(e);
            }
        });
        menuSelector.getItems().add(menu);
    }
}
