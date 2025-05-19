#https://leetcode.com/problems/richest-customer-wealth/description/
from typing import List
class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        max_wealth = float('-inf')


        for i in range(len(accounts)):
            wealth = 0
            for j in range(len(accounts[i])):
                wealth += accounts[i][j]
            if wealth > max_wealth:
                max_wealth = wealth
        
        return max_wealth
    

Solution = Solution()
# Example usage:
accounts = [[1,2,3],[3,2,1],[4,5,6]]
print(Solution.maximumWealth(accounts))  # Output: 15