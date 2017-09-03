/**
 * Created by alexanderboswell on 9/2/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void bubbleSort(int[] a) {
        int totalSwaps = 0;
        for (int i = 0; i < a.length; i++) {
            int numberOfSwaps = 0;

            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int k = a[j];
                    int h = a[j + 1];
                    a[j] = h;
                    a[j +1] = k;
                    numberOfSwaps++;
                }
            }
            totalSwaps += numberOfSwaps;
            if (numberOfSwaps == 0) {
                System.out.println("Array is sorted in " + totalSwaps + " swaps");
                System.out.println("First Element: " + a[0]);
                System.out.println("Last Element: " + a[a.length - 1]);
                break;
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        bubbleSort(a);
    }
}
