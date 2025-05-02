import java.util.*;

public class IterativePermutations {
    /**
     * Generates all permutations of a string using an iterative, lexicographic approach.
     * @param s the input string
     * @return list of permutations in lexicographic order
     */
    public static List<String> generate(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr); // Ensure we start with the smallest lex permutation
        List<String> result = new ArrayList<>();
        do {
            result.add(new String(arr)); // Add current permutation
        } while (nextPermutation(arr)); // Generate next permutation until done
        return result;
    }

    /**
     * Generates the next lexicographic permutation of the char array.
     * Returns false if already at the highest permutation.
     */
    private static boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;

        // Find first decreasing element from the end
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;

        if (i < 0) return false; // Reached the last permutation

        // Find the next bigger element to swap with
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;

        swap(arr, i, j);          // Swap pivot with successor
        reverse(arr, i + 1, arr.length - 1); // Reverse suffix
        return true;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Reverses the elements from start to end index (inclusive)
    private static void reverse(char[] arr, int start, int end) {
        while (start < end) swap(arr, start++, end--);
    }
}
