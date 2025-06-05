import java.io.Closeable;
import java.io.IOException;

class MyResource implements Closeable {

    @Override
    public void close() throws IOException {
        throw new RuntimeException("Exception Thrown from close method");
    }
}

public class Scenario2 {

    public static void main(String[] args) {
        try (MyResource myresource = new MyResource()) {
            throw new RuntimeException("Thrown from try with resource block");

        } catch (RuntimeException | IOException e) {

            System.out.println("In catch block :" + e.getMessage());
            for (Throwable t : e.getSuppressed()) {
                System.out.println("Suppressed: " + t);
            }

        }
    }
}
