import java.util.*;

public class RecursivePermutations {
    /**
     * Generates all permutations of a string using backtracking.
     * @param s input string
     * @return list of all permutations
     */
    public static List<String> generate(String s) {
        List<String> result = new ArrayList<>();
        permute(s.toCharArray(), 0, result);
        return result;
    }

    /**
     * Recursive helper to generate permutations via character swapping.
     * @param arr the current state of characters
     * @param index the position to fix
     * @param result stores generated permutations
     */
    private static void permute(char[] arr, int index, List<String> result) {
        if (index == arr.length - 1) {
            result.add(new String(arr)); // Base case: fixed full permutation
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);                // Swap current with index
            permute(arr, index + 1, result);    // Recurse
            swap(arr, index, i);                // Backtrack to original state
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
