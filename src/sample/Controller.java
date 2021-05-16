package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Optional;

public class Controller {
    @FXML private ListView tabella;
    private ContextMenu contextMenu = new ContextMenu();
    private Model model;
    private MenuItem item1;
    private MenuItem item2;


    public Controller(){
        model = new Model();
        item1 = new MenuItem("modifica");
        item2 = new MenuItem("elimina");
        contextMenu.getItems().addAll(item1, item2);


    }
    public void getController2Scene(){}
    public void aggiungiOrdine(ActionEvent event) {
        try {
            FXMLLoader f2 = new FXMLLoader(getClass().getResource("finestraAdd.fxml"));
            Parent fin2 = f2.load();

            Stage stage = (Stage) tabella.getScene().getWindow();

            stage.setTitle("Nuovo Ordine");
            //crea e setta la scena
            Scene scena = new Scene(fin2, 700, 600);
            stage.setScene(scena);

            //------comunicazione tra  scene -----------------
            //crea un riferimento al controller della nuova scena
            Controller2 controller2 = f2.getController();
            //richiama il metodo del controller della nuova scena
            controller2.utile(model, tabella);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void modificaOrdine(Ordine o){

    }
        public void selTabella(MouseEvent e) {
            Ordine x = (Ordine) tabella.getSelectionModel().getSelectedItem();
            System.out.println(x);
            tabella.setContextMenu(contextMenu);
            item1.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    System.out.println("modify selected");
                    modificaOrdine((Ordine)tabella.getSelectionModel().getSelectedItem());// crea metodo modifica e crea collegamento con altro controller per riempire la finestre con i dati dell'oggetto passato
                    //System.out.println("posso andare avanti qua");
                }
            });
            item2.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    System.out.println("elimina selected");
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Conferma cancellazione");
                    alert.setHeaderText("Stai cancellando un ordine");
                    alert.setContentText("Sei sicuro?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        Ordine ordine = (Ordine)tabella.getSelectionModel().getSelectedItem();
                        model.cancella(ordine);
                    } else {
                        System.out.println("annullata");
                    }
                }
            });

        }
}

