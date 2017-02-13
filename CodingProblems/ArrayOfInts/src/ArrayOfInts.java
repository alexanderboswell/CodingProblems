/**
 * Created by alexanderboswell on 2/13/17.
 * interviewcake.com
 * Question #3
 * Given an arrayOfInts,
 * find the highestProduct
 * you can get from three of the integers.
 */
public class ArrayOfInts {
    public static void main(String[] args) {

        int[] inputArray = new int[]{1, 10, -5, 1, -100,0,0,0,0,100,100};
//        bruteForceAttempt(inputArray);
//        secondAttempt(inputArray);
        bestAttempt(inputArray);
    }

    /**
     * @param inputArray For this attempt it would take O(n^3) as we would need
     *                   to go through the whole array that many times to get all combinations
     *                   of the product of 3 numbers.
     */
    public static void bruteForceAttempt(int[] inputArray) {

        int highestProduct = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray.length; j++) {
                for (int k = 0; k < inputArray.length; k++) {
                    if (inputArray[i] * inputArray[j] * inputArray[k] > highestProduct) {
                        highestProduct = inputArray[i] * inputArray[j] * inputArray[k];
                    }
                }
            }
        }
        System.out.println("Highest Product: " + highestProduct);
    }

    /**
     * @param inputArray
     * In this attempt we only need to go through the array once.
     * The problem with this problem is that it doesn't keep track
     * properly.
     *
     */
    public static void secondAttempt(int[] inputArray) {
        int x = inputArray[0];
        int y = inputArray[1];
        int z = inputArray[2];
        int highestProduct = x * y * z;
        for (int i = 3; i < inputArray.length; i++) {
            if (x * y * inputArray[i] > highestProduct) {
                highestProduct = x * y * inputArray[i];
//                z = inputArray[i];
            }
            if (x * inputArray[i] * z > highestProduct) {
                highestProduct = x * inputArray[i] * z;
//                y = inputArray[i];
            }
            if (inputArray[i] * y * z > highestProduct) {
                highestProduct = inputArray[i] * y * z;
//                x = inputArray[i];
            }

        }
        System.out.print("Highest Product: " + highestProduct);

    }

    /**
     *
     * @param inputArray
     * This attempt will keep track of both the highest
     * product of 3 things in the array and the highest
     * and lowest of the product of 2. This will allow negative
     * numbers to calculated into the answer.
     */
    public static void bestAttempt(int[] inputArray){
        int highest = Math.max(inputArray[0], inputArray[1]);
        int lowest  = Math.min(inputArray[0], inputArray[1]);

        int highestProductOf2 = inputArray[0] * inputArray[1];
        int lowestProductOf2  = inputArray[0] * inputArray[1];

        int highestProductOf3 = inputArray[0] * inputArray[1] * inputArray[2];
        for (int i = 0; i < inputArray.length; i++) {

            int current = inputArray[i];
            highestProductOf3 = Math.max(Math.max(
                    highestProductOf3,
                    current * highestProductOf2),
                    current * lowestProductOf2);

            highestProductOf2 = Math.max(Math.max(
                    highestProductOf2,
                    current * highest),
                    current * lowest);

            lowestProductOf2 = Math.min(Math.min(
                    lowestProductOf2,
                    current * highest),
                    current * lowest);

            highest = Math.max(highest, current);

            lowest = Math.min(lowest, current);
        }
        System.out.print("highestProduct: " +highestProductOf3);
    }

}
