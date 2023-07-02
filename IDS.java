import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class IDS extends Algorithms{

    static Deque<Integer> stack = new ArrayDeque<>();   

    public static void search(int start, int goal){    

        int max_depth = 0;
        
        while (visited.size() < Graph.vertices.size()) {  // run by every level till max depth, stop when all nodes visited
    
           if (IDS_search(start,goal, max_depth++)) return; 
        }
    }

    public static boolean IDS_search(int start, int goal, int max_depth){    // return T if found target

        Arrays.fill(dist, -1); // initialize every value to -1 (not visited)
        
        dist[start] = 0;  // mark root node 0 distance
        stack.push(start); // add root to stack before start search
        
        while (!stack.isEmpty() ) {

            int par_vertex = stack.pop(); // take the parent node 
            visited.add(par_vertex);

            if ( par_vertex == goal){ // target found, get the path
                
                Algorithms.travel_back(par_vertex);        
                return true;
            }

            if (dist[par_vertex] == max_depth) continue; // if cu node reaches the max depth ignore it
            else if (dist[par_vertex] > max_depth) return true; // if cu node reaches over the maxdepth, terminate program
                
            for (int child_vertex : Graph.neighbors[par_vertex]) {  // iterate through the all children node
                if (dist[child_vertex] != -1) continue;  // ignore it if distance assigned already(visited)

                dist[child_vertex] = dist[par_vertex] + 1;
                stack.push(child_vertex);
            }
        }
        return false;
    }
}
