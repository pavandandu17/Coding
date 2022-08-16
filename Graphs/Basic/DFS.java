public void dfs(int curr, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, boolean[] visited)
{
    if(visited[curr])
        return;
            
    ans.add(curr);
    visited[curr] = true;
        
    for(int x:adj.get(curr))
    {
        dfs(x, adj, ans, visited);
    }
}
