// https://leetcode.com/problems/construct-smallest-number-from-di-string/

class Solution 
{
    public String smallestNumber(String pattern) 
    {
        Stack<Integer> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        
        int n = pattern.length();
        for(int i=0; i<=n; i++)
        {
            stack.push(i+1);
            
            if(i == n || pattern.charAt(i) == 'I')
            {
                while(!stack.isEmpty())
                    ans.append(stack.pop());
            }
        }
        
        return ans.toString();
    }
}

/*
  Adding numbers to stack if char == 'D' 
  Printing numbers from stack if char == 'I' or pattern is completed
*/
