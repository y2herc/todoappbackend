package com.example.ToDoListApp.DAO;

import com.example.ToDoListApp.Model.ListItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DBInterfaceDao {

    public Iterable<ListItem> getAll();
    public String getItem(int id);
    public void addItem(String listName,String listItem);
    boolean removeItem(Integer listItemId);
}
