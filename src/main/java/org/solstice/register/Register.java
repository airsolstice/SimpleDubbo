package org.solstice.register;

import org.solstice.common.URL;

import java.util.HashMap;
import java.util.Map;

public class Register {

    public static final Map<String, Map<URL, Class>> REGISTER = new HashMap<>();

    public static void regist(String interfaceName, URL url, Class clazz){
        Map<URL, Class> map = new HashMap<>();
        map.put(url, clazz);
        REGISTER.put(interfaceName, map);
    }

    public static Class get(String interfaceName, URL url){
        return REGISTER.get(interfaceName).get(url);
    }

    public static URL get(String interfaceName){
        return null;
    }

}
