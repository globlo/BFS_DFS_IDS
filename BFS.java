import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class BFS extends Algorithms{

    static Queue<Integer> que = new LinkedList<>();  

    public static void search(int start, int goal){    

        Arrays.fill(dist, -1); // initialize every value to -1 (not visited)
        
        dist[start] = 0;  // mark root node 0 distance
        que.add(start); // add root to queue before start search

        while (!que.isEmpty()) {

            int par_vertex = que.poll(); // take the parent node 
            visited.add(par_vertex);

            if ( par_vertex == goal){   // find tarfet, travel back     

                Algorithms.travel_back(par_vertex);                  
                return;
            }
            
            for (int child_vertex : Graph.neighbors[par_vertex]) {  // iterate through the all children node

                if (dist[child_vertex] != -1) continue;  // skip if distance assigned already

                dist[child_vertex] = dist[par_vertex] + 1;
                que.add(child_vertex);       
            }
        }
    }
}
