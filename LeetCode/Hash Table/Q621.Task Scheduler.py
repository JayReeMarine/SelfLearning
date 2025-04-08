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
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq = Counter(tasks)
        heap = [-cnt for cnt in freq.values()]  # Max Heap을 위해 음수 사용
        heapq.heapify(heap)

        time = 0
        cooldown = deque()  # (재사용 가능 시간, count)

        while heap or cooldown:
            time += 1

            if heap:
                cnt = heapq.heappop(heap) + 1  # 작업 1번 실행 (음수니까 +1)
                if cnt != 0:
                    cooldown.append((time + n, cnt))  # 쿨다운 큐에 저장

            if cooldown and cooldown[0][0] == time:
                _, ready_task = cooldown.popleft()
                heapq.heappush(heap, ready_task)

        return time