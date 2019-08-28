package com.example.ToDoListApp.DAO;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DBInterfaceDao {

    public List<String> getAll();
    public String getItem(int id);
    public void addItem(String item);

    @Transactional
    void removeItem(String item);
}
