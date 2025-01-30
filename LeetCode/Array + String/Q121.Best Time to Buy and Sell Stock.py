#https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        """
        Finds the maximum profit that can be achieved from a list of stock prices.
        The function assumes that we can buy and sell **once**.
        
        Args:
        prices (list[int]): A list where prices[i] represents the stock price on day i.

        Returns:
        int: The maximum profit that can be made.
        """

        # Initialize maxProfit to 0 (no transactions means no profit)
        maxProfit = 0

        # Start by assuming we buy on the first day
        buy = prices[0]

        # Iterate through the price list to find the best selling price
        for sell in prices:
            if sell > buy:  # If the current price is higher than the buying price
                maxProfit = max(maxProfit, sell - buy)  # Calculate potential profit
            else:
                buy = sell  # Update buy price if a lower price is found
        
        return maxProfit  # Return the maximum profit found



prices = [7,1,5,3,6,4]
Solution = Solution()
print(Solution.maxProfit(prices))  # Output: 5

prices = [7,6,4,3,1]
print(Solution.maxProfit(prices))  # Output: 0