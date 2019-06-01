/*
 *  Copyright 2014 Rainer Stoermer
 */
package rdb;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rdb.app.LoginApp;
import rdb.pres.login.LoginController;
import rdb.pres.mainmenu.MainMenuController;

/**
 *
 * @author Rainer Stoermer
 */
public class ImdbSearch extends Application {

    private static final int LOG_SIZE = 1024000;
    private static final int LOG_ROTATION_COUNT = 1;
    public static final String TITLE = "IMDB Search";
    private static ImdbSearch instance = null;
    private Stage stage;
    private Pane mainPane;

    public static void main(String[] args) {
        try {
            // set a handler for using a logfile for outputting log-messages
            Handler handler = new FileHandler("imdbsearch.log", LOG_SIZE, LOG_ROTATION_COUNT);
            handler.setFormatter(new SimpleFormatter());
            Logger.getLogger("").addHandler(handler);
        } catch (IOException | SecurityException ex) {
            Logger.getLogger("").log(Level.SEVERE, null, ex);
        }

        Application.launch(ImdbSearch.class, (java.lang.String[]) null);
    }

    @Override
    public void start(Stage stage) {
        instance = this;
        this.stage = stage;
        stage.setTitle(TITLE);
        stage.setMinWidth(400);
        stage.setMinHeight(300);
        stage.setResizable(false);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pres/login/login.fxml"));
            stage.setScene(new Scene(loader.load()));
            LoginController controller = loader.getController();
            controller.setApp(this);
            stage.show();
        } catch (IOException e) {
            Logger.getLogger(ImdbSearch.class.getName()).log(Level.SEVERE,
                    "Error loading login-fxml-file and controller" + e.getMessage());
        }
    }

    public void gotoMainMenu() {
        stage.close();
        stage = new Stage();
        stage.setTitle(TITLE);
        stage.setMinWidth(450);
        stage.setMinHeight(425);
        stage.setHeight(800);
        stage.setWidth(1200);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pres/mainmenu/mainMenu.fxml"));
            stage.setScene(new Scene(loader.load()));
            MainMenuController mainMenuController = loader.getController();
            mainPane = mainMenuController.getMainPane();
            stage.show();
        } catch (Exception ex) {
            Logger.getLogger(ImdbSearch.class.getName()).log(Level.SEVERE,
                    "Error loading mainmenu-fxml-file and controller" + ex.getMessage(), ex);
        }
    }

    /**
     * This method can be used to display a new fxml content within the main window
     * @param fxml relative path to the fxml file
     */
    public void setWindowContent(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(loader.load());
        } catch (Exception e) {
            Logger.getLogger(ImdbSearch.class.getName()).log(Level.SEVERE,
                    "Error loading login-fxml-file and controller" + e.getMessage());
        }
    }

    public void quit() {
        Logger.getLogger(ImdbSearch.class.getName()).log(Level.INFO, "Closing Application...");
        stage.close();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        LoginApp loginService = new LoginApp();
        loginService.oracleUserLogout();
    }

    public static ImdbSearch getInstance() {
        return instance;
    }

    public Stage getStage() {
        return stage;
    }
}
