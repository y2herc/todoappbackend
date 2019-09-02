package com.example.ToDoListApp.DAO;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DBInterfaceDao {

    public List<String> getAll();
    public String getItem(int id);
    public void addItem(String listName,String listItem);

    @Transactional
    boolean removeItem(String item);
}
