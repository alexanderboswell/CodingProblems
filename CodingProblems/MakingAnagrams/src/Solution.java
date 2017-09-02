/**
 * Created by alexanderboswell on 9/2/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int numberNeeded(String first, String second) {
        Hashtable<Character,Integer> firstString = new Hashtable<>();
        Hashtable<Character, Integer> secondString = new Hashtable<>();
        int diff = 0;
        for (int i = 0; i < first.length(); i++) {
            if (firstString.get(first.charAt(i)) != null) {
                int j = firstString.get(first.charAt(i));
                j += 1;
                firstString.put(first.charAt(i), j);
            } else {
                firstString.put(first.charAt(i), 1);
            }
        }
        for (int i = 0; i < second.length(); i++) {
            if (secondString.get(second.charAt(i)) != null) {
                int j = secondString.get(second.charAt(i));
                j += 1;
                secondString.put(second.charAt(i), j);
            } else {
                secondString.put(second.charAt(i), 1);
            }
        }

        Set<Character> intersectKeys = new TreeSet<>(firstString.keySet());
        intersectKeys.retainAll(secondString.keySet());
        for (Character key : intersectKeys) {
            if ( firstString.get(key) != secondString.get(key)) {
                diff += Math.abs(firstString.get(key) - secondString.get(key));
            }
        }
        Set<Character> differenceKeys = new TreeSet<>(firstString.keySet());
        differenceKeys.removeAll(secondString.keySet());
        Set<Character> diff2keys = new TreeSet<>(secondString.keySet());
        diff2keys.removeAll(firstString.keySet());
        differenceKeys.addAll(diff2keys);
        for (Character key : differenceKeys) {
            if (firstString.get(key) != null) {
                diff += firstString.get(key);
            } else if (secondString.get(key) != null) {
                diff += secondString.get(key);
            }
        }


        return diff;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
