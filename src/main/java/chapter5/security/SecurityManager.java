package chapter5.security;



public class SecurityManager {

    private static ThreadLocal<User> threadLocal = new ThreadLocal<User>();

    public void login(String username, int password){
        threadLocal.set(new User(username,password));
    }
    public void logout(){
        threadLocal.set(null);
    }

    public User getUser(){
        return threadLocal.get();
    }

}
