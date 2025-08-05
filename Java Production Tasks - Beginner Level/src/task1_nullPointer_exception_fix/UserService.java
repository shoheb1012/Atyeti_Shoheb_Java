package task1_nullPointer_exception_fix;

import java.util.Optional;
import java.util.logging.Logger;

/*
WHAT LEARNED:
1. Always check the object itself for null FIRST
2. Then check its properties
3. Order matters: user == null BEFORE user.getName()
4. Choose appropriate defaults based on business logic
5. Logging helps with debugging in production
*/
public class UserService {

    Logger logger = Logger.getLogger(UserService.class.getName());


    public String getUserName(User user) {

        if (user == null) {
            logger.warning("getUserName called with null user");
            return "UNKNOWN";
        }

        String name = user.getUserName();
        if (name == null || name.isEmpty()) {
            logger.info("User has null/empty name, returning default");
            return "UNKNOWN";
        }

        return name.toUpperCase();
    }

    public int getUserAge(User user) {

        if (user == null) {
            logger.warning("getUserAge called with null user");
            return -1;
        }


        int age = user.getUserAge();
        if (age < 0 || age > 150) {
            logger.warning("Invalid age found: " + age);
            return -1;
        }

        return age;
    }

//    public String getUserNameOptional(User user) {
//        return Optional.ofNullable(user)
//                .map(User::getUserName)
//                .filter(name -> !name.isEmpty())
//                .map(String::toUpperCase)
//                .orElse("UNKNOWN");
//    }
}
