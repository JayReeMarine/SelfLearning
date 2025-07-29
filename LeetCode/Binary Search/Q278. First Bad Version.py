#https://leetcode.com/problems/first-bad-version/description/

# The isBadVersion API is already defined for you.
def isBadVersion(version: int) -> bool:
    # This is a placeholder for the actual implementation.
    pass

class Solution:
    def firstBadVersion(self, n: int) -> int:
        left = 1
        right = n
        res = n

        while left <= right:
            mid = (left + right) // 2

            if isBadVersion(mid):
                res = mid
                right = mid - 1
            else:
                left = mid + 1
        
        return res

        