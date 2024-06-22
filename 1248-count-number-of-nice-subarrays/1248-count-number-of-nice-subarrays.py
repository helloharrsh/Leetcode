class Solution:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        
        def find(nums,k):
            j = 0 
            i = 0
            count = 0
            res = 0
            while(j<len(nums)):
                if nums[j]%2!=0:
                    count+=1
                while(count>k):
                    if nums[i]%2!=0:
                        count-=1
                    i+=1 

                res += j-i+1 
                j+=1

            return res
        
        return(find(nums,k) - find(nums,k-1))