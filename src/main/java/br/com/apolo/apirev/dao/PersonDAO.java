package br.com.apolo.apirev.dao;

import br.com.apolo.apirev.entity.Person;

public class PersonDAO extends GenericDAO<Person>{

    public PersonDAO(){
        super(Person.class);
    }
}
