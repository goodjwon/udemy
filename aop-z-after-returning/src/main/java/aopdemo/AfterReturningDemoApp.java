package aopdemo;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MemberShipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {
        // read spring config
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);


        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accountList = theAccountDAO.findAccounts();

        System.out.println("\nMain Program: AfterReturningApp");
        System.out.println("---");
        System.out.println(accountList);
        System.out.println("\n");


        context.close();
    }
}
