public class Scenario1 {
    public static void main(String[] args) {

        try {
            try {
                throw new RuntimeException("From try block ");
            } catch (RuntimeException e) {
                System.out.println("Caught " + e.getMessage());
                throw new RuntimeException("from catch block");
            } finally {
                throw new RuntimeException("From finally block ");
            }
        } catch (RuntimeException e) {
            //here exception come from the finally block and handle by this catch block so it ovverides the catch block exception.
            System.out.println("Outer catch block :" + e.getMessage());
        }
    }
    // If both catch and finally throw exceptions, the one from finally overrides the one from catch.
}
