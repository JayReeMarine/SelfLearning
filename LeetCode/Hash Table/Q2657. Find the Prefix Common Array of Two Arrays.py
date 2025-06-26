#https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/

from collections import Counter, List
class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        seen_a = set()
        seen_b = set()
        seen_both = set()
        res = []
        count = 0

        for i in range(len(A)):
            a, b = A[i], B[i]

            if a == b and a not in seen_both:
                count += 1
                seen_both.add(a)

            else:
                if a in seen_b and a not in seen_both:
                    count += 1
                    seen_both.add(a)

                if b in seen_a and b not in seen_both:
                    count += 1
                    seen_both.add(b)
            
            seen_a.add(a)
            seen_b.add(b)
            res.append(count)
        
        return res
        
        # ctr = Counter()
        # res = []
        # for i in range(len(A)):
        #     freq = 0
        #     ctr.update([A[i], B[i]])
        #     for k, v in ctr.items():
        #         if v %2 == 0:
        #             freq += 1
        #     res.append(freq)
        
        # return res

