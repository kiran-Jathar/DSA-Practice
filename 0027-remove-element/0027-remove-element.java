class Solution { 
    public int removeElement(int[] nums, int val) { 
        
        int n = nums.length; 
        int count = 0; 
        
        for (int i = 0; i < n; i++) { 
            
            while (nums[i] == val) { 
                
                for (int j = i; j < n - 1; j++) { 
                    nums[j] = nums[j + 1]; 
                } 
                
                n--; 
                
                if (i >= n) {
                    break;
                }
            } 
        } 
        
        for (int i = 0; i < n; i++) { 
            if (nums[i] != val) { 
                count++; 
            } 
        } 
        
        return count; 
    } 
}