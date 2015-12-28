import tasks.AnnotatedBean;
import tasks.TestAnnotationParser;

/**
 * 
 */

/**
 * @author pzoli
 *
 */
public class Homework4Annotation {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TestAnnotationParser parser = new TestAnnotationParser();
        try {
            parser.parse(AnnotatedBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
