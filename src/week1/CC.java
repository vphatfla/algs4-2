package week1;

// cnnected component
public class CC {
    private boolean[] marked; // visited
    private int[] id; // component/root that containing
    private int count; // number of components

    public int id(int v) {
        return id[v];
    }
    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int v = 0; v<G.V(); v+=1){
            if (!marked[v])
            {
                dfs(G,v);;
                count +=1; // not the root, all vertices discovered in same call of dfs have same id
            }
        }
    }
    public int count()
    {
        return count;
    }
    private void dfs(Graph G, int v)
    {
        marked[v] = true;
        id[v] = count;
        for (int w: G.adj(v)) {
            if (!marked[w])
                dfs(G,w);
        }
    }
}
