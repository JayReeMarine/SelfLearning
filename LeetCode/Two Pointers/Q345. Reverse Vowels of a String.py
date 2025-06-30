#https://leetcode.com/problems/reverse-vowels-of-a-string/description/

class Solution:
    def reverseVowels(self, s: str) -> str:
        s = list(s)
        vowels = set("aeiouAEIOU")
        left, right = 0, len(s) - 1

        while left < right:
            while left < right and s[left] not in vowels:
                left += 1
            while left < right and s[right] not in vowels:
                right -= 1
            
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1
        
        return "".join(s)


        # vowels = set("aeiouAEIOU")
        # vowel_list = []
        # for i in s:
        #     if i.lower() in vowels:
        #         vowel_list.append(i)

        # cur = len(vowel_list) - 1
        # s = list(s)
        # for i in range(len(s)):
        #     if s[i].lower() in vowels:
        #         s[i] = vowel_list[cur]
        #         cur -=1
        
        # return "".join(s)

        