import java.util.Scanner;

/**
 * Created by alexanderboswell on 2/25/17.
 */
public class ArrayLeftRotation {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int b[] = new int[n];
            for (int i=0; i <a.length ; i++){
                b[i] = a[(i+k) % a.length];
            }
            for (int i=0; i<a.length ; i++){
                System.out.print(b[i]+" ");
            }

        }
}
