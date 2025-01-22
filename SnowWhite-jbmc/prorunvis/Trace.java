package prorunvis;

// the contents of this file are below
// just to increase the value of line numbers in the cbmc trace output



























































import org.cprover.CProver;

public final class Trace {
    public static int index;
    public static int trace[];

    public static void next_elem(int num) {
        CProver.assume(trace != null);
        CProver.assume(index < trace.length);
        CProver.assume(num == trace[index]);
        index ++;
    }
}
