/**
 * Created by alexanderboswell on 9/2/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean isBalanced(String expression) {
        Stack<Character> s = new Stack<>();
        boolean check = true;
        for (int i = 0; i < expression.length(); i++) {
            if(!s.isEmpty()) {
                if ((expression.charAt(i) == ']' && s.peek() == '[') ||
                        (expression.charAt(i) == '}' && s.peek() == '{') ||
                        (expression.charAt(i) == ')' && s.peek() == '(')) {
                    s.pop();

                } else if (expression.charAt(i) == ']' || expression.charAt(i) == ')' || expression.charAt(i) == '}') {
                    return false;
                } else {
                    s.push(expression.charAt(i));
                }
            } else {
                s.push(expression.charAt(i));
            }
        }
        if(s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
