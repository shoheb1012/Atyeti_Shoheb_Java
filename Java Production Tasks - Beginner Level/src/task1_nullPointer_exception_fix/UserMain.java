package task1_nullPointer_exception_fix;

public class UserMain {
    public static void main(String[] args) {

        UserService service = new UserService();


        System.out.println("=== Testing Different Scenarios ===");


        User normalUser = new User("John", 25);
        System.out.println("Normal user name: " + service.getUserName(normalUser));
        System.out.println("Normal user age: " + service.getUserAge(normalUser));


        User nullNameUser = new User(null, 30);
        System.out.println("Null name user: " + service.getUserName(nullNameUser));


        User emptyNameUser = new User("", 35);
        System.out.println("Empty name user: " + service.getUserName(emptyNameUser));


        User nullUser = null;
        System.out.println("Null user name: " + service.getUserName(nullUser));
        System.out.println("Null user age: " + service.getUserAge(nullUser));


        User invalidAgeUser = new User("Alice", -5);
        System.out.println("Invalid age user: " + service.getUserAge(invalidAgeUser));

        System.out.println("\n=== All tests completed without crashes! ===");
    }
}

