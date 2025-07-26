#https://leetcode.com/problems/valid-word/description/

# class Solution:
#     def isValid(self, word: str) -> bool:
#         if len(word) < 3:
#             return False

#         vowel = False
#         consonant = False
#         vowels = set('aeiouAEIOU')

#         for i in word:
#             if not i.isalnum():
#                 return False

#             if i in vowels:
#                 vowel = True
#             elif i.isalpha():
#                 consonant = True

#         return vowel and consonant

class Solution:
    def isValid(self, word: str) -> bool:
        def is_alnum(ch):
            return ('a' <= ch <= 'z') or ('A' <= ch <= 'Z') or ('0' <= ch <= '9')

        def is_alpha(ch):
            return ('a' <= ch <= 'z') or ('A' <= ch <= 'Z')
        
        vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
        
        if len(word) < 3:
            return False
        
        has_vowel = False
        has_consonant = False
        
        for ch in word:
            if not is_alnum(ch):
                return False
            
            if ch in vowels:
                has_vowel = True
            elif is_alpha(ch):
                has_consonant = True
        
        return has_vowel and has_consonant
