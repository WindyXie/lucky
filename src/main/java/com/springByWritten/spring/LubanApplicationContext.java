package com.springByWritten.spring;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.springByWritten.service.UserService;

@SuppressWarnings("all")
public class LubanApplicationContext {

    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();


    public LubanApplicationContext(Class configClass) {
        List<Class> classList = scan(configClass);
        for (Class clazz : classList) {
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setBeanClass(clazz);

            Component component = (Component) clazz.getAnnotation(Component.class);
            // 4. 得到Component指示的beanName
            String beanName = component.value();

            if (clazz.isAnnotationPresent(Scope.class)) {
                Scope scope = (Scope) clazz.getAnnotation(Scope.class);
                beanDefinition.setScope(scope.value());
            } else {
                beanDefinition.setScope("singleton");
            }
            
            beanDefinitionMap.put(beanName, beanDefinition);
        }

        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if ("singleton".equals(beanDefinition.getScope())) {
                // 生成单例bean
                Object bean = createBean(beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }
    }

    private Object createBean(BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            // 实例化
            Object bean = beanClass.getDeclaredConstructor().newInstance();
            // 填充属性
            Field[] fields = beanClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    Object userService = getBean(field.getName());
                    field.setAccessible(true);
                    field.set(bean, userService);
                }
            }
            // aware
            // 初始化
            return bean;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Class> scan(Class configClass) {
        List<Class> classList = new ArrayList<>();
        // 1. 扫描类，
        ComponentScan componentScan = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
        String scanPath = componentScan.value();

        scanPath = scanPath.replace(".", "/");

        // 2. 如何扫描类(粗糙)，得到ComponentScan注解指示的目录
        ClassLoader classLoader = LubanApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(scanPath);

        // 3. 遍历目录，扫描带Component注解的类
        File file = new File(resource.getFile());   // 目录
        File[] files = file.listFiles();
        for (File f : files) {
            String absPath = f.getAbsolutePath();
            absPath = absPath.substring(absPath.indexOf("com"), absPath.indexOf(".class"));
            absPath = absPath.replace("/", ".");
            try {
                Class<?> clazz = classLoader.loadClass(absPath);
                classList.add(clazz);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return classList;
    }

    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if ("prototype".equals(beanDefinition.getScope())) {
            return createBean(beanDefinition);
        } else {
            Object bean = singletonObjects.get(beanName);
            if (bean == null) {
                Object o = createBean(beanDefinition);
                singletonObjects.put(beanName, o);
                return o;
            }
            return bean;
        }
    }
}
