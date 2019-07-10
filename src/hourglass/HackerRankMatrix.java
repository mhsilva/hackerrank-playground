package hourglass;

public class HackerRankMatrix {

    public static final int ROWS = 6;
    public static final int COLUMNS = 6;

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}};

        System.out.println(hourglassSum(arr));
    }

    private static int hourglassSum(int[][] arr) {
        // Given the number of the matrix:
        int numberOfHourglassPerRow = COLUMNS - 2;

        // Being 2 the "height" of the hourglass
        int numberOrHourglassLines = ROWS - 2;

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < numberOfHourglassPerRow; i++) {
            for (int j = 0; j < numberOrHourglassLines; j++) {
                int sum =
                        //Top
                        arr[i][j] + arr[i][j+1] + arr[i][j+2] +
                        //Mid
                        arr[i+1][j+1] +
                        // Botton
                        arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if (sum > maxSum)
                    maxSum = sum;
            }
        }

        return maxSum;
    }

}