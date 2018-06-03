package aopdemo.dao;

import aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public List<Account> findAccounts(){
        List<Account> accounts = new ArrayList<>();

        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madu", "Platinum");
        Account temp3 = new Account("Uuca", "Gold");

        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);

        return accounts;
    }

    public void addAccount(Account account, boolean vipflag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWorks(){
        System.out.println(getClass() + ": DOING Work");
        return false;
    }

    public String getName() {
        System.out.println(getClass()+"in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+"in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+"in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+"in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
