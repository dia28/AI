import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Region T = new Region("T", new ArrayList<>(Arrays.asList("red", "blue", "green")));
//        Region WA = new Region("WA", new ArrayList<>(Arrays.asList("red")));
//        Region NT = new Region("NT", new ArrayList<>(Arrays.asList("red", "blue", "green")));
//        Region SA = new Region("SA", new ArrayList<>(Arrays.asList("red", "blue", "green")));
//        Region V = new Region("V", new ArrayList<>(Arrays.asList("red", "blue", "green")));
//        Region Q = new Region("Q", new ArrayList<>(Arrays.asList("green")));
//        Region NSW = new Region("NSW", new ArrayList<>(Arrays.asList("red", "blue", "green")));
//
//
//        T.setNeighbours(Collections.singletonList(V));
//        WA.setNeighbours(Arrays.asList(NT, SA));
//        NT.setNeighbours(Arrays.asList(WA, Q, SA));
//        SA.setNeighbours(Arrays.asList(WA, NT, Q, NSW, V));
//        Q.setNeighbours(Arrays.asList(NT, SA, V));
//        NSW.setNeighbours(Arrays.asList(Q, SA, V));
//        V.setNeighbours(Arrays.asList(SA, NSW, T));

        Region WA = new Region("WA", new ArrayList<>(Arrays.asList("red", "green", "blue")));
        Region SA = new Region("SA", new ArrayList<>(Arrays.asList("red", "green")));
        Region NT = new Region("NT", new ArrayList<>(Arrays.asList("green","blue")));

        WA.setNeighbours(Arrays.asList(SA,NT));
        SA.setNeighbours(Arrays.asList(WA,NT));
        NT.setNeighbours(Arrays.asList(WA, SA));
        WA.print();
        
        // List<Region> regions = new ArrayList<>(Arrays.asList(T, WA, NT, SA, V, Q, NSW));
        // MapColoring mc = new MapColoring(7, regions);
        List<Region> regions = new ArrayList<>(Arrays.asList(WA,SA,NT));
        MapColoring mc = new MapColoring(3, regions);
        mc.initializeAssignment();
        mc.bkt(0);
    }
}
