class Solution {
    
    public static boolean isItPossible(int[] nums,int dist, int m){
        int count = 1;
        int lastPlaced = nums[0];
        for(int i =1; i< nums.length ; i++){
            if((nums[i] - lastPlaced) >= dist){
                count++;
                lastPlaced = nums[i];
            }
            if(count >= m){
                return true;
            }   
        }
        return false;
    }
    
    
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 1;
        int high = position[n-1] - position[0];
        
        while(low<=high){
            int mid = (low+high)/2;
            if(isItPossible(position, mid, m) == false){
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return high;
    }
}