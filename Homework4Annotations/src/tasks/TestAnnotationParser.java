/**
 * 
 */
package tasks;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import annotation.Test;

public class TestAnnotationParser {
    public void parse(Class clazz) throws Exception {
        Method[] methods = clazz.getMethods();
        Field[] fields = clazz.getFields();
        int pass = 0;
        int fail = 0;

        for (Field field : fields) {
            if (field.isAnnotationPresent(Test.class)) {
                Test test = field.getAnnotation(Test.class);
                String info = test.info();
                System.out.println(field.getName() + " annotated with Test.info=" + info);
            }
        }
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                String info = test.info();
                
                Class<?> expected = test.expected();
                try {
                    // try to invoke the method with param
                    method.invoke(AnnotatedBean.class.newInstance(), info);
                    pass++;
                } catch (Exception e) {
                    if (e.getCause().getClass() != expected) {
                        System.out.println("Expected exception:"+expected+", throwed exception:"+e.getCause().getClass()+" with message:"+e.getCause().getLocalizedMessage());
                        fail++;
                    } else {
                        pass++;
                    }
                }
                
                if ("AWESOME".equals(info)) {
                    System.out.println(method.getName() + " method info is set by default.");                   
                } else {
                    System.out.println(method.getName() + " method info is "+info);
                }
                
                System.out.println("pass:"+pass+"; fail:"+fail);
            }
        }
    }

}