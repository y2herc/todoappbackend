package com.example.ToDoListApp;

import com.example.ToDoListApp.Model.todolistdb;
import org.springframework.data.repository.CrudRepository;


public interface ToDoRepo extends CrudRepository<todolistdb,Integer> {


}
