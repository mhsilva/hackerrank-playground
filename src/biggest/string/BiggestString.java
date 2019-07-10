package biggest.string;

import java.util.Arrays;
import java.util.List;

public class BiggestString {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("aa", "aaa", "a", "aaaa");
        int biggestOne = 0;
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() >= strings.get(biggestOne).length())
                biggestOne = i;
        }
        System.out.println(strings.get(biggestOne));
    }
}