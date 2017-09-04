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
            int r = s.nextInt();
            int c = s.nextInt();
            int[][] matrix = new int[r][c];
            for (int j = 0; j < r; j++) {
                s.nextLine();
                for (int k = 0; k < c; k++) {
                    matrix[j][k] = s.nextInt();
                }
            }
            System.out.println(solve(matrix, r, c));

        }
    }
    public static int solve(int[][] matrix, int r, int c){

        int totalTime = 0;
        while(true) {
            totalTime++;
            int numberOfChanges = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(matrix[i][j] == 2) {
                        if (j - 1 >= 0 && matrix[i][j - 1] == 1) {
                            numberOfChanges++;
                            matrix[i][j - 1] = 2;
                        }
                        if (j + 1 < c && matrix[i][j + 1] == 1) {
                            numberOfChanges++;
                            matrix[i][j + 1] = 2;
                        }
                        if (i + 1 < r && matrix[i + 1][j] == 1) {
                            numberOfChanges++;
                            matrix[i + 1][j] = 2;
                        }
                        if (i - 1 >= 0 && matrix[i - 1][j] == 1) {
                            numberOfChanges++;
                            matrix[i - 1][j] = 2;
                        }
                    }
                }
            }
         if(numberOfChanges == 0) {
             break;
         }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(matrix[i][j] == 1){
                    totalTime = -1;
                }
            }
        }
    return totalTime;
    }
}