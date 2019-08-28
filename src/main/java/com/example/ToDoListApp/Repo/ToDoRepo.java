package com.example.ToDoListApp.Repo;

import com.example.ToDoListApp.Model.todolist;
import org.springframework.data.repository.CrudRepository;


public interface ToDoRepo extends CrudRepository<todolist,Integer> {


}
