import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class IDS extends Algorithms{

    static Deque<Integer> stack = new ArrayDeque<>();   

    public static void search(int start, int goal){    

        int max_depth = 0;
        
        while (visited.size() < Graph.vertices.size()) {  // run by every level till max depth, stop when all nodes visited
    
           if (IDS_search(start,goal, max_depth++)) return; 

           Arrays.fill(dist, -1);
           stack.clear();
           visited.clear();
        }
    }

    public static boolean IDS_search(int start, int goal, int max_depth){    // return T if found target

        
        dist[start] = 0;  // mark root node 0 distance
        stack.push(start); // add root to stack before start search
        
        while (!stack.isEmpty() ) {

            if (dist[stack.peek()] > max_depth) return false; // if cu node is over the maxdepth, return

            int par_vertex = stack.pop(); // take the parent node 
            visited.add(par_vertex);

            if ( par_vertex == goal){ // target found, get the path
                
                Algorithms.travel_back(par_vertex);     
                return true;
            }
                
            for (int child_vertex : Graph.neighbors[par_vertex]) {  // iterate through the all children node
                if (dist[child_vertex] != -1) continue;  // ignore it if distance assigned already(visited)

                dist[child_vertex] = dist[par_vertex] + 1;
                stack.push(child_vertex);
            }
        }
        return false;
    }
}
