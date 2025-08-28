package strings;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses {
    public static List<String> generateValidParentheses(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int openBracket, int closeBracket, int n) {

        if (current.length() == 2 * n) {//((()))  2*3=>6  rrsult.add(((()))); open 3 and close 3
            result.add(current);

        }

        if (openBracket < n) {  //((( => open bracket =3
            backtrack(result, current +"(", openBracket + 1, closeBracket, n);
        }

        if (closeBracket < openBracket) {  //0<3 1<3 2<3 ))) //cureent =((()))  openbrakcet 3 close 3
            backtrack(result, current + ")", openBracket, closeBracket + 1, n);
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of pairs of parentheses (n): ");
        int n = sc.nextInt();

        List<String> result = generateValidParentheses(n);
        System.out.println("Well-formed parentheses for n = " + n + ":");
        System.out.println(result);

        sc.close();

    }
}

