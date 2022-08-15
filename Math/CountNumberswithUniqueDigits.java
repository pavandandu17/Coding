// https://leetcode.com/problems/count-numbers-with-unique-digits/submissions/

class Solution 
{
    public int countNumbersWithUniqueDigits(int n) 
    {
        int ans = 1; //Initially it is 1 because we consider 0 also 
        for(int i=1; i<=n; i++)
            ans += count(i);
        return ans;
    }
    public int count(int digits)
    {
        int ans = 9;
        int mul = 9;
        while(digits-- > 1)
            ans *= (mul--);
        return ans;
    }
}

/*
  To count no of numbers with unique digits of length n
  For example let n = 3,
    We have to count with digits 1, 2, 3
  For n = 1
    1, 2, 3, 4, 5, 6, 7, 8, 9
  For n = 2
    12, 13, 14, 15, ...... 95, 96, 97, 98
    
  
*/
