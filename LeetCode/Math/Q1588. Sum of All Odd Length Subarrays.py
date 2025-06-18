from collections import List

class Solution:
    def sumOddLengthSubarrays(self, arr: List[int]) -> int:
        # res = 0
        # for i in range(1,len(arr) + 1,2):
        #     for j in range(len(arr) - i + 1):
        #         num = sum(arr[j:j+i])
        #         res += num
        # return res

        res = 0
        n = len(arr)

        #create prefix sum
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + arr[i]
        
        #combine all subarray 
        for length in range(1, n + 1, 2):  
            for start in range(n - length + 1):
                end = start + length
                num = prefix[end] - prefix[start]
                res += num
                
        return res


