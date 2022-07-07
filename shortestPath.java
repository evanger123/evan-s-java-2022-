import java.util.HashMap;
import java.util.ArrayList;

public class shortestPath {
    public static HashMap<String, Integer> shortest(matrix aMatrix, String first){
        ArrayList<String> unvisited = new ArrayList<String>(aMatrix.getNodes());
        ArrayList<String> visited = new ArrayList<String>();
        HashMap<String, Integer> path = new HashMap<String, Integer>();
        for (String node:aMatrix.getNodes()){
            path.put(node, -1);
        }
        path.replace(first, 0);
        visited.add(first);
        unvisited.remove(first);
        String current = first;

        while (unvisited.size()!=0){
            for (String node:unvisited){
                if (aMatrix.findEdge(current, node)>0){
                    if (aMatrix.findEdge(current, node)+path.get(current)<path.get(node) || path.get(node)==-1){
                        path.put(node, aMatrix.findEdge(current, node)+path.get(current));
                    }
                }
            }
            int lowest = Integer.MAX_VALUE;
            for (int i = 0; i<unvisited.size(); i++){
                if (path.get(unvisited.get(i))!=-1 && path.get(unvisited.get(i))<lowest){
                    lowest = path.get(unvisited.get(i));
                    current = unvisited.get(i);
                }
            }

            visited.add(current);
            unvisited.remove(current);
        }
        return path;
    }
    public static void main(String[] args){
        matrix am = new matrix();
        am.addNode("A");
        am.addNode("B");
        am.addNode("C");
        am.addNode("D");
        am.addNode("E");
        am.addEdge("A", "B", 14);
        am.addEdge("A", "D", 3);
        am.addEdge("B", "D", 6);
        am.addEdge("B", "C", 7);
        am.addEdge("C", "D", 2);
        am.addEdge("C", "E", 1);
        am.addEdge("E", "D", 4);
        System.out.println(shortest(am, "A"));
    }
}
