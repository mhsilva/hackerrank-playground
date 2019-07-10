package hashMaps.ransom.note;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Long> magazineMap = Arrays.asList(magazine).stream()
                .collect(groupingBy(identity(), counting()));
        Map<String, Long> noteMap = Arrays.asList(note).stream()
                .collect(groupingBy(identity(), counting()));

        boolean allMatch = noteMap.entrySet().stream()
                .map(entry -> magazineMap.containsKey(entry.getKey())
                        && magazineMap.get(entry.getKey()) - entry.getValue() >= 0)
                .filter(Boolean::booleanValue)
                .count() == noteMap.size();
        System.out.println(allMatch ? "Yes" : "No");
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(new File("/home/matheus/git/kotlin-playground/src/hashMaps/ransom/note/test-case.txt"));
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
