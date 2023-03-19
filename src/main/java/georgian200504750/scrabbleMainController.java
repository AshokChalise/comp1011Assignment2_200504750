package georgian200504750;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class scrabbleMainController implements Initializable {

    private static scrabbleModel model=new scrabbleModel();

    @FXML
    private ListView<String> wordList=new ListView<>();
    @FXML
    private ListView<String> ruleList=new ListView<>();
    @FXML
    private ListView<String> pointList=new ListView<>();
    @FXML
    private TextField word;
    @FXML
    private Label status;
    @FXML
    private Label error;
    @FXML
    private ListView<String> pointList2=new ListView<>();
    @FXML
    private Label totalPoints;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        wordList.setItems(model.getWordList());
        ruleList.setItems(model.getRules());
        pointList.setItems(model.getCountList());
        pointList2.setItems(model.getPointTable());


    }


    public void scrabbleMain(ActionEvent event) throws IOException {
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scrabbleMain.getMainPage());
        window.show();
    }

    public void PrevWordsPage(ActionEvent event) throws IOException {
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scrabbleMain.getPrevWordsPage());
        window.show();
    }

    public void RulePage(ActionEvent event) throws IOException {
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scrabbleMain.getRulePage());
        window.show();
    }
    public void Exit(ActionEvent event) {
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();

    }

    public void SubmitWord(ActionEvent event) throws IOException {

        if(!verify(word.getText())) {
            status.setText("Invalid Word: "+word.getText());
            word.clear();
            status.setTextFill(Paint.valueOf("Red"));
            return;
        }
        int p=model.getWordPoints(word.getText().toUpperCase());
        status.setText("Submitted "+p+" Points Added");
        error.setText("");
        status.setTextFill(Paint.valueOf("Green"));
        model.AddWord(word.getText());
        model.TakePoints(word.getText().toUpperCase());
        totalPoints.setText(model.getTotalPoints()+"");
        wordList.setItems(model.getWordList());
        pointList.setItems(model.getCountList());
        word.clear();
    }


    private boolean verify(String text) {
        if (text == null || text.length() < 2 || text.length() > 8) {
            return setError("Error: word length in range [2-8]");
        }

        if (model.CheckWord(text)) {
            return setError("Error: duplicate word. check Previous Words!");
        }

        text = text.toUpperCase();
        for (char c : text.toCharArray()) {
            if (c < 'A' || c > 'Z') {
                return setError("Error: only alphabets allowed!");
            }
        }

        int[] arr = new int[26];
        int vowelCount = 0;
        for (char c : text.toCharArray()) {
            arr[c - 'A']++;
            if ("AEIOUY".indexOf(c) != -1) {
                vowelCount++;
            }
        }

        if (vowelCount == 0) {
            return setError("Error:  One letter must be vowel (A, E, I, O, U) or Y!");
        }

        if (!model.CheckPoints(arr)) {
            return setError("Error:  not enough points for this word!");
        }

        return true;
    }

    private boolean setError(String message) {
        error.setText(message);
        return false;
    }


    public void Reset(ActionEvent event ) {
//        function for reset button
        model.reset();
        wordList.setItems(model.getWordList());
        pointList.setItems(model.getCountList());
        word.clear();
        status.setText("Reset Successfull");
        status.setTextFill(Paint.valueOf("Green"));
        totalPoints.setText("0");
        error.setText("");

    }

}
