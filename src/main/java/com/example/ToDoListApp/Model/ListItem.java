package com.example.ToDoListApp.Model;


import javax.persistence.*;

@Entity
@Table(name = "ListItem")
public class ListItem {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Column(name="Item")
    private String item;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId){

        this.itemId=itemId;
    }

}
