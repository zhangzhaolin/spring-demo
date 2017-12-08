import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

/**
 * @author shiwa
 */
public class OnMyPropertiesCondition implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取注解上的name属性
        Object propertiesName = metadata.getAnnotationAttributes(ConditionalOnMyProperties.class.getName()).get("name");
        if (propertiesName != null){
            // 检查环境中是否存在该属性的值
            boolean value = context.getEnvironment().containsProperty(propertiesName.toString());
            if(value){
                return true;
            }
        }
        return false;
    }
}
