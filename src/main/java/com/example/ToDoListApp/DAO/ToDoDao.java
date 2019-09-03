package com.example.ToDoListApp.DAO;

import com.example.ToDoListApp.Model.ListItem;
import com.example.ToDoListApp.Model.Todolist;
import com.example.ToDoListApp.Repo.ListItemRepo;
import com.example.ToDoListApp.Repo.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoDao implements DBInterfaceDao {

    final String query_sql="select u.list_name,v.item from todolist u inner join listitem v on u.todolist_id=v.todolist_id";

    @PersistenceContext
    private EntityManager em;

    public ToDoDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TODOLISTPUN");
        em=emf.createEntityManager();
    }

    @Override
    @Transactional
    public Iterable<ListItem> getAll() {

    Query query=em.createNativeQuery(query_sql);
        Iterable<ListItem> result= query.getResultList();
        return result;
    }

    @Override
    public String getItem(int id) {
        return null;
    }

    @Override
    @Transactional
    public void addItem(String listName,String listItem) {


        Todolist list=new Todolist();
        ListItem item=new ListItem();
        item.setItem(listItem);

     try {
          Query query = em.createQuery("select u from Todolist u where u.listName=:name").setParameter("name", listName);
          list = (Todolist) query.getSingleResult();
          list.getListItems().add(item);
          item.setTodolist(list);
          em.merge(list);
      }
      catch (NoResultException e){
          list=null;
      }

      if (list==null) {
          Todolist newList=new Todolist();
          newList.setListName(listName);
          newList.getListItems().add(item);
          item.setTodolist(newList);
          em.merge(newList);
        }
    }

    @Override
    @Transactional
    public boolean removeItem(Integer listItemId) {

        //listItemRepo.deleteById(listItemId);

       // int i=findItembyID(item);


        return false;


    }

}
