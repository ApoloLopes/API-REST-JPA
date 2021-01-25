package br.com.apolo.apirev.dao;

import br.com.apolo.apirev.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public abstract class GenericDAO<T extends Serializable> {

    private Class<T> aClass;

    protected GenericDAO(Class aClass){
        this.aClass = aClass;
    }

    protected EntityManager getEntityManager(){
        return JPAUtil.getInstance().getEntityManager();
    }

    public T findById(Long id){
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        T entity = (T) manager.find(aClass, id);
        manager.getTransaction().commit();
        manager.close();

        return entity;
    }

    public List<T> findAll(){
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();

        Query query = manager.createQuery("from" + aClass.getSimpleName());

        List<T> entities = query.getResultList();

        manager.getTransaction().commit();
        manager.close();

        return entities;
    }

    public long count(){
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();

        Query query = manager.createQuery("select count(c) from " + aClass.getSimpleName()+"c");

        long count = (Long) query.getSingleResult();
        manager.getTransaction().commit();
        manager.close();
        return count;
    }

    public T findOne(String jpql, Object...params){
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();

        Query query = manager.createQuery(jpql);

        for (int i = 0; i < params.length; i++){
            query.setParameter(i+1, params);
        }
        T entity = (T) query.getSingleResult();
        manager.getTransaction().commit();
        manager.close();

        return entity;

    }

    public List<T> find(String jpql, Object...params){
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();

        Query query = manager.createQuery(jpql);

        for (int i = 0; i < params.length; i++){
            query.setParameter(i+1, params);
        }
        List<T> entities = query.getResultList();
        manager.getTransaction().commit();
        manager.close();

        return entities;

    }

    public void save(T entity){
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
        manager.close();
    }

    public void update(T entity){
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.merge(entity);
        manager.getTransaction().commit();
        manager.close();
    }

    public void delete(Long id){
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.remove(manager.getReference(aClass, id));
        manager.getTransaction().commit();
        manager.close();
    }
}
