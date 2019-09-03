package com.example.ToDoListApp.Service;

import com.example.ToDoListApp.DAO.ToDoDao;
import com.example.ToDoListApp.Model.ListItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ToDoListService {


    @Autowired
    ToDoDao toDoDao;

    private static final String[] allTodos = {"Daddy", "Mommy", "Brother", "Sister", "Dog"};

    public Iterable<ListItem> getAll(){

        return toDoDao.getAll();
    }

    public static String getItembyId(int Id){

        return allTodos[Id];
    }

    public static int getlength(){

        return allTodos.length;
    }
}
