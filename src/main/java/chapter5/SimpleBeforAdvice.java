package chapter5;

import java.lang.reflect.Method;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleBeforAdvice implements MethodBeforeAdvice {

    public static void main(String[] args) {
        Guitarist guitarist = new Guitarist();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleBeforAdvice());
        proxyFactory.setTarget(guitarist);
        Guitarist proxy = (Guitarist)proxyFactory.getProxy();
        proxy.sing();
    }

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("seva");
    }
}
