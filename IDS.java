import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class IDS extends Algorithms{

    static Deque<Integer> stack = new ArrayDeque<>();   

    public static void search(int start, int goal){    

        int max_depth = 1;
        
        while (!IDS_search(start,goal, max_depth)) {
            max_depth++;
        }
    }

    public static boolean IDS_search(int start, int goal, int max_depth){    

        Arrays.fill(dist, -1); // initialize every value to -1 (not visited)
        
        dist[start] = 0;  // mark root node 0 distance
        stack.push(start); // add root to stack before start search
        
        while (!stack.isEmpty() ) {

            int par_vertex = stack.pop(); // take the parent node 
            visited.add(par_vertex);

            if ( par_vertex == goal){ // travel back
                
                Algorithms.travel_back(par_vertex);        
                return true;
            }

            if (dist[par_vertex] >= max_depth) continue; // if cu node reaches the max depth ignore it
                
            for (int child_vertex : Graph.neighbors[par_vertex]) {  // iterate through the all children node
                if (dist[child_vertex] != -1) continue;  // ignore it if distance assigned already(visited)

                dist[child_vertex] = dist[par_vertex] + 1;
                stack.push(child_vertex);
            }
        }
        return false;
    }
}