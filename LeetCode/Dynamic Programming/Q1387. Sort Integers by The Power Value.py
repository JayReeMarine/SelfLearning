#https://leetcode.com/problems/sort-integers-by-the-power-value/description/


class Solution:
    def getKth(self, lo: int, hi: int, k: int) -> int:
        val = {}

        def get_power(x):
            if x ==1:
                return 0
            if x % 2 == 0:
                steps = 1 + get_power(x//2)
            else:
                steps = 1 +  get_power(3*x +1)
            
            return steps
        
        res = list(range(lo, hi+1))
        res.sort(key=lambda x: (get_power(x), x))


        return res[k-1]
    