# class Solution:
#     def leastInterval(self, tasks: list[str], n: int) -> int:
#         freq = {}
#         x = 0
#         for num in tasks:
#             if num in freq:
#                 freq[num] +=1
#             else:
#                 freq[num] = 1
        
#         max_freq = max(freq.values())

#         for value in freq.values():
#             if value == max_freq:
#                 x+=1

#         return max((n+1) *(max_freq-1) +x,len(tasks))

from collections import Counter, deque
import heapq

class Solution:
    def leastInterval(self, tasks: list[str], n: int) -> int:
        freq = Counter(tasks)
        heap = [-cnt for cnt in freq.values()]  
        heapq.heapify(heap)

        time = 0
        cooldown = deque()  

        while heap or cooldown:
            time += 1

            if heap:
                cnt = heapq.heappop(heap) + 1  
                if cnt != 0:
                    cooldown.append((time + n, cnt))  

            if cooldown and cooldown[0][0] == time:
                _, ready_task = cooldown.popleft()
                heapq.heappush(heap, ready_task)

        return time