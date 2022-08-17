// https://leetcode.com/problems/flood-fill/

int[] dx = {0, -1, 0, 1};
int[] dy = {-1, 0, 1, 0};
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) 
{
    if(image[sr][sc] != newColor)
        dfs(image, sr, sc, newColor, image[sr][sc]);
    return image;
}
public void dfs(int[][] image, int r, int c, int newColor, int startColor)
{
    if(r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != startColor)
        return;

    image[r][c] = newColor;
    for(int i=0; i<4; i++)
    {
        dfs(image, r+dx[i], c+dy[i], newColor, startColor);
    }
}
