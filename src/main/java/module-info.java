module com.example.scrabble {
    requires javafx.controls;
    requires javafx.fxml;


    opens georgian200504750 to javafx.fxml;
    exports georgian200504750;
}