import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;


/**
 * @author shiwa
 */

public class MagicExistsCondition implements Condition {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        logger.info("annotatedTypeMetadata.isAnnotated : ");
        logger.info(annotatedTypeMetadata.isAnnotated(Bean.class.getName()));
        logger.info(annotatedTypeMetadata.isAnnotated(Conditional.class.getName()));
        logger.info("annotatedTypeMetadata.getAnnotationAttributes : ");
        logger.info(annotatedTypeMetadata.getAnnotationAttributes(Bean.class.getName()));
        logger.info(annotatedTypeMetadata.getAnnotationAttributes(Conditional.class.getName()));
        logger.info(annotatedTypeMetadata.getAnnotationAttributes(Bean.class.getName(), true));
        logger.info(annotatedTypeMetadata.getAnnotationAttributes(Conditional.class.getName(), true));
        logger.info("annotatedTypeMetadata.getAllAnnotationAttributes : ");
        logger.info(annotatedTypeMetadata.getAllAnnotationAttributes(Bean.class.getName()));
        logger.info(annotatedTypeMetadata.getAllAnnotationAttributes(Conditional.class.getName()));
        logger.info(annotatedTypeMetadata.getAllAnnotationAttributes(Bean.class.getName(), true));
        logger.info(annotatedTypeMetadata.getAllAnnotationAttributes(Conditional.class.getName(), true));
        return conditionContext.getEnvironment().containsProperty("magic");
    }
}
