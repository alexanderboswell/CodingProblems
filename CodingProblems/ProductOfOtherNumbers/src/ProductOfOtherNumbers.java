import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexanderboswell on 2/11/17.
 *
 * interviewcake.com Question #2
 *
 * You have an array of integers,
 * and for each index you want to find the product
 * of every integer except the integer at that index.
 */
public class ProductOfOtherNumbers {
    public static void main(String[] args) {
        int[] inputArray = new int[]{1,7,3,4};
        bruteForceAttempt(inputArray);

    }
    public static Object[] bruteForceAttempt(int[] inputArray){
        List<Integer> outputList = new ArrayList<Integer>();
        for (int i = 0; i < inputArray.length; i++) {
            int product = 1;
            for (int j = 0; j < inputArray.length; j++) {
                if(inputArray[i]!=inputArray[j]){
                    product = product * inputArray[j];
                }
            }
            outputList.add(product);
        }

        return outputList.toArray();
    }
}
