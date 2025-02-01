#https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def maxArea(self, height: list[int]) -> int:
        # Initialize two pointers: one at the beginning (left) and one at the end (right)
        left, right = 0, len(height) - 1  
        
        # Variable to keep track of the maximum area found
        max_area = 0  

        while left < right:  # Continue until the two pointers meet
            # Calculate the area between the two pointers:
            # The height of the container is determined by the shorter line (min(height[left], height[right]))
            # The width is the distance between the two pointers (right - left)
            max_area = max(max_area, min(height[left], height[right]) * (right - left))

            # Move the pointer that is at the shorter height:
            # - If height[left] is smaller, moving it might increase the area by finding a taller line
            # - If height[right] is smaller, moving it might increase the area
            if height[left] < height[right]:
                left += 1  # Move left pointer to the right
            else:
                right -= 1  # Move right pointer to the left
        
        return max_area  # Return the maximum area found




Solution = Solution()
height = [1,8,6,2,5,4,8,3,7]
print(Solution.maxArea(height))  # Output: 49

height = [1,1]
print(Solution.maxArea(height))  # Output: 1
