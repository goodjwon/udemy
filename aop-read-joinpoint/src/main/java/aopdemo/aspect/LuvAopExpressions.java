package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(public * aopdemo.dao.*.*(..))")
    public void forDapPackage(){};

    @Pointcut("execution(public * aopdemo.dao.*.get*(..))")
    public void getter(){};

    @Pointcut("execution(public * aopdemo.dao.*.set*(..))")
    public void setter(){};

    @Pointcut("forDapPackage() && !(getter() || setter())")
    public void forDapPackageNoGetterAndSetter(){};

}
