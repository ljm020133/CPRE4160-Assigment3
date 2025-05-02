import java.util.*;

public class IterativePermutations {
    public static List<String> generate(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        List<String> result = new ArrayList<>();
        do {
            result.add(new String(arr));
        } while (nextPermutation(arr));
        return result;
    }

    private static boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return false;
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;
        swap(arr, i, j);
        reverse(arr, i + 1, arr.length - 1);
        return true;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) swap(arr, start++, end--);
    }
}
