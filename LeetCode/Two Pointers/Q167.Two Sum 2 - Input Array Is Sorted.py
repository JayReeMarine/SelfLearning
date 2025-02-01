#https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150


class Solution:
    def twoSum(self, numbers: list[int], target: int) -> list[int]:
        """
        Given a sorted array 'numbers' and a target sum, find the indices of two numbers
        that add up to the target. The array is 1-based indexed.

        Args:
        numbers (list[int]): A list of integers (sorted in non-decreasing order).
        target (int): The target sum.

        Returns:
        list[int]: A list containing the indices (1-based) of the two numbers that add up to the target.
                   If no such numbers exist, return [-1, -1].
        """

        # Initialize two pointers: 
        # 'left' starts at the beginning, 'right' starts at the end.
        left, right = 0, len(numbers) - 1  

        # Iterate while left pointer is before or at the right pointer
        while left <= right:
            # Calculate the sum of the two numbers at the current pointers
            current_sum = numbers[left] + numbers[right]

            # If the sum matches the target, return the 1-based indices
            if current_sum == target:
                return [left + 1, right + 1]  # Convert to 1-based indexing
            
            # If the sum is too small, move the left pointer rightward to increase the sum
            elif current_sum < target:
                left += 1
            
            # If the sum is too large, move the right pointer leftward to decrease the sum
            else:
                right -= 1

        # If no valid pair is found, return [-1, -1]
        return [-1, -1]


Solution = Solution()
numbers = [2,7,11,15]
target = 9
print(Solution.twoSum(numbers,target))  # Output: [1,2]


numbers = [2,3,4]
target = 6
print(Solution.twoSum(numbers,target))  # Output: [1,3]