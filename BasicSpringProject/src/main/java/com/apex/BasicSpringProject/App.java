package com.apex.BasicSpringProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.apex.BasicSpringProject.bean.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Person person=(Person)context.getBean("person");
        Person person1=context.getBean(Person.class);
        person.setName("Ram");
        System.out.println("Person"+person);
        System.out.println("Person"+person1);
    }
}
