module org.example.scheresteinpapier {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.scheresteinpapier to javafx.fxml;
    exports org.example.scheresteinpapier;
}