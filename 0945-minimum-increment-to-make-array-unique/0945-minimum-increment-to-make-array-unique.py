class Solution:
    def minIncrementForUnique(self, nums: List[int]) -> int:
        max_val = max(nums)
        count = 0
        frq = [0] * (len(nums) + max_val+1)
        
        for val in nums:
            frq[val]+=1
        
        for i in range(len(frq)):
            if(frq[i] <= 1):
                continue
            
            extra = frq[i] -1
            frq[i+1] += extra
            frq[i] = 1
            count += extra
            
        return count 