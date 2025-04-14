#https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        """
        Finds the maximum profit that can be achieved from a list of stock prices.
        The function assumes that we can buy and sell **multiple times** but must sell before buying again.
        
        Args:
        prices (list[int]): A list where prices[i] represents the stock price on day i.

        Returns:
        int: The maximum profit that can be made.
        """

        # Initialize maxProfit to 0 (no transactions means no profit)
        maxProfit = 0

        # Start by assuming we buy on the first day
        buy = prices[0]
        subProfit = 0  # Temporary variable to track potential profit for a single transaction

        # Iterate through the price list, starting from the second day
        for i in range(1, len(prices)):           
            if prices[i] > buy:  # If current price is higher than buy price
                if subProfit < prices[i] - buy:  # Check if new profit is higher than previous
                    subProfit = prices[i] - buy
                    maxProfit += subProfit  # Add profit to total
                    buy = prices[i]  # Update buy price to current price (acting as a sell action)
                    subProfit = 0  # Reset subProfit since the transaction is completed
            else:
                buy = prices[i]  # Update buy price to the current lower price
        
        return maxProfit  # Return the maximum profit found

    

Solution = Solution()
prices = [7,1,5,3,6,4]
print(Solution.maxProfit(prices))  # Output: 7

prices = [1,2,3,4,5]
print(Solution.maxProfit(prices))  # Output: 4

prices = [7,6,4,3,1]
print(Solution.maxProfit(prices))  # Output: 0
