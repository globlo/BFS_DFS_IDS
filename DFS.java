import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class DFS extends Algorithms {

    static Deque<Integer> stack = new ArrayDeque<>();  

    public static void search(int start, int goal){    

        Arrays.fill(dist, -1); // initialize every value to -1 (not visited)
        
        dist[start] = 0;  // mark root node 0 distance
        stack.push(start); // add root to stack before start search
        
        while (!stack.isEmpty()) {

            int par_vertex = stack.pop(); // take the parent node 
            visited.add(par_vertex);

            if ( par_vertex == goal){ // travel back

                Algorithms.travel_back(par_vertex);   
                return;
            }
                
            for (int child_vertex : Graph.neighbors[par_vertex]) {  // iterate through the all children node
                if (dist[child_vertex] != -1) continue;  // skip if distance assigned already

                dist[child_vertex] = dist[par_vertex] + 1;
                stack.push(child_vertex);
                // System.out.println("child is : "+child_vertex+" pushed in stack ");
            }
        }

    }
}
