// https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-1587115620/1

class Solution
{
    //Function to find unit area of the largest region of 1s.
    int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length; 
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(grid[i][j] == 1)
                    ans = Math.max(dfs(grid, i, j), ans);
            }
        }
        
        return ans;
    }
    int dfs(int[][] grid, int x, int y)
    {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0)
            return 0;
        
        grid[x][y] = 0;
        
        int ans = 0;
        for(int dir = 0; dir<8; dir++)
        {
            ans += dfs(grid, x + dx[dir], y + dy[dir]);
        }
        
        return ans + 1;
    }
}
