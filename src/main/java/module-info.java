module org.example.scheresteinpapier {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.scheresteinpapier to javafx.fxml;
    exports org.example.scheresteinpapier;
    exports org.example.scheresteinpapier.Controller;
    opens org.example.scheresteinpapier.Controller to javafx.fxml;
}