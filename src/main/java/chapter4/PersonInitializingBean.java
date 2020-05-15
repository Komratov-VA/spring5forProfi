package chapter4;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonInitializingBean implements InitializingBean {

    private String name;
    private Integer age = Integer.MIN_VALUE;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(Integer age){
        this.age = age;
    }


    public static void main(String[] args) {

        GenericXmlApplicationContext genericXmlApplicationContext = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("chapter4/PersonContext.xml");
        genericXmlApplicationContext.refresh();
//        String[] strings =genericXmlApplicationContext.getBeanFactory().getBeanDefinitionNames();
//        System.out.println(strings[0]);
//        genericXmlApplicationContext.refresh();
//        Person person = (Person) genericXmlApplicationContext.getBean("firstPerson");
//        System.out.println(person.age);
//        System.out.println(person.name);
        genericXmlApplicationContext.close();
    }

    public void afterPropertiesSet() throws Exception {
        if(name == null){
            this.name = "Bboy";
        }
        if(age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("age is too small");
        }
    }

}
//<dependency>
//<groupId>org.springframework</groupId>
//<artifactId>spring-context</artifactId>
//<version>3.0.2.RELEASE</version>
//</dependency>
