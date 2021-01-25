package br.com.apolo.apirev.dao;

import br.com.apolo.apirev.util.JPAUtil;

import javax.persistence.EntityManager;
import java.io.Serializable;

public abstract class GenericDAO<T extends Serializable> {

    private Class<T> aClass;

    protected GenericDAO(Class aClass){
        this.aClass = aClass;
    }

    protected EntityManager getEntityManager(){
        return JPAUtil.getInstance().getEntityManager();
    }
}
