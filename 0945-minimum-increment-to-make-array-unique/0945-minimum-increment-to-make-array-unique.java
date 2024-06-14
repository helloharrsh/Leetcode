class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i =1; i< nums.length; i++){
            if(nums[i] <= nums[i-1]){
                int extra = nums[i-1] +1 - nums[i];
                count += extra;
                
                nums[i] = nums[i-1] +1;
            }
        }
        return count;
    }
}