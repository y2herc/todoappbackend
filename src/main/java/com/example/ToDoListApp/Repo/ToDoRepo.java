package com.example.ToDoListApp.Repo;

import com.example.ToDoListApp.Model.Todolist;
import org.springframework.data.repository.CrudRepository;


public interface ToDoRepo extends CrudRepository<Todolist,Integer> {


}
