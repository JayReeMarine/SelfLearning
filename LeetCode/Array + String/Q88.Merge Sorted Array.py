class Solution:
    def merge(self, nums1: list[int], m: int, nums2: list[int], n: int) -> None:
        """
        Merges two sorted arrays (nums1 and nums2) into one sorted array (nums1).
        Modifies nums1 in-place.
        
        Args:
        nums1 (list[int]): The first sorted array, with enough space at the end to hold nums2.
        m (int): Number of initialized elements in nums1.
        nums2 (list[int]): The second sorted array.
        n (int): Number of elements in nums2.

        Returns:
        None: Modifies nums1 in-place.
        """

        # If nums1 has no initialized elements, directly copy all elements from nums2 to nums1.
        if m == 0:
            for i in range(n):
                nums1[i] = nums2[i]
            return

        # Initialize pointers:
        a = m - 1  # Pointer to the last initialized element in nums1
        b = n - 1  # Pointer to the last element in nums2
        c = m + n - 1  # Pointer to the last position in nums1 (for merged elements)

        # Merge nums1 and nums2 from the back
        while a >= 0 and b >= 0:  # While both pointers are valid
            if nums1[a] >= nums2[b]:  # Compare the current largest elements
                nums1[c] = nums1[a]  # Place the larger element at the end of nums1
                a -= 1  # Move pointer in nums1 to the left
            else:
                nums1[c] = nums2[b]  # Place the larger element from nums2 into nums1
                b -= 1  # Move pointer in nums2 to the left
            c -= 1  # Move the merge pointer to the left

        # If there are remaining elements in nums2, copy them into nums1
        while b >= 0:  # No need to check nums1 because it's already sorted
            nums1[c] = nums2[b]
            b -= 1
            c -= 1

        # No return statement is needed because nums1 is modified in-place
        return

Solution = Solution()
# nums1 = [1,2,3,0,0,0]
# m = 3
# nums2 = [2,5,6]
# n = 3
# Solution.merge(nums1, m, nums2, n)        

nums1 = [4,5,6,0,0,0]
m = 3
nums2 = [1,2,3]
n = 3
Solution.merge(nums1, m, nums2, n)    
        