/**
 * Created by alexanderboswell on 9/2/17.
 */
import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public Solution(String magazine, String note) {
        magazineMap = new HashMap<>();
        noteMap = new HashMap<>();
        String[]magWords = magazine.split(" ");
        String[]noteWords = note.split(" ");
        for (int i = 0; i < magWords.length; i++) {
            if(magazineMap.get(magWords[i]) == null){
                magazineMap.put(magWords[i], 1);
            } else {
                int j = magazineMap.get(magWords[i]);
                j +=1;
                magazineMap.put(magWords[i], j);
            }
        }
        for (int i = 0; i < noteWords.length; i++) {
            if(noteMap.get(noteWords[i]) == null){
                noteMap.put(noteWords[i], 1);
            } else {
                int j = noteMap.get(noteWords[i]);
                j +=1;
                noteMap.put(noteWords[i], j);
            }
        }
    }

    public boolean solve() {
        for (String key : noteMap.keySet()) {
            if(magazineMap.get(key) == null){
                return false;
            } else if (magazineMap.get(key) < noteMap.get(key)){
                return false;
            }
        }
    return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}