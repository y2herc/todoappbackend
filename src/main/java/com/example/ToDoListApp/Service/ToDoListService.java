package com.example.ToDoListApp.Service;

import com.example.ToDoListApp.DAO.ToDoDao;
import com.example.ToDoListApp.Model.todolistdb;
import com.example.ToDoListApp.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class ToDoListService {


    @Autowired
    ToDoDao toDoDao;

    private static final String[] allTodos = {"Daddy", "Mommy", "Brother", "Sister", "Dog"};

    public List<String> getAll(){

        return toDoDao.getAll();
    }

    public static String getItembyId(int Id){

        return allTodos[Id];
    }

    public static int getlength(){

        return allTodos.length;
    }
}
