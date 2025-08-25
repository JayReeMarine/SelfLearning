#https://leetcode.com/problems/find-the-winning-player-in-coin-game/description/

class Solution:
    def winningPlayer(self, x: int, y: int) -> str:
        # turn = "Bob"
        # while min(x, y//4):
        #     x -= 1
        #     y -= 4
        #     if turn == "Alice":
        #         turn = "Bob"
        #     else:
        #         turn = "Alice"

        # return turn
        moves = min(x, y // 4)
        return "Alice" if moves % 2 else "Bob"