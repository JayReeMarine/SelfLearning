class Solution:
    def removeElement(self, nums: list[int], val: int) -> int:
        """
        Removes all occurrences of 'val' from the list 'nums' in-place.
        Modifies 'nums' such that the first k elements contain only the elements not equal to 'val'.
        
        Args:
        nums (list[int]): The input list of integers.
        val (int): The value to remove from the list.

        Returns:
        int: The number of elements in 'nums' that are not equal to 'val'.
        """

        # Pointer (i) to track the next position to place a non-val element
        i = 0

        # Iterate through the entire list using index j
        for j in range(len(nums)):
            # If the current element is not equal to 'val':
            if nums[j] != val:
                nums[i] = nums[j]  # Place the element at position i
                i += 1  # Increment i to move to the next position

        # Return the count of elements not equal to 'val' (which is the pointer i)
        return i

        
Solution = Solution()
# nums = [3,2,2,3]
# val = 3


nums = [0,1,2,2,3,0,4,2]
val = 2
print(Solution.removeElement(nums, val))  # Output: 2                