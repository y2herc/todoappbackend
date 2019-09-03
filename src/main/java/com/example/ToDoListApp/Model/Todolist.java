package com.example.ToDoListApp.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TODOLIST")
public class Todolist {

    @Id
    @Column(name = "todolist_id")
    @GeneratedValue
    private Integer Id;

    @Column
    private String listName;

    @OneToMany( mappedBy ="todolist",cascade = {CascadeType.ALL})
    private List<ListItem> listItems=new ArrayList<ListItem>();


    public List<ListItem> getListItems() {
        return listItems;
    }

    public void setListItems(List<ListItem> listItems) {
        this.listItems = listItems;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

}
