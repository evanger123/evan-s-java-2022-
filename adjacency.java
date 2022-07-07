import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class matrix{
    private int slot;
    public matrix(){
        this.slot = 0;
        this.map = new HashMap<>();
        this.theMatrix = new int[0][0];
    }
    private HashMap<String, Integer> map;
    private int[][] theMatrix;
    public void addNode(String name){
        map.put(name, slot);
        slot+=1;
        int[][] newMatrix = new int[slot][slot];
        for(int i = 0; i<theMatrix.length; i++){
            for(int x = 0; x<theMatrix[i].length; x++){
                newMatrix[i][x] = theMatrix[i][x];
            }
        }
        for(int i = 0; i<newMatrix.length; i++){
            for(int x = 0; x<newMatrix[i].length; x++){
            if(x == slot-1 || i == slot-1){
                newMatrix[i][x] = -1;
            }
        }
    }
        theMatrix = newMatrix;
    }
    public void addEdge(String name1, String name2, int cost){
        theMatrix[map.get(name1)][map.get(name2)] = cost;
        theMatrix[map.get(name2)][map.get(name1)] = cost;
    }
    public int findEdge(String name1, String name2){
        if(theMatrix[map.get(name1)][map.get(name2)]>-1){
            return theMatrix[map.get(name1)][map.get(name2)];
        }
        return -1;
    }
    public ArrayList<String> findConnections(String name){
        ArrayList<String> connections = new ArrayList<String>();
        for (int i = 0; i<theMatrix.length; i++){
            if(theMatrix[map.get(name)][i]>-1){
                for(Map.Entry<String, Integer> entry:map.entrySet()){
                    if (entry.getValue()==i){
                        connections.add(entry.getKey());
                    }
                }
            }
        }
        return connections;
    }
    public void printer(){
        for(int i = 0; i<theMatrix.length; i++){
            System.out.println("");
            for(int x = 0; x<theMatrix[i].length; x++){
                System.out.print(" "+theMatrix[i][x]+" ");
            }
        }
    }
    public Set<String> getNodes(){
        return map.keySet();
    }
}
public class adjacency {
    public static void main(String[] args){
        matrix graph = new matrix();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 1);
        graph.addEdge("C", "B", 1);
        System.out.println(graph.findEdge("A", "B"));
        System.out.println(graph.findEdge("A", "C"));
        System.out.println(graph.findConnections("B"));
        graph.printer();
    }
    
}
