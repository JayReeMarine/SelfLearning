#https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/

class Solution:
    def kthCharacter(self, k: int) -> str:
        def next_char(c):
            return chr((ord(c)) - ord('a') + 1 % 26 + ord('a'))

        word = "a"
        while len(word) <= k:
            newWord = "".join(next_char(c) for c in word)
            word += newWord
        
        return word[k-1]


