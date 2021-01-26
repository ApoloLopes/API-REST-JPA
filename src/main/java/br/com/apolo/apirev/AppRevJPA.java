package br.com.apolo.apirev;

import br.com.apolo.apirev.dao.PersonDAO;
import br.com.apolo.apirev.entity.Person;

public class AppRevJPA {

    public static void main(String[] args){

        insertPerson();
    }

    private static void insertPerson(){

        /*Person p1 = new Person();
        p1.setFirstName("Ana Maria");
        p1.setLastName("da Silva");
        p1.setAge(29);

        new PersonDAO().save(p1);
        System.out.println(p1.toString());*/

        /*Person p2 = new Person();
        p2.setFirstName("Luna");
        p2.setLastName("Figueira");
        p2.setAge(36);

        new PersonDAO().save(p2);
        System.out.println(p2.toString());

        Person p3 = new Person();
        p3.setFirstName("Carlos");
        p3.setLastName("Rodrigues");
        p3.setAge(25);

        new PersonDAO().save(p3);
        System.out.println(p3.toString());*/

        Person p4 = new Person();
        p4.setFirstName("Carlfos");
        p4.setLastName("Rodrigfues");
        p4.setAge(25);

        new PersonDAO().save(p4);
        System.out.println(p4.toString());

    }
}
