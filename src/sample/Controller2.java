package sample;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller2  implements Initializable{
    @FXML private TextField nome;
    @FXML private TextField cognome;
    @FXML private TextField via;
    @FXML private TextField nCivico;
    @FXML private TextField paese;
    @FXML private ComboBox pizzaSelector;
    @FXML private ListView pizzeInOrdine;
    @FXML private ListView tabella;
    private ContextMenu contextMenu = new ContextMenu();
    private MenuItem item1;
    Model model;
    ObservableList<Pizza> pizze;
    private Menu courrentMenu;


    public void utile(Model model, ListView tabella, Menu courrentMenu) {
        this.model = model;
        this.tabella = tabella;
        this.courrentMenu = courrentMenu;
        ObservableList<Pizza> menu= FXCollections.observableArrayList(courrentMenu.getPizze());
        pizzaSelector.setItems(menu);
        // pulizia dei field:
        nome.setText("");
        cognome.setText("");
        paese.setText("");
        via.setText("");
        nCivico.setText("");
        pizzeInOrdine.getItems().clear();

    }

    public void initialize(URL location, ResourceBundle resources) {

        pizze = FXCollections.observableArrayList();
        item1 = new MenuItem("elimina");
        contextMenu.getItems().addAll(item1);
    }
    public void selPizza(ActionEvent e){
        if(pizzaSelector.getValue() != null) {
            pizze.add((Pizza) pizzaSelector.getValue());
            pizzeInOrdine.setItems(pizze);
            pizzaSelector.getSelectionModel().clearSelection();
        }else{
            return;
        }
    }

    public void modifica(Ordine o){
        nome.setText(o.getNome());
        cognome.setText(o.getCognome());
        paese.setText(o.getIndirizzo().getPaese());
        via.setText(o.getIndirizzo().getVia());
        nCivico.setText(o.getIndirizzo().getNCivico());
        pizzeInOrdine.setItems(o.getPizze());
    }
    public void selTabella(MouseEvent e) {
        Ordine x = (Ordine) tabella.getSelectionModel().getSelectedItem();
        System.out.println(x);
        pizzeInOrdine.setContextMenu(contextMenu);
        item1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println("elimina selected");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Conferma cancellazione");
                alert.setHeaderText("Stai cancellando una pizza");
                alert.setContentText("Sei sicuro?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    Pizza pizza = (Pizza) pizzeInOrdine.getSelectionModel().getSelectedItem();
                    pizze.remove(pizza);
                } else {
                    System.out.println("annullata");
                }
            }
        });
    }

    public void save(ActionEvent event){
        Ordine o = new Ordine();
        Indirizzo indirizzo = new Indirizzo(paese.getText(), via.getText(), nCivico.getText());
        o.setNome(nome.getText());
        o.setCognome(cognome.getText());
        o.setIndirizzo(indirizzo);
        o.setPizze(pizze);
        model.add(o);
        tabella.setItems(model.getOrdine());

        try {
            Stage stage=(Stage) nome.getScene().getWindow();
            stage.setScene(tabella.getScene());
        }
        catch(Exception e){
            System.out.println(e);
        }


    }

}
