public class Scenario6 {
    public static void main(String[] args) {

       try {
           throw null; // no compile error
       } catch (RuntimeException e) {
           System.out.println(e.getMessage());
       }

    }
}