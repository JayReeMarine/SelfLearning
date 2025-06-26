from collections import Counter, List

class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        ctr = Counter()
        res = []
        for i in range(len(A)):
            freq = 0
            ctr.update([A[i], B[i]])
            for k, v in ctr.items():
                if v %2 == 0:
                    freq += 1
            res.append(freq)
        
        return res

