public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) 
{
        ArrayList<Integer> bfs = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        boolean[] visited = new boolean[V];
        
        queue.add(0);
        visited[0] = true;
        
        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            bfs.add(curr);
            
            for(int x:adj.get(curr))
            {
                if(!visited[x])
                {
                    queue.add(x);
                    visited[x] = true;
                }
            }
        }
        
        return bfs;
}
