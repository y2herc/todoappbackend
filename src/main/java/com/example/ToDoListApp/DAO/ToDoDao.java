package com.example.ToDoListApp.DAO;

import com.example.ToDoListApp.Model.todolistdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
public class ToDoDao implements DBInterfaceDao {

    final String query_sql="select LISTITEM from todolist";
    final String addItem_query="insert into todolist (Listitem)value(:message)";

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
    public void addItem(String item) {
        todolistdb temp=new todolistdb();
        temp.setListItem(item);
        em.persist(temp);
    }

    @Override
    @Transactional
    public void removeItem(String item) {
        todolistdb temp=em.find(todolistdb.class,item);
        em.remove(temp);
    }
}
