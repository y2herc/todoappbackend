package com.example.ToDoListApp.Model;


import javax.persistence.*;

@Entity
@Table(name = "LISTITEM")
public class ListItem {
    @Id
    @Column(name = "listitem_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;

    @Column(name="item")
    private String item;

    @ManyToOne
    @JoinColumn(name="todolist_id")
    private Todolist todolist;

    public Todolist getTodolist() {
        return todolist;
    }

    public void setTodolist(Todolist todolist) {
        this.todolist = todolist;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId){

        this.itemId=itemId;
    }

}
