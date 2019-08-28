package com.example.ToDoListApp.Controller;

import com.example.ToDoListApp.DAO.ToDoDao;
import com.example.ToDoListApp.Model.todolistdb;
import com.example.ToDoListApp.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    Iterable<todolistdb> All(){

        return toDoRepo.findAll();

    }

    @GetMapping(path="/alldao")
    public List<String> Alldao(){



        return toDoDao.getAll();

    }

    @RequestMapping("/ListItem")
    public Optional<todolistdb> ListItem(@RequestParam(name = "id") int id){

            return toDoRepo.findById(id);
    }

    @PostMapping("/addItem")
    public void addItem(@RequestParam(name = "item")String item)
    {
        toDoDao.addItem(item);
    }

    @PostMapping("/removeItem")
    public void removeItem(@RequestParam(name = "item")String item)
    {
        toDoDao.removeItem(item);
    }
}
