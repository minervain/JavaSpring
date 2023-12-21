module com.example.aou {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aou to javafx.fxml;
    exports com.example.aou;
}