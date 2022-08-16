public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) 
{
    // code here
    boolean[] visited = new boolean[V];
    boolean[] stack = new boolean[V];

    for(int i=0; i<V; i++)
    {
        if(dfs(adj, visited, stack, i))
            return true;
    }

    return false;
}
public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] stack, int curr)
{
    if(stack[curr])
        return true;
    if(visited[curr])
        return false;
    stack[curr] = visited[curr] = true;

    for(int x:adj.get(curr))
    {
        if(dfs(adj, visited, stack, x))
            return true;
    }
    stack[curr] = false;

    return false;
}
