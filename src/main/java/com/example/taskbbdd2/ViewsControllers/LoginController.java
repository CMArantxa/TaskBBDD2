package com.example.taskbbdd2.ViewsControllers;

import com.example.taskbbdd2.Controller.TaskController;
import com.example.taskbbdd2.TaskApplication;
import com.example.taskbbdd2.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    //Declarar elementos de la vista
    @FXML
    protected TextField TxtUsuario;
    @FXML
    protected Label lblUsuario;
    @FXML
    protected Label lblPass;
    @FXML
    protected TextField TxtPass;
    @FXML
    protected Button btnLogin;
    @FXML
    protected Label lblError;

    //Creo el objeto principal
    public TaskController taskController=new TaskController();
    //Metodos
    public void LoginAct (ActionEvent actionEvent){
        if (taskController.login(TxtUsuario.getText(),TxtPass.getText())){
            String view="";
            String titleWindow;
           if (taskController.isAdmin()){
               //mostrar vista administrador
               view="admin_view.fxml";
               titleWindow="Admin";
               ;
           }else{
               //mostrar vista usuario
               view="user_view.fxml";
               titleWindow="User";
           }
            FXMLLoader fmxlLoader= new FXMLLoader(TaskApplication.class.getResource(view));
            try {
                Parent root=fmxlLoader.load();
                //UserController userController= fmxlLoader.getController();
                Scene scene=new Scene(root);
                Stage stage=new Stage();
                stage.setTitle(titleWindow);
                stage.setScene(scene);
                stage.show();
                Node source=(Node) actionEvent.getSource();
                Stage stage1=(Stage) source.getScene().getWindow();
                stage1.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            lblError.setText("Usuario o contraseñe incorrecta");
        }
    }
}
