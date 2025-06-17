from collections import List
class Solution:
    def wateringPlants(self, plants: List[int], capacity: int) -> int:
        cur = capacity
        steps = 0

        for i, water_needed in enumerate(plants):
            if cur >= water_needed:
                steps += 1
                cur -= water_needed
            else:
                steps += (i * 2) + 1
                cur = capacity - water_needed
        
        return steps
