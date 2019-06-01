/*
 *  Copyright 2014 Rainer Stoermer
 */
package rdb.pres.mainmenu;

import java.net.URL;
import java.time.Year;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;
import rdb.ImdbSearch;

/**
 * FXML Controller class
 *
 * @author Rainer Stoermer
 */
public class MainMenuController implements Initializable {

    @FXML
    private StackPane mainPane;

    private final ImdbSearch application = ImdbSearch.getInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public StackPane getMainPane() {
        return mainPane;
    }

    public void processSearchKeyword(ActionEvent actionEvent) {
        application.setWindowContent("pres/searchKeyword/searchKeyword.fxml");
    }

    //TODO: implement the following methods
    public void processExtendedSearch(ActionEvent actionEvent) {
        throw new UnsupportedOperationException();
    }

    public void processQuit(ActionEvent actionEvent) {
        application.getStage().close();
    }

    public void processViewRentLists(ActionEvent actionEvent) {
        throw new UnsupportedOperationException();
    }

    public void processAbout(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(ImdbSearch.TITLE);
        alert.setHeaderText("IMDB Search Application");
        alert.setContentText("Interactive IMDB Exploration\nCopyright [Namen] " + Year.now());
        alert.show();
    }
}
