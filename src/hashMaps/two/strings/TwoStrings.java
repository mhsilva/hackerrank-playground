package hashMaps.two.strings;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoStrings {

    static String twoStrings(String s1, String s2) {
        Set<String>  stringSet = Arrays.stream(s1.split(""))
                .collect(Collectors.toSet());
        String[] s2Array = s2.split("");

        for (int i = 0; i < s2Array.length; i++) {
            if(stringSet.contains(s2Array[i])) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(twoStrings("hi", "world"));
    }
}
