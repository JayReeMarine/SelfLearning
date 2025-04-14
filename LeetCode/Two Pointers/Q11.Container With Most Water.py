#https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def maxArea(self, height: list[int]) -> int:

        # max_con = 0
        # for i in range(len(height)):
        #     for j in range(i+1,len(height)):
        #         con = min(height[i],height[j]) * (j-i)
        #         max_con = max(max_con,con)
        
        # return max_con
        left = 0
        right = len(height) -1
        max_con = 0

        while left < right:
            width = right - left
            h = min(height[left], height[right])
            con = width *h
            max_con = max(max_con, con)

            if height[left] < height[right]:
                left +=1
            else:
                right -=1
        return max_con




Solution = Solution()
height = [1,8,6,2,5,4,8,3,7]
print(Solution.maxArea(height))  # Output: 49

height = [1,1]
print(Solution.maxArea(height))  # Output: 1
