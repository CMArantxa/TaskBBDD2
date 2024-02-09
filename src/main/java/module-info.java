module com.example.taskbbdd2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.taskbbdd2 to javafx.fxml;
    exports com.example.taskbbdd2;
    exports com.example.taskbbdd2.ViewsControllers;
    opens com.example.taskbbdd2.ViewsControllers to javafx.fxml;

}