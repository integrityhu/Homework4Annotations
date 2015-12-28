package tasks;
import java.io.IOException;

import annotation.Test;

public class AnnotatedBean {
    
    @Test(info = "segment")
    public String property;
    
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    @Test(expected=Exception.class)
    public void foo(String myParam) throws Exception {
        System.out.println("This is " + myParam);
        throw new Exception("message");
    }

    @Test(info="bar case", expected=IOException.class)
    public void bar(String myParam) throws Exception {
        System.out.println("This is " + myParam);
        throw new Exception("failed bar method");
    }

}