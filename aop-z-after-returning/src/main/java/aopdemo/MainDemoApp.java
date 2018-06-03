package aopdemo;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MemberShipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        // read spring config
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);


        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String serviceCode = theAccountDAO.getServiceCode();

        MemberShipDAO theMemberShipDAO = context.getBean("memberShipDAO", MemberShipDAO.class);

        // call the business method
        Account account = new Account();
        account.setName("goodjwon");
        account.setLevel("Gold");

        theAccountDAO.addAccount(account, true);
        theAccountDAO.doWorks();

        theMemberShipDAO.addSellay();
        theMemberShipDAO.goToSleep();

        context.close();
    }
}
