package udana;

import org.apache.catalina.session.StandardSessionFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="person_data")
class Person {

    @Id
    private Long id;

    @Column(name="first_name" , nullable=false)
    private String firstName;

    @Column(name="last_name" , nullable=false)
    private String lastName;


    public String getFullName() {
        return firstName + "" + lastName;
    }

    public static void main(String[] args) {
        System.out.println("Work Hard !!!");
    }
}


@Configuration
class PersonService {

    @Bean
    List<Person> findAll() {
        try
        {
            return ServiceDaoImpl.getSession().createCriteria(Person.class).list();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
