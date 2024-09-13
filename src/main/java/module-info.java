module org.example.csc311_loan1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.csc311_loan1 to javafx.fxml;
    exports org.example.csc311_loan1;
}