package com.example.ToDoListApp.Model;


import org.jboss.logging.Field;

import javax.persistence.*;

@Entity
@Table(name = "TODOLIST")
public class todolistdb {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name = "LISTITEM")
    private String ListItem;

    public Integer getId() {
        return Id;
    }

    public String getListItem() {
        return ListItem;
    }
    public void setId(Integer id) {
        this.Id = id;
    }
    public void setListItem(String listItem) {
        ListItem = listItem;
    }
}