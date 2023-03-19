package georgian200504750;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class scrabbleMain extends Application {

    static Scene scrabbleMain,rulePage,prevWordsPage;

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Scrabble Points Generator");

//            Parent root1 = FXMLLoader.load(getClass().getResource("/application/startPage.fxml"));
//            startPage = new Scene(root1);
            //	startPage.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            Parent root2 = FXMLLoader.load(getClass().getResource("/georgian200504750/scrabbleMain.fxml"));
            scrabbleMain = new Scene(root2);
            Parent root3 = FXMLLoader.load(getClass().getResource("/georgian200504750/rulePage.fxml"));
            rulePage = new Scene(root3);
            Parent root4 = FXMLLoader.load(getClass().getResource("/georgian200504750/prevWordsPage.fxml"));
            prevWordsPage = new Scene(root4);

            primaryStage.setScene(scrabbleMain);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        launch(args);
    }


    public static Scene getMainPage() {
        return scrabbleMain;
    }

    public static Scene getRulePage() {
        return rulePage;
    }

    public static Scene getPrevWordsPage() {
        return prevWordsPage;
    }


}
