import java.util.ArrayList;
import java.util.List;

public class Region {
    public String name;
    public List<Region> neighbours = new ArrayList<>();
    public List<String> colours = new ArrayList<>();

    public Region(String name, List<String> colours) {
        this.name = name;
        this.colours = colours;
    }

    public List<Region> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Region> neighbours) {
        this.neighbours = neighbours;
    }

    public List<String> getColours() {
        return colours;
    }

    public void print(){
        String string ="Region{" +
                "name='" + name + '\'' +
                ", colours=" + colours +
                ", neighbours= " + neighbours +
                '}';
        System.out.println(string);
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", colours=" + colours +
                '}';
    }

}
