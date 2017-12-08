import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author shiwa
 */

@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnMyPropertiesCondition.class)
public @interface ConditionalOnMyProperties {

    String name();
}
