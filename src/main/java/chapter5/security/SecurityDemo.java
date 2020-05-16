package chapter5.security;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityDemo {

    public static void main(String[] args) {

        SecureBean secureBean = new SecureBean();
        SecurityManager securityManager = new SecurityManager();
        securityManager.login("seva§",222);
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SecurityAdvice());
        proxyFactory.setTarget(secureBean);

        SecureBean secureBean1 = (SecureBean) proxyFactory.getProxy();

        secureBean1.writeMessage();
     }

}
