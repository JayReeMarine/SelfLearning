#https://leetcode.com/problems/time-based-key-value-store/description/

class TimeMap:

    def __init__(self):
        self.timeMap = {}
        
    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.timeMap:
            self.timeMap[key] = []
        self.timeMap[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:        
        if key not in self.timeMap:
            return ""
        
        pairs = self.timeMap.get(key)
        l = 0
        r = len(pairs) - 1
        res = ""
        while l <= r:
            mid = (l+r)//2

            if pairs[mid][0] == timestamp:
                return pairs[mid][1]
            
            if pairs[mid][0] < timestamp:
                res = pairs[mid][1]
                l = mid + 1
            else:
                r = mid - 1
        
        return res
            

