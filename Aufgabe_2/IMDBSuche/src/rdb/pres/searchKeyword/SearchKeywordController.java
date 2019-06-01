/*
 *  Copyright 2014 Rainer Stoermer
 */
package rdb.pres.searchKeyword;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import rdb.ImdbSearch;

/**
 * FXML Controller class
 *
 * @author Rainer Stoermer
 */
public class SearchKeywordController implements Initializable {

    private ImdbSearch application = ImdbSearch.getInstance();
    @FXML
    private TextField keywordTextField;
    @FXML
    private CheckBox titleCB;
    @FXML
    private CheckBox personCB;
    @FXML
    private CheckBox characterCB;
    @FXML
    private CheckBox companiesCB;
    @FXML
    private CheckBox selectAllCB;
    @FXML
    private RadioButton matchAllRadioButton;
    @FXML
    private ToggleGroup matchGroup;
    @FXML
    private RadioButton matchAnyRadioButton;
    @FXML
    private RadioButton matchExactRadioButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    //TODO: Implement the following methods
    public void selectAll(ActionEvent actionEvent) {

    }

    public void processSearch(ActionEvent actionEvent) {

    }
}
