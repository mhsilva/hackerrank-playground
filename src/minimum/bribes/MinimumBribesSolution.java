package minimum.bribes;

public class MinimumBribesSolution {

    public static final String TOO_CHAOTIC = "Too chaotic";

    static void minimumBribes(int[] q) {
        try {
            System.out.println(howChaoticIs(q));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    static String howChaoticIs(int[] q) throws RuntimeException {
        int changes = 0;
        for (int actualValue = q.length; actualValue > 0; actualValue--) {
            changes += checkBribesInArray(q, actualValue);
        }
        return String.valueOf(changes);
    }

    static int checkBribesInArray(int[] q, int actualValue) {
        int index = actualValue - 1;
        if (q[index] == actualValue) {
            return 0;
        } else if (q[index - 1] == actualValue) {
            swap(index - 1, index, q);
            return 1;
        } else if (q[index - 2] == actualValue) {
            swap(index - 2, index - 1, q);
            swap(index - 1, index, q);
            return 2;
        }
        throw new RuntimeException(TOO_CHAOTIC);
    }

    private static void swap(int briberIndex, int bribedIndex, int[] q) {
        int bribedValue = q[bribedIndex];
        q[bribedIndex] = q[briberIndex];
        q[briberIndex] = bribedValue;
    }

    public static void main(String[] args) {
//        int[] arr = {2, 1, 5, 3, 4};
        int[] arr = {2, 5, 1, 3, 4};
        minimumBribes(arr);
    }
}
