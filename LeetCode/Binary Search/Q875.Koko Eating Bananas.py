import math

#https://leetcode.com/problems/koko-eating-bananas/description/
# Solution
# Time complexity : O(piles * log(max(piles)))

class Solution:
    def minEatingSpeed(self, piles: list[int], h: int) -> int:
        left, right = 1, max(piles)

        res = right

        while left <= right:
            k = (left + right) // 2
            hours = 0
            for p in piles:
                hours += math.ceil(p / k)
            
            if hours <= h:
                res = min(res,k)
                right = k - 1
            else:
                left = k + 1
        return res


#my solution
# Time complexity : O(max(p)*p)

# class Solution:
#     def minEatingSpeed(self, piles: list[int], h: int) -> int:
#         i = 0
#         max_num = max(piles)
#         while i < max_num:
#             i += 1
#             sum = 0
#             for pile in piles:
#                 if pile % i == 0:
#                     sum += pile // i
#                 else:
#                     sum += pile // i + 1
#             if sum <= h:
#                 return i





# Test Cases
a = [1,3,6,7,11]
pile1 = [3,6,7,11]
h1 = 8 

pile2 = [30,11,23,4,20]
h2 = 5

pile3 = [30,11,23,4,20]
h3 = 6

Solution = Solution()
print(Solution.minEatingSpeed(pile3,h3))