public class SnowWhite {

    static int indexMax(int[] a) {
        // follow a specific trace:
        prorunvis.Trace.trace = new int[]{5,3,0,1,1,2,1,2,1,6,4};
        prorunvis.Trace.index = 2;

        prorunvis.Trace.next_elem(0);
        int res = 0;
        for (int k = 0; k < a.length; k++) {
            prorunvis.Trace.next_elem(1);
            if (a[res] < a[k]) {
                prorunvis.Trace.next_elem(2);
                res = k;
            }
        }
        prorunvis.Trace.next_elem(6);
        assert (false);
        return res;
    }

    static void snowWhiteMirror(String[] names, int[] beautiful, int i_asker) {
        prorunvis.Trace.next_elem(3);
        int i_max = indexMax(beautiful);
        //assert(beautiful[i_max] >= beautiful[i_asker]);
        System.out.println("Dear " + names[i_asker] + ". You are beautiful.");
        if (i_asker != i_max) {
            prorunvis.Trace.next_elem(4);
            System.out.println("But " + names[i_max] + " is most beautiful.");
        }
    }

    public static void main(String[] args) {
        // follow a specific trace:
        prorunvis.Trace.trace = new int[]{5,3,0,1,1,2,1,2,1,6,4};
        prorunvis.Trace.index = 0;

        prorunvis.Trace.next_elem(5);
        String[] names = { "Person 1", "Queen", "Snow White", "Person 2" };
        int[] beautiful = { 1, 20, 20000, 1 };
        snowWhiteMirror(names, beautiful, 1);
    }
}
