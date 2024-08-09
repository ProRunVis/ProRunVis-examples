public class SnowWhite {

    static int indexMax(int a[]) {
        int res = 0;
        for (int k=0; k < a.length; k++) {
            if (a[res] < a[k]) {
                res = k;
            }
        }
        return res;
    }

    static void snowWhiteMirror (String names[], int beautiful[], int i_asker) {
        int i_max = indexMax(beautiful);
        //assert(beautiful[i_max] >= beautiful[i_asker]);

        System.out.println("Dear " + names[i_asker] + ". You are beautiful.");
        if (i_asker != i_max) {
            System.out.println("But " + names[i_max] + " is most beautiful.");
        }
    }
    public static void main (String[] args) {
        String names[]  = {"Person 1", "Queen", "Snow White", "Person 2"};
        int beautiful[] = {    1,        20,       20000,         1     };
        snowWhiteMirror(names, beautiful, 1);
    }
}
