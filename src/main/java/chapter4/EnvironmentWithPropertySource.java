package chapter4;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

public class EnvironmentWithPropertySource {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.refresh();
        ConfigurableEnvironment conf = ctx.getEnvironment();
        MutablePropertySources propertySources = conf.getPropertySources();
        Map<String,Object> appMap = new HashMap<String, Object>();
        appMap.put("user.home","application_home");
//        propertySources.addFirst(new MapPropertySource("prospring5_MAP",appMap));
        propertySources.addLast(new MapPropertySource("prospring5_MAP",appMap));
        System.out.println("user.home"+ System.getProperty("user.home"));
        System.out.println("JAVA_HOME"+ System.getenv("JAVA_HOME"));
        System.out.println("user.home"+ conf.getProperty("user.home"));
        ctx.close();
        System.out.println("application_home"+ conf.getProperty("application_home"));

    }

}
