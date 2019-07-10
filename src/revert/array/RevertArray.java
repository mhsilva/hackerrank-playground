package revert.array;

import java.io.IOException;
import java.util.Scanner;

public class RevertArray {

    // Complete the revert.array.reverseArray function below.
    static int[] reverseArray(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int oppositeSide = a.length - 1 - i;
            int temp = a[i];
            a[i] = a[oppositeSide];
            a[oppositeSide] = temp;
        }
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 4;
        arr[2] = 3;
        arr[3] = 2;
        arr[4] = 5;

        int[] res = reverseArray(arr);

        System.out.println(res.toString());
    }
}
