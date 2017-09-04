/**
 * Created by alexanderboswell on 9/4/17.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int numberOfTests = s.nextInt();
        for (int i = 0; i < numberOfTests; i++) {
            s.nextLine();
            String t = s.nextLine();
            int x = s.nextInt();
            URlifyString(t, x);
        }
    }
    public static void URlifyString(String s, int count){
        s = s.trim();
        s = s.replace(" ", "%/20");
        System.out.println(s);
    }
}