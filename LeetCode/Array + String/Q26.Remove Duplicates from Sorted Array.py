#https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150


class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        """
        Removes duplicates from a sorted list in-place.
        Modifies 'nums' such that each unique element appears only once.
        
        Args:
        nums (list[int]): The input sorted list of integers.

        Returns:
        int: The number of unique elements in 'nums'.
        """

        # If the list is empty, return 0 (edge case handling)
        if not nums:
            return 0

        # Pointer (i) to track the position of the next unique element
        i = 1

        # Iterate through the list starting from index 1 (since index 0 is always unique)
        for j in range(1, len(nums)):
            # If the current element is different from the previous one, it is unique
            if nums[j] != nums[j - 1]:
                nums[i] = nums[j]  # Copy the unique element to the position i
                i += 1  # Increment i to track the next position for unique elements

        # Return the number of unique elements found
        return i



nums = [1,1,2]
Solution = Solution()
print(Solution.removeDuplicates(nums))  # Output: 2