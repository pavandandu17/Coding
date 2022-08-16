// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) 
{
    // Code here
    boolean[] visited = new boolean[V];
    for(int i=0; i<V; i++)
    {
        if(!visited[i])
            if(hasCycle(i, adj, visited))
                return true;
    }
    return false;
}
public boolean hasCycle(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited)
{
    Queue<Pair> queue = new LinkedList<>();

    queue.add(new Pair(start, -1));
    visited[start] = true;

    while(!queue.isEmpty())
    {
        Pair curr = queue.poll();
        for(int x:adj.get(curr.node))
        {
            if(!visited[x])
            {
                visited[x] = true;
                queue.add(new Pair(x, curr.node));
            }
            else if(x != curr.parent)
                return true;
        }
    }

    return false;
}
