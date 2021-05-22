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
    @FXML private MenuButton menu;
    @FXML private Label selectedMenu;
    private ContextMenu contextMenu = new ContextMenu();
    private Model model;
    private MenuItem item1;
    private MenuItem item2;
    private Scene scena2;
    private Controller2 controller2;

    public Controller(){
        model = new Model();
        item1 = new MenuItem("modifica");
        item2 = new MenuItem("elimina");
        contextMenu.getItems().addAll(item1, item2);
        try {
            FXMLLoader f2 = new FXMLLoader(getClass().getResource("finestraAdd.fxml"));
            Parent fin2 = f2.load();
            scena2 = new Scene(fin2, 700, 600);
            controller2 = f2.getController();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void initialize(){
        selectedMenu.setText("nessun menù selezionato");
    }
    public void aggiungiOrdine(ActionEvent event) {
        try {
            Stage stage = (Stage) tabella.getScene().getWindow();
            stage.setTitle("Nuovo Ordine");
            //crea e setta la scena
            stage.setScene(scena2);
            controller2.utile(model, tabella);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void modificaOrdine(Ordine o){
        Stage stage = (Stage) tabella.getScene().getWindow();
        stage.setTitle("Nuovo Ordine");
        //crea e setta la scena
        stage.setScene(scena2);
        controller2.modifica(o);
        model.cancella(o);
    }

    public void addMenu(ActionEvent event) throws Exception{
        System.out.println("add menu");
        try {
            FXMLLoader f3 = new FXMLLoader(getClass().getResource("finestraAddMenu.fxml"));
            Parent fin3 = f3.load();

            Stage stage = new Stage();
            stage.show();

            stage.setTitle("compila menù");
            //crea e setta la scena
            Scene scena=new Scene(fin3, 600, 500);
            stage.setScene(scena);

        }catch(Exception e){
                System.out.println(e);
        }


    }
        public void selTabella(MouseEvent e) {
            Ordine x = (Ordine) tabella.getSelectionModel().getSelectedItem();
            System.out.println(x);
            tabella.setContextMenu(contextMenu);
            item1.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    System.out.println("modify selected");
                    modificaOrdine((Ordine)tabella.getSelectionModel().getSelectedItem());
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

