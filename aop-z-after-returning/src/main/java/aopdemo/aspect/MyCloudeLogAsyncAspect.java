package aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudeLogAsyncAspect {

    @Before("aopdemo.aspect.LuvAopExpressions.forDapPackageNoGetterAndSetter()")
    public void logToCloudeAsync() {
        System.out.println("\n====>>>> Logging to cloud in async fashion");
    }
}
