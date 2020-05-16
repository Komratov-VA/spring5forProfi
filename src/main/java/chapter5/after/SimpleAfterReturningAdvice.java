package chapter5.after;

import chapter5.Guitarist;
import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {

    public static void main(String[] args) {
        Guitarist guitarist = new Guitarist();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(guitarist);
        proxyFactory.addAdvice(new SimpleAfterReturningAdvice());
        Guitarist guitarist1 = (Guitarist)proxyFactory.getProxy();
        guitarist1.sing();
    }

    public void afterReturning(Object o, Method method, Object[] objects, Object o1)
        throws Throwable {
        System.out.println("sss");
    }
}
