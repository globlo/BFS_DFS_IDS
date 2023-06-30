import java.util.Vector;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.LinkedList;

public class BFS {

    // Vector<Vector<Integer>> s = new Vector<Vector<Integer>>();
    static int[] dist = new int[20]; 
    static Queue<Integer> que = new LinkedList<>();  

    public static void search(){    

        Arrays.fill(dist, -1); // initialize every value to -1 (not visited)
        
        dist[0] = 0;  // mark root node 0 distance
        que.add(0); // add root to queue before start search

        while (!que.isEmpty()) {

            int par_vertex = que.poll(); // take the parent node 

            for (int child_vertex : Main.arr[par_vertex]) {  // iterate through the all children node
                if (dist[child_vertex] != -1) continue;  // skip if distance assigned already

                dist[child_vertex] = dist[par_vertex] + 1;
                que.add(child_vertex);
            }
        }
    }

    public static void print(){  
        for (int v = 0; v < 20; v++) System.out.println(v+": "+dist[v]);
    }
    
}
