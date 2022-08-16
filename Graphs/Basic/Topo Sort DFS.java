static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
{
    boolean[] visited = new boolean[V];
    ArrayList<Integer> res = new ArrayList<>();
    for(int i=0; i<V; i++)
        if(!visited[i])
            dfs(adj, visited, i, res);

    int[] ans = new int[V];

    for(int i=V-1; i>=0; i--)
        ans[V-i-1] = res.get(i);

    return ans;
}
static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int source, ArrayList<Integer> ans)
{
    if(visited[source])
        return;

    visited[source] = true;

    for(int x:adj.get(source))
    {
        dfs(adj, visited, x, ans);
    }

    ans.add(source);
}
