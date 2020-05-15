package chapter4;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonBeanNameAware implements BeanNameAware {

    private String name;

    public void setBeanName(String s) {
        this.name = s;
    }



    @Override
    public String toString() {
        return "bean name = " + name;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext genericXmlApplicationContext = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("chapter4/PersonContext.xml");
        genericXmlApplicationContext.refresh();
        PersonBeanNameAware personBeanNameAware = (PersonBeanNameAware)genericXmlApplicationContext.getBean("personBeanNameAware");
        System.out.println(personBeanNameAware.toString());
    }
}
