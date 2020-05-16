package chapter5.security;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice(){
        this.securityManager = new SecurityManager();
    }

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        User user = securityManager.getUser();
        if(user == null){
            System.out.println("пользователь недоступен");
        }else if("seva".equals(user.getName())){
            System.out.println("all okey");
        }else {
            System.out.println("user is not good");
            throw new SecurityException();
        }
    }
}
