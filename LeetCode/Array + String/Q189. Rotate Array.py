#https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def rotate(self, nums: list[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        This function rotates the array to the right by k steps.
        """

        # ==============================
        # ✅ Faster solution: O(n) time
        # ==============================

        n = len(nums)
        k = k % n  # Handle cases where k > n to avoid unnecessary rotations

        # Step 1: Reverse the entire array
        nums.reverse()
        # Example: [1, 2, 3, 4, 5, 6, 7] → [7, 6, 5, 4, 3, 2, 1]

        # Step 2: Reverse the first k elements
        nums[:k] = reversed(nums[:k])
        # Example (k=3): [7, 6, 5, 4, 3, 2, 1] → [5, 6, 7, 4, 3, 2, 1]

        # Step 3: Reverse the remaining n-k elements
        nums[k:] = reversed(nums[k:])
        # Example (k=3): [5, 6, 7, 4, 3, 2, 1] → [5, 6, 7, 1, 2, 3, 4]

        # ✅ Final Output: nums = [5, 6, 7, 1, 2, 3, 4]
        # This achieves the rotation in O(n) time with O(1) extra space.

        # ==============================
        # ❌ Slower solution: O(n × k) time
        # ==============================

        # The naive approach that leads to TLE (Time Limit Exceeded) in large test cases.
        # This method shifts elements one-by-one k times, leading to O(n × k) complexity.

        # n = len(nums)
        # k = k % n  # Handle cases where k > n

        # for i in range(k):  # Perform k rotations
        #     last = nums[-1]  # Store the last element
        #     for j in range(n - 1, 0, -1):  # Shift all elements to the right
        #         nums[j] = nums[j - 1]
        #     nums[0] = last  # Place the last element at the first position
        # return

    
Solution = Solution()
nums = [1,2,3,4,5,6,7]
k = 3
Solution.rotate(nums, k)  # Output: [5,6,7,1,2,3,4]
