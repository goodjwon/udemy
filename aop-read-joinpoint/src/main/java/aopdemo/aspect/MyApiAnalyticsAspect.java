package aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("aopdemo.aspect.LuvAopExpressions.forDapPackageNoGetterAndSetter()")
    public void perFormApiAnalytics() {
        System.out.println("\n====>>>> Perform reuse API Call");
    }
}
