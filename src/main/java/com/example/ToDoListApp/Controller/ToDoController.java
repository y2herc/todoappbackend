package com.example.ToDoListApp.Controller;

import com.example.ToDoListApp.DAO.ToDoDao;
import com.example.ToDoListApp.Model.todolist;
import com.example.ToDoListApp.Repo.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.List;
import java.util.Optional;


@RestController
public class ToDoController {

    @Autowired
    ToDoRepo toDoRepo;

    @Autowired
    ToDoDao toDoDao;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<todolist> All(){

        return toDoRepo.findAll();

    }

    @GetMapping(path="/alldao",produces="application/json")
    public List<String> Alldao(){

        return toDoDao.getAll();

    }

    @RequestMapping("/ListItem")
    public Optional<todolist> ListItem(@RequestParam(name = "id") int id){

            return toDoRepo.findById(id);
    }

    @PostMapping("/addItem")
    public void addItem(@RequestParam(name = "list")String listName,@RequestParam(name = "item")String listItem)
    {
        toDoDao.addItem(listName,listItem);
    }

    @PostMapping("/removeItem")
    public boolean removeItem(@RequestParam(name = "item")String item)
    {
        if(toDoDao.removeItem(item))
            return true;
        else
            return false;
    }

    @PostMapping("/removeAll")
    public void removeAll()
    {
        toDoRepo.deleteAll();

    }
}
