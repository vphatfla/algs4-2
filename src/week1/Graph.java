package week1;
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

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
