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
        secondAttempt(inputArray);
    }

    /**
     *
     * @param inputArray
     * This algorithm would run in O(n^2) as for
     * each calculation it would go through the array
     * for each number in the array to find the product
     * of all other numbers besides that one.
     */
    public static void bruteForceAttempt(int[] inputArray){
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
        printArray(outputList.toArray());
    }

    /**
     *
     *  @param inputArray
     * This attempt involves finding the product of what comes before
     * that index and what comes after. The product of these two will
     * give us the product of all the numbers except the one at the index.
     * This takes 3 arrays which are all size n, so space complexity
     * is O(3n). Each for loop has to go through the array once so the
     * time complexity will be O(3n) which reduces to O(n).
     */
    public static void secondAttempt(int[] inputArray){
        int[] productOfAllIntsBeforeIndex = new int[inputArray.length];
        int productSoFar = 1;
        for (int i = 0; i < inputArray.length; i++) {
            productOfAllIntsBeforeIndex[i] = productSoFar;
            productSoFar *= inputArray[i];
        }
        int[] productsOfAllIntsAfterIndex = new int[inputArray.length];

        productSoFar = 1;
        for (int i = inputArray.length - 1; i >= 0; i--) {
            productsOfAllIntsAfterIndex[i] = productSoFar;
            productSoFar *= inputArray[i];
        }
        List<Integer> outputList = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            outputList.add(productOfAllIntsBeforeIndex[i] * productsOfAllIntsAfterIndex[i]);
        }
        printArray(outputList.toArray());

    }
    public static void printArray(Object[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
