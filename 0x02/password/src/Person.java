

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


public class Person {

    public boolean checkUser(String username){
        return username.length() > 8 && !username.matches("^(?=.*[@!#$%^&*()/\\\\])");
    }

    public boolean checkPassword(String password){
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#$%^&*., ?]).+$") && password.matches("^(?=.*[@!#$%^&*()/\\\\])") && password.length() >= 8;
    }
}
