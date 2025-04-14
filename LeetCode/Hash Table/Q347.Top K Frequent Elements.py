#https://leetcode.com/problems/top-k-frequent-elements/description/

class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        count = {}
        freq = [[] for i in range(len(nums) + 1)]

        for n in nums:
            count[n] = 1 + count.get(n, 0)
        
        for n, c in count.items():
            freq[c].append(n)
        
        res = []
        for i in range(len(freq) - 1, 0, -1):
            for n in freq[i]:
                res.append(n)
                if len(res) == k:
                    return res
        
        # res = []
        # if k == 0:
        #     return []
        # if len(nums) == 1:
        #     return nums

        # count = defaultdict(int)

        # for i in nums:
        #     count[i] +=1
        # print(count)

        # for i in range(k):
        #     maxVal = max(count, key = count.get)
        #     res.append(maxVal)
        #     count.pop(maxVal)
           

        # return res

        