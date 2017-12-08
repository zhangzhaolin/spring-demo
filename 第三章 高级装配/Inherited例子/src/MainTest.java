import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author shiwa
 */

public class MainTest {

    public static void main(String []args) throws Exception{

        Class<Children> aClass = Children.class;

        // 对类进行测试
        System.out.println("对类进行测试 :");
        if(aClass.isAnnotationPresent(InheritedTest.class)){
            System.out.println(aClass.getAnnotation(InheritedTest.class).value());
        }
        if(aClass.isAnnotationPresent(InheritedTest2.class)){
            System.out.println(aClass.getAnnotation(InheritedTest2.class).value());
        }
        System.out.println();

        //对方法 进行测试
        System.out.println("对方法进行测试 :");
        Method method = aClass.getMethod("method", null);
        if(method.isAnnotationPresent(InheritedTest.class)){
            System.out.println(method.getAnnotation(InheritedTest.class).value());
        }
        if(method.isAnnotationPresent(InheritedTest2.class)){
            System.out.println(method.getAnnotation(InheritedTest2.class).value());
        }
        System.out.println();

        //对方法2 进行测试
        System.out.println("对方法2进行测试 :");
        Method method2 = aClass.getMethod("method2", null);
        if(method2.isAnnotationPresent(InheritedTest.class)){
            System.out.println(method2.getAnnotation(InheritedTest.class).value());
        }
        if(method2.isAnnotationPresent(InheritedTest2.class)){
            System.out.println(method2.getAnnotation(InheritedTest2.class).value());
        }
        System.out.println();

        //对属性测试
        System.out.println("对属性进行测试 :");
        Field field = aClass.getField("a");
        if(field.isAnnotationPresent(InheritedTest.class)){
            System.out.println(field.getAnnotation(InheritedTest.class).value());
        }
        if(field.isAnnotationPresent(InheritedTest2.class)){
            System.out.println(field.getAnnotation(InheritedTest2.class).value());
        }

    }
}
