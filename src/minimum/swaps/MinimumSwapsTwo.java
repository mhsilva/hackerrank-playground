package minimum.swaps;

import java.util.Map;
import java.util.stream.IntStream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class MinimumSwapsTwo {

    static int minimumSwaps(int[] arr) {
        // Collect, to Map, the value in array as key and its position as value.
        Map<Integer, Integer> numberAndPosition = mapNumberAndPosition(arr);
        return getNumberOfSwaps(arr, numberAndPosition);
    }

    private static Map<Integer, Integer> mapNumberAndPosition(int[] arr) {
        return IntStream.range(0, arr.length)
                .boxed()
                .collect(toMap(i -> arr[i], identity()));
    }

    private static int getNumberOfSwaps(int[] arr, Map<Integer, Integer> numberAndPosition) {
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            swaps += checkSwap(arr, i, numberAndPosition);
        }
        return swaps;
    }

    private static int checkSwap(int[] arr, int i, Map<Integer, Integer> numberAndPosition) {
        int iPlusOneValue = i + 1;
        if (arr[i] != iPlusOneValue) {
            // Where is i+1?
            Integer iPlusOnePosition = numberAndPosition.get(iPlusOneValue);
            // Update map with new positions
            numberAndPosition.put(iPlusOneValue, i);
            numberAndPosition.put(arr[i], iPlusOnePosition);
            // Swap to new positions
            swap(arr, i, iPlusOnePosition);
            return 1;
        }
        return 0;
    }

    private static void swap(int[] arr, int i, Integer iPlusOnePosition) {
        int actualIValue = arr[i];
        arr[i] = arr[iPlusOnePosition];
        arr[iPlusOnePosition] = actualIValue;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 2};

        System.out.println(minimumSwaps(arr));
    }
}
