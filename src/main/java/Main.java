import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Region T = new Region("T", Arrays.asList("red", "blue", "green"));
        Region WA = new Region("WA", Arrays.asList("red"));
        Region NT = new Region("NT", Arrays.asList("red", "blue", "green"));
        Region SA = new Region("SA", Arrays.asList("red", "blue", "green"));
        Region V = new Region("V", Arrays.asList("red", "blue", "green"));
        Region Q = new Region("Q", Arrays.asList("green"));
        Region NSW = new Region("NSW", Arrays.asList("red", "blue", "green"));


        T.setNeighbours(Collections.singletonList(V));
        WA.setNeighbours(Arrays.asList(NT, SA));
        NT.setNeighbours(Arrays.asList(WA, Q, SA));
        SA.setNeighbours(Arrays.asList(WA, NT, Q, NSW, V));
        Q.setNeighbours(Arrays.asList(NT, SA, V));
        NSW.setNeighbours(Arrays.asList(Q, SA, V));
        V.setNeighbours(Arrays.asList(SA, NSW, T));

        System.out.println(T.getNeighbours());
    }
}
