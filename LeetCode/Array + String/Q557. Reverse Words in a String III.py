#https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
class Solution:
    def reverseWords(self, s: str) -> str:
        # split = s.split(" ")

        # for i in range(len(split)):
        #     split[i] = split[i][::-1]

        # return " ".join(split)
        return ' '.join(word[::-1] for word in s.split())