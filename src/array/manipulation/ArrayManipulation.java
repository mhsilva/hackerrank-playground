package array.manipulation;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation {

    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n + 1];
        for (int i = 0; i < queries.length; i++) {
            int startIndex = queries[i][0] - 1;
            int endIndex = queries[i][1] - 1;
            long summand = queries[i][2];

            arr[startIndex] += summand;
            if (endIndex + 1 < n)
                arr[endIndex + 1] -= summand;
        }

        long max = Integer.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
        }
        return max;
    }


    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(new File("/home/matheus/git/kotlin-playground/src/array/manipulation/test-case.txt"));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(result);

        scanner.close();
    }
}
