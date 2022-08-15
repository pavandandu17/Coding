// https://leetcode.com/problems/di-string-match/

class Solution 
{
    public int[] diStringMatch(String s) 
    {
        int n = s.length();
        
        int[] ans = new int[n+1];
        
        int x = 0, y = n;
        int k = 0;
        for(int i=0; i<n; i++)
        {
            if(s.charAt(i) == 'I')
                ans[k++] = x++;   // If 'I', then print(x) and increase x
            else
                ans[k++] = y--;   // If 'D', then print(y) and decrease y
        }
        
        ans[k++] = x++;
        
        return ans;
    }
}
