package tk.tjroger;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceTest {
    public static void reduceTest() {
        var rows = new int[][]{{2, 3, 5}, {1, 2, 4}, {8, 5, 5}};
        var stream = Stream.of(rows);
        var stream1 = stream.map((item)-> IntStream.of(item).sum());
        System.out.println(stream1);
        var newStream = stream1.reduce(0, (acc, n)-> acc + n);
        System.out.println(newStream);
//        var matrixElements = reduce(rows)
    }
    public static void main(String[] args) {
        reduceTest();
    }
}
