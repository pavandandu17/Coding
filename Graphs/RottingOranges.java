// https://leetcode.com/problems/rotting-oranges/

class Solution 
{
    int[] dx = {0,-1,0,1};
    int[] dy = {-1,0,1,0};
    public int orangesRotting(int[][] grid) 
    {
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<Index> queue = new LinkedList<>();
        int freshOranges = 0;
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(grid[i][j] == 1)
                    freshOranges++;
                else if(grid[i][j] == 2)
                    queue.add(new Index(i, j));
            }
        }
        
        if(freshOranges == 0)
            return 0;
        
        int minutes = 0;
        while(!queue.isEmpty())
        {
            int n = queue.size();
            minutes++;
            while(n-- > 0)
            {
                Index curr = queue.poll();
                int x = curr.x;
                int y = curr.y;
                for(int i=0; i<4; i++)
                {
                    if(isValidIndex(x+dx[i], y+dy[i], rows, cols) && grid[x+dx[i]][y+dy[i]] == 1)
                    {
                        grid[x+dx[i]][y+dy[i]] = 2;
                        queue.add(new Index(x+dx[i], y+dy[i]));
                        freshOranges--;
                    }
                    if(freshOranges == 0)
                        return minutes;
                }
            }
        }
        
        return -1;
    }
    boolean isValidIndex(int x, int y, int rows, int cols)
    {
        if(x >= 0 && x < rows && y >= 0 && y < cols)
            return true;
        return false;
    }
}
class Index
{
    int x;
    int y;
    Index(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
