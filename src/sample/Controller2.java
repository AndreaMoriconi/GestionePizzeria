package sample;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
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
    Model model;
    ObservableList<String> pizze;


    public void utile(Model model, ListView tabella) {
        this.model = model;
        this.tabella = tabella;
    }

    public void initialize(URL location, ResourceBundle resources) {
        ObservableList menu= FXCollections.observableArrayList("margherita", "salamino", "verdure", "quattro formaggi","tonno e cipolle");
        pizzaSelector.setItems(menu);
        pizze = FXCollections.observableArrayList();
    }
    public void selPizza(ActionEvent e){
        pizze.add((String) pizzaSelector.getValue());
        pizzeInOrdine.setItems(pizze);
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
