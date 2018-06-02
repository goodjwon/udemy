package aopdemo.aspect;


import aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("aopdemo.aspect.LuvAopExpressions.forDapPackageNoGetterAndSetter()")
    public void beforeAddAccountAdivce(JoinPoint theJoinPoint) {
        System.out.println("\n====>>>> Executing @Before advice on addAccount()");

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("==>MethodSingature is "+methodSignature);

        Object[] args = theJoinPoint.getArgs();

        for(Object tempArg:args){

            if(tempArg instanceof Account){

                Account theAccount = (Account) tempArg;

                System.out.println("ACCOUNT NAEM : "+theAccount.getName());
                System.out.println("ACCOUNT LEVEL: "+theAccount.getLevel());
            }

        }
    }
}
