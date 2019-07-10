package left.rotation;

import java.util.ArrayList;
import java.util.List;

public class RotationSolution {

    static int[] rotLeft(int[] a, int d) {
        if (a.length == d) {
            return a;
        }
        List<Integer> changingOnes = new ArrayList<>();
        List<Integer> firstOnes = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (i < d)
                changingOnes.add(a[i]);
            else
                firstOnes.add(a[i]);
        }
        firstOnes.addAll(changingOnes);
        return firstOnes.stream().mapToInt(integer -> integer).toArray();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] ints = rotLeft(a, 5);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
