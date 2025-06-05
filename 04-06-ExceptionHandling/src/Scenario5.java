public class Scenario5 {

        public static String demo() {
            try {
                return "shoheb";
            } catch (RuntimeException e) {
              return "pathan";
            }
            finally {
                return "From finally";
            }
        }

        public static void main(String[] args) {
            System.out.println(demo());
        }
    }

