package aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {

    public boolean addSellay(){
        System.out.println(getClass() + ": DOING STUFF : ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }

    public void goToSleep(){
        System.out.println(getClass() + ": go to Sleep now...");
    }

}
