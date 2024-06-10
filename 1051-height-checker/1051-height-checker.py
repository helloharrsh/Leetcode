class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        arr = sorted(heights)
        #print(arr)
        count = 0 
        for i in range(len(heights)):
            if(arr[i]!= heights[i]):
                count+=1 
        
        return count