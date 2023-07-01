import java.util.ArrayList;


public abstract class Algorithms {

    static int[] dist = new int[20]; 
    static ArrayList<Integer> visited = new ArrayList<>();
    static int[] path; 

    public static void execute(String st, String dep, String dest) {

        int start = 0, goal = 0;

        for(int key : Graph.vertices.keySet() ){
            if( Graph.vertices.get(key) == dep){   start = key;  }  // get start value 
            if( Graph.vertices.get(key) == dest){  goal = key;   }  // get goal value
        }

        switch(st) {
            case "BFS":
                BFS.search(start,goal);
                break;
            case "DFS":
                DFS.search(start,goal);
                break;
            case "IDS":
                IDS.search(start, goal); 
                break;
            default:
                return;
        }
    }

    public static void travel_back(int cur){ 
        
        int dist_p= dist[cur];  // the distance of parent(cu) node

        path = new int[dist_p+1]; //allocate for path array
        path[dist_p] = cur;  // assign parent into the path

        while (dist_p > 0 ){
  
            for (int child_vertex : Graph.neighbors[cur]){  //iterate through every child verteces
                // System.out.println("child is: "+child_vertex);

                if ( visited.contains(child_vertex) && dist[child_vertex] < dist_p){  // if child vertex's visited & distance smaller than parent dist

                    path[--dist_p] = cur = child_vertex;    
                }
            }  
        }      
    }

    public static void print_distances(String st){  
        System.out.println(st + " - The distance from start (-1 represent not visited)");
        for (int v = 0; v < 20; v++) System.out.println(Graph.vertices.get(v)+"("+v+"): "+dist[v]);
        System.out.println('\n');
    }

    public static void print_visited(String st){ // show the visited nodes in order
        System.out.println(st + " - All visited in order :");
        for ( int v : visited) {
            System.out.print(Graph.vertices.get(v)+"("+v + ")");
            if (v != visited.get(visited.size() - 1))  System.out.print(" -> ");
        } 
        System.out.println('\n');    
    }

    public static void print_path(String st){  
        System.out.println(st + " - The path from start");

        for (int p : path) {
            System.out.print(Graph.vertices.get(p)+"("+p + ")");
            if (p != path[path.length - 1])  System.out.print(" -> ");
        }
        System.out.println('\n');
    }
    
}
