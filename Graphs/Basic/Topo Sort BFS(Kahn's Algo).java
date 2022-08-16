static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
{
    int[] ans = new int[V];

    int[] inDegree = new int[V];
    for(ArrayList<Integer> al:adj)
        for(int x:al)
            inDegree[x]++;

    Queue<Integer> queue = new LinkedList<>();
    for(int i=0; i<V; i++)
        if(inDegree[i] == 0)
            queue.add(i);

    int k = 0;
    while(!queue.isEmpty())
    {
        int x = queue.poll();
        ans[k++] = x;

        for(int vertex:adj.get(x))
        {
            inDegree[vertex]--;
            if(inDegree[vertex] == 0)
                queue.add(vertex);
        }
    }

    return ans;
}
