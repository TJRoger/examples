package tk.tjroger.supplies;

import java.util.function.Supplier;

public class NaturalSupplier implements Supplier<Integer> {
    int n=0;
    public Integer get(){
//            n++;
        // return n++返回的是n，可能和编译器是左结合有关
        return ++n;
//        return n++;

    }
}
