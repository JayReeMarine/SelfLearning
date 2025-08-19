#https://leetcode.com/problems/keys-and-rooms/description/

from typing import List

class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        self.visited = [0] * len(rooms)


        def traverseRoom(n, rooms):
            self.visited[n] = 1
            for key in rooms[n]:            
                if self.visited[key] == 0:  
                    traverseRoom(key, rooms) 
                
        traverseRoom(0, rooms)
        return all(self.visited)
                