class Solution {
    public int heightChecker(int[] heights) {
        int count =0;
        int[] arr = heights.clone(); 
        Arrays.sort(arr); 
        
        for(int i = 0; i<= heights.length-1; i++){
            if(heights[i]!= arr[i]){
                count +=1; 
            }
        }
        return(count);
    }
}