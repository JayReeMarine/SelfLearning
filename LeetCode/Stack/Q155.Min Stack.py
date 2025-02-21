#https://leetcode.com/problems/min-stack/?envType=study-plan-v2&envId=top-interview-150


from collections import deque


minStack = deque()

minStack.append(1)
#minStack.append(2)

print(minStack[-1])