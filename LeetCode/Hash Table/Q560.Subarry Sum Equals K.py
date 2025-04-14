#https://leetcode.com/problems/subarray-sum-equals-k/

class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        res = 0
        curSum = 0
        prefix = {0:1}

        for num in nums:
            curSum += num
            diff = curSum - k
            res += prefix.get(diff,0)
            prefix[curSum] = prefix.get(curSum, 0) + 1
        
        return res

        # if len(nums) == 0:
        #     return 0
        # if len(nums) == 1:
        #     return 1 if nums[0] == k else 0
        
        # prefix = [0]
        # res = 0

        # for num in nums:
        #     prefix.append(prefix[-1] + num)

        # for i in range(len(prefix)):
        #     for j in range(i+1,len(prefix)):
        #         if prefix[j] - prefix[i] == k:
        #             res +=1

        
        # return res
        

# Test the function
Solution = Solution()
# nums = [1, 1, 1]
# k = 2
# result = Solution.subarraySum(nums, k)


# nums = [1]
# k = 0
# result = Solution.subarraySum(nums, k)
# print(result)  # Output: 0

nums = [-1,-1,1]
k = 0
result = Solution.subarraySum(nums, k)
print(result)  # Output: 1