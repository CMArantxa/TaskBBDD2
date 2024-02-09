package com.example.taskbbdd2.ViewsControllers;

import com.example.taskbbdd2.Controller.TaskController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
           if (taskController.isAdmin()){
               //mostrar vista administrador
               System.out.println("admin");
           }else{
               //mostrar vista usuario
               System.out.println("user");
           }
        }else{
            lblError.setText("Usuario o contraseñe incorrecta");
        }
    }
}
