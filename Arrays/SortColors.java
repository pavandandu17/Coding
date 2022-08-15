// https://leetcode.com/problems/sort-colors/

/*
1)  
      2    0 2 1 1 0
   i,j,k
       2   0  2 1 1 0
      i,j  k
      0   2   2 1 1 0
         i,j  k
         
      0  2   2 1 1 0
        i,j    k
      0  1   2 2 1 0
         i   j   k
      0  1  1  2  2 0
         i     j    k
      0  0  1  2  2 1
         i     j    k
      0  0  1  1  2 2
            i     j   k
*/
class Solution 
{
    public void sortColors(int[] nums) 
    {
        int n = nums.length;
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(k < n)
        {
            int curr = nums[k];
            if(curr == 0)
            {
                swap(nums, i, k);
                if(nums[k] == 1)
                    swap(nums, j, k);
                
                i++;
                j++;
                k++;
            }
            else if(curr == 1)
            {
                swap(nums, j, k);
                j++;
                k++;
            }
            else
            {
                k++;
            }
        }
    }
    public static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/* 2) Recommended
public void sortColors(int[] nums) 
{
        int low = 0, mid = 0;
        int high = nums.length - 1;
        int temp = 0;
        while(mid<=high)
        {
            switch(nums[mid])
            {
                case 0:
                    temp = nums[mid];
                    nums[mid] = nums[low];
                    nums[low] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;
                    high--;
                    break;
            }
        }
  }
   */ 
