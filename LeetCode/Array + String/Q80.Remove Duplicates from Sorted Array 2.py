#https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        """
        Removes duplicates in-place from a sorted list such that each unique element appears at most twice.
        The first k elements of nums should contain the allowed duplicates, and the function returns k.
        
        Args:
        nums (list[int]): The input sorted list of integers.

        Returns:
        int: The number of elements in nums that are kept in the modified list.
        """

        # If the list has 2 or fewer elements, return its length as no removal is needed
        if len(nums) <= 2:
            return len(nums)

        # Pointer (i) to track the position of the next allowed duplicate
        i = 2

        # Iterate through the list starting from index 2 (since first two elements are always allowed)
        for j in range(2, len(nums)):
            # If nums[j] is not equal to nums[i - 2], it means this element has not appeared more than twice
            if nums[j] != nums[i - 2]:
                nums[i] = nums[j]  # Copy the valid element to index i
                i += 1  # Move the pointer for the next position
        
        # Return the count of elements in the modified list
        return i

# Example usage
Solution = Solution()

# Example 1
# nums = [1,1,1,2,2,3]   # Output: 5 (Modified nums: [1,1,2,2,3,_])
nums = [0,0,1,1,1,1,2,3,3]  # Output: 7 (Modified nums: [0,0,1,1,2,3,3,_,_])
print(Solution.removeDuplicates(nums))

