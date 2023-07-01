import java.util.ArrayList;


public abstract class Algorithms {

    static int[] dist = new int[Graph.vertices.size()]; 
    static ArrayList<Integer> visited = new ArrayList<>();
    static int[] path; 

    static int start, goal;

    public static void execute(String algo, String dep, String dest) { // Bulletproofing + Execute algorithm


        if ( (start = Graph.get_key(dep)) == -1 || (goal = Graph.get_key(dest)) == -1) {  // get keys and check if entered location exist
            System.out.println("Enter the Start or Goal location again");
            return;
        }

        switch(algo) {
            case "BFS":
                BFS.search(start,goal); break;
            case "DFS":
                DFS.search(start,goal); break;
            case "IDS":
                IDS.search(start, goal); break;
            default:
                System.out.println("The Algorithm not available - OPTION:[ BFS, DFS, IDS ]");
                return;
        }

        System.out.println(algo+" search : ["+Graph.vertices.get(start)+"("+start + ")"+" - "+Graph.vertices.get(goal)+"("+goal + ")"+"]\n");

        print_visited(algo);
        print_path(algo);
        // print_distances(algo);
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
        for (int i = 0; i < Graph.vertices.size(); i++) 
            System.out.println(Graph.vertices.get(i)+"("+i+"): "+dist[i]);
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
