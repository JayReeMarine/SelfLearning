#https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150


class Solution:
    def twoSum(self, numbers: list[int], target: int) -> list[int]:
        left , right = 0, len(numbers) - 1

        while left <= right:
            k  = (left + right) // 2
            if numbers[left] + numbers[right] == target:
                return [left + 1, right + 1]
            elif numbers[left] + numbers[right] < target:
                left += 1
            else:
                right -= 1

        return [-1,-1]

Solution = Solution()
numbers = [2,7,11,15]
target = 9
print(Solution.twoSum(numbers,target))  # Output: [1,2]


numbers = [2,3,4]
target = 6
print(Solution.twoSum(numbers,target))  # Output: [1,3]