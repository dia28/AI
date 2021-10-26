import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapColoring {
    public Integer numberOfRegions;
    public List<Region> regions = new ArrayList<>();
    public List<String> assignment = new ArrayList<>();
    public Map<Integer, String> removedColors = new HashMap<>();

    public MapColoring(Integer numberOfRegions, List<Region> regions) {
        this.numberOfRegions = numberOfRegions;
        this.regions = regions;
    }

    public void initializeAssignment() {
        for(int i = 0; i < this.numberOfRegions; i++){
            if(regions.get(i).colours.size() == 1){
                assignment.add(i, regions.get(i).colours.get(0));
                removeNeighboursColours(i);
            }
            else
                assignment.add(i, "-");
        }
    }

    public void removeNeighboursColours(int index) {
        removedColors = new HashMap<>();
        for(int i=0 ; i < numberOfRegions; i++) {
            if(regions.get(i).neighbours.contains(regions.get(index))){
                removedColors.put(i, assignment.get(index));
                regions.get(i).colours.remove(assignment.get(index));
            }
        }
    }

    public boolean assignmentIsFull(){
        for(String assign: this.assignment) {
            if(assign.equals("-"))
                return false;
        }
        return true;
    }

    public int MRV(List<Region> regions){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0 ;i < this.numberOfRegions; i++){
            if(assignment.get(i).equals("-"))
                if(regions.get(i).colours.size() < min) {
                    min = regions.get(i).colours.size();
                    index = regions.indexOf(regions.get(i));
                }
        }

        return index;
    }

    public void forwardChecking(int index, String color){
        removeNeighboursColours(index);
    }

    public void reverseChanges(int index){
        assignment.set(index, "-");
        for( Integer key: removedColors.keySet()) {
            regions.get(key).colours.add(removedColors.get(key));
        }
    }

    public boolean bkt(int currentIndex){
        if(assignmentIsFull()){
            System.out.println(this.assignment);
            return true;
        }
        for(Integer colorIndex = 0; colorIndex < regions.get(currentIndex).colours.size(); colorIndex++){
            String color = regions.get(currentIndex).colours.get(colorIndex);
            assignment.set(currentIndex, color);
            if(assignmentIsFull()){
                System.out.println(this.assignment);
                return true;
            }
            forwardChecking(currentIndex, color);
            int index = MRV(regions);
            if(index != -1 && !regions.get(index).colours.isEmpty())
                bkt(index);
            reverseChanges(currentIndex);
        }
        return false;
    }
}
