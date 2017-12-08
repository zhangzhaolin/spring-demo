import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author shiwa
 */

@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface InheritedTest {

    String value() default "使用了@Inherited注解的class";
}
