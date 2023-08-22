package week1;

import java.util.Iterator;
import java.util.Stack;

// adjancency-list graph representation
// use bag[]
// use adj-list because
// 1. algorithms are based on iterating over adj list of a vertice V
// 2. real world applications tend to be spare( huge number of vertices but small number of edges ( small number of vertices degree)
// 3. memory growth:  E + V
public class Graph {
    private final int V;
    private Bag<Integer>[] adj;

    public Graph(int V)
    {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public int V() {
        return this.V;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true; // mark the current node as true
        System.out.println(v + " ");

        // recur for all the vertices adjacent to this vertex
        Iterator<Integer> currAdj =  adj[v].listIterator();
        while (currAdj.hasNext()) {
            int n = currAdj.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
    // do the DFS traversal
    void DFS(int v) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        DFSUtil(v,visited);
    }
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    // Driver Code
    public static void main(String[] args)
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        // Function call
        g.DFS(2);
    }
}
