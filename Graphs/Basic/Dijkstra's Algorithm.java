int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
{
    int[] ans = new int[V];
    Arrays.fill(ans, Integer.MAX_VALUE);
    Queue<Pair> pq = new PriorityQueue<>();
    ans[S] = 0;
    pq.add(new Pair(S, 0));

    while(!pq.isEmpty())
    {
        Pair curr = pq.poll();
        if(ans[curr.node] != curr.weight)
            continue;
        for(ArrayList<Integer> neighbour:adj.get(curr.node))
        {
            int neighbourNode = neighbour.get(0);
            int neighbourWeight = neighbour.get(1);

            if(curr.weight + neighbourWeight < ans[neighbourNode])
            {
                ans[neighbourNode] = curr.weight + neighbourWeight;
                pq.add(new Pair(neighbourNode, ans[neighbourNode]));
            }
        }
    }

    return ans;
}
class Pair implements Comparable<Pair>
{
    int node;
    int weight;
    Pair(int n, int w)
    {
        this.node = n;
        this.weight = w;
    }
    public int compareTo(Pair other)
    {
        return this.weight - other.weight;
    }
}
