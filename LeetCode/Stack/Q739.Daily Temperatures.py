#https://leetcode.com/problems/daily-temperatures/

from collections import deque

class Solution:
    def dailyTemperatures(self, temperatures: list[int]) -> list[int]:
        """
        This function takes a list of daily temperatures and returns a list where
        each element represents the number of days until a warmer temperature. 
        If no warmer temperature exists, the value will be 0.
        
        :param temperatures: List of integers representing daily temperatures.
        :return: List of integers where each element indicates days until a warmer temperature.
        """
        # Initialize the result list with zeros, one for each temperature.
        res = [0] * len(temperatures)
        
        # Use a stack to keep track of temperatures and their indices.
        # This will help efficiently determine when a warmer temperature occurs.
        stack = deque()

        # Iterate over the temperatures along with their indices.
        for i, t in enumerate(temperatures):
            # Check if the stack is not empty and the current temperature is greater
            # than the temperature at the top of the stack (a colder day from before).
            while stack and t > stack[-1][0]:
                # Pop the top temperature and its index from the stack.
                stackT, stackI = stack.pop()
                
                # Calculate the number of days between the current day and the day
                # represented by the popped temperature index, and store it in the result.
                res[stackI] = i - stackI

            # Append the current temperature and its index to the stack.
            # This means we are waiting to find a warmer temperature for this day.
            stack.append((t, i))
        
        # Return the final result list. Days without a warmer temperature will remain 0.
        return res


Solution = Solution()

temperatures = [73,74,75,71,69,72,76,73]

print(Solution.dailyTemperatures(temperatures))