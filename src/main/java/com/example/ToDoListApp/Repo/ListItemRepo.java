package com.example.ToDoListApp.Repo;

import com.example.ToDoListApp.Model.ListItem;
import org.springframework.data.repository.CrudRepository;


public interface ListItemRepo extends CrudRepository<ListItem,Integer> {

}
