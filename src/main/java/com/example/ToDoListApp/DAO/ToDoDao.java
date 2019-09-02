package com.example.ToDoListApp.DAO;

import com.example.ToDoListApp.Model.ListItem;
import com.example.ToDoListApp.Model.todolist;
import com.example.ToDoListApp.Repo.ToDoRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoDao implements DBInterfaceDao {

    final String query_sql="select LISTITEM from todolist";


    @PersistenceContext
    private EntityManager em;

    public ToDoDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TODOLISTPUN");
        em=emf.createEntityManager();
    }

    @Override
    @Transactional
    public List<String> getAll() {

    Query query=em.createNativeQuery(query_sql);
    List<String> result= query.getResultList();
        return result;
    }

    @Override
    public String getItem(int id) {
        return null;
    }

    @Override
    @Transactional
    public void addItem(String listName,String listItem) {

        Query query =em.createQuery("select u from todolist u where u.listName=:name").setParameter("name",listName);
        todolist temp=(todolist) query.getSingleResult();

        todolist List=new todolist();
        ListItem item=new ListItem();
        item.setItem(listItem);
        List.setListName(listName);
        List.getListItems().add(item);

        em.merge(List);
        /*        todolist temp=new todolist();
        temp.setListItem(item);
        em.persist(temp);*/
    }

    @Override
    @Transactional
    public boolean removeItem(String item) {
/*        int i=em.createQuery("delete from todolist where LISTITEM= :item ").setParameter("item",item).executeUpdate();
        // int i=findItembyID(item);
        if(i==1)
            return true;
        else*/
            return false;

    }

}
