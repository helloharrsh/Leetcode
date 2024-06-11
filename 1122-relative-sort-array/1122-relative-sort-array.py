class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        
        res = []
        for i in range(len(arr2)):
            for j in range(len(arr1)):
                
                if(arr1[j] == arr2[i]):
                    res.append(arr1[j])
                    arr1[j] = -1
        
        arr1.sort()
        
        for i in arr1:
            if(i != -1):
                res.append(i)
        
        return res