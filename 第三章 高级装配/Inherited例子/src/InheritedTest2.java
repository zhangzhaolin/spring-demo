import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author shiwa
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface InheritedTest2 {
    String value() default "没有使用@Inherited注解的class";
}
