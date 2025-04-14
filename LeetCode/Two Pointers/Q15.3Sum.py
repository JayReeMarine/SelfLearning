#https://leetcode.com/problems/3sum/description/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        res = []  # List to store the unique triplets
        nums.sort()  # Sort the array to facilitate two-pointer technique and avoid duplicates

        for i in range(len(nums)):
            # Skip duplicate elements to prevent duplicate triplets in the result
            if i > 0 and nums[i] == nums[i - 1]:
                continue  # Skip this iteration

            fixValue = nums[i]  # Fixed number for this iteration
            left = i + 1  # Left pointer starts just after the fixed number
            right = len(nums) - 1  # Right pointer starts at the end of the array

            while left < right:
                total = fixValue + nums[left] + nums[right]  # Calculate the sum of the three numbers

                if total == 0:  # Found a valid triplet
                    res.append([fixValue, nums[left], nums[right]])  # Store the triplet
                    left += 1  # Move left pointer forward
                    right -= 1  # Move right pointer backward
                    
                    # Skip duplicate elements to ensure unique triplets
                    while left < right and nums[left] == nums[left - 1]:  
                        left += 1  # Move left pointer forward
                    while left < right and nums[right] == nums[right + 1]:  
                        right -= 1  # Move right pointer backward

                elif total < 0:  # If sum is less than zero, move left pointer to increase sum
                    left += 1
                else:  # If sum is greater than zero, move right pointer to decrease sum
                    right -= 1

        return res  # Return the list of unique triplets

    

Solution = Solution()
nums = [-1,0,1,2,-1,-4]
print(Solution.threeSum(nums))  # Output: [[-1,-1,2],[-1,0,1]]