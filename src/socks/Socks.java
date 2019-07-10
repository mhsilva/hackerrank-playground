package socks;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Socks {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Long> grouped = Arrays.stream(ar)
                .boxed()
                .collect(groupingBy(i->i, counting()));

        return grouped.entrySet().stream()
                .map(entry -> entry.getValue() / 2)
                .map(Long::intValue)
                .collect(Collectors.summingInt(Integer::intValue)).intValue();
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 10, 10, 30, 50, 10, 20};

        System.out.println(sockMerchant(arr.length, arr));
    }
}