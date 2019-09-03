package com.example.ToDoListApp.Controller;

import com.example.ToDoListApp.DAO.ToDoDao;
import com.example.ToDoListApp.Model.ListItem;
import com.example.ToDoListApp.Model.Todolist;
import com.example.ToDoListApp.Repo.ListItemRepo;
import com.example.ToDoListApp.Repo.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;


@RestController
public class ToDoController {

    @Autowired
    ToDoRepo toDoRepo;

    @Autowired
    ListItemRepo listItemRepo;

    @Autowired
    ToDoDao toDoDao;

    @GetMapping(path="/all")
    @Produces("text/plain")
    public @ResponseBody
    Iterable<ListItem> All(){

        return listItemRepo.findAll();

    }

    @GetMapping(path="/alldao")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<ListItem> Alldao(){

        return toDoDao.getAll();

    }

    @RequestMapping("/ListItem")
    public Optional<Todolist> ListItem(@RequestParam(name = "id") int id){

            return toDoRepo.findById(id);
    }

    @PostMapping("/addItem")
    public void addItem(@RequestParam(name = "list")String listName,@RequestParam(name = "item")String listItem)
    {
        toDoDao.addItem(listName,listItem);
    }

    @PostMapping("/removeItem")
    public boolean removeItem(@RequestParam(name = "listItemId")Integer listItemId)
    {
        return toDoDao.removeItem(listItemId);
    }

    @PostMapping("/removeAll")
    public void removeAll()
    {
        toDoRepo.deleteAll();
        listItemRepo.deleteAll();

    }
}
