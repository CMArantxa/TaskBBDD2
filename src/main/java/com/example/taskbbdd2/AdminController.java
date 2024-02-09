package com.example.taskbbdd2;

import com.example.taskbbdd2.Controller.TaskController;
import com.example.taskbbdd2.ViewsControllers.IControllerviews;

public class AdminController implements IControllerviews {
    private TaskController taskController;
    @Override
    public void setTaskController(TaskController taskController) {
        this.taskController=taskController;

    }
}