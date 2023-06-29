import java.util.Vector;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.LinkedList;

public class BFS {

    // public static int[][] adjMat = new int[20][20];
    Vector<Vector<Integer>> s = new Vector<Vector<Integer>>();

    public static void search(){    

    
        int[] dist = new int[20]; 
        Arrays.fill(dist, -1);
        Queue<Integer> que = new LinkedList<>();  
   
        dist[0] = 0;
        que.add(0); 

        while (!que.isEmpty()) {
            int vertex = que.peek(); 
            que.remove();

            for (int cu : Main.arr[vertex]) {  // iterate through the current vertecies
                if (dist[cu] != -1) continue;  // skip if distance assigned already

                dist[cu] = dist[vertex] + 1;
                que.add(cu);
            }
        }

        for (int v = 0; v < 20; ++v){
            
            System.out.println(v+": "+dist[v]);

        } 


    }
    
}
