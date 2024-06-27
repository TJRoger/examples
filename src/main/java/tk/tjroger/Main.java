package tk.tjroger;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import tk.tjroger.supplies.FibonacciSupplier;
import tk.tjroger.supplies.NaturalSupplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Stream<Integer> natual = Stream.generate(new NaturalSupplier());
//        var natual = LongStream.generate((LongSupplier) new FibonacciSupplier());
        // 注意：无限序列必须先变成有限序列再打印:
        natual.limit(20).forEach(System.out::println);
    }
}