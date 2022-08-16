public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) 
{
    boolean[] visited = new boolean[V];
    for(int i=0; i<V; i++)
    {
        if(!visited[i])
            if(hasCycle(new Pair(i, -1), adj, visited))
                return true;
    }
    return false;
}
public boolean hasCycle(Pair node, ArrayList<ArrayList<Integer>> adj, boolean[] visited)
{
    int curr = node.curr;
    int parent = node.parent;

    visited[curr] = true;

    for(int x:adj.get(curr))
    {
        if(!visited[x])
        {
            if(hasCycle(new Pair(x, curr), adj, visited))
                return true;
        }
        else if(parent != x)
            return true;
    }

    return false;

}
