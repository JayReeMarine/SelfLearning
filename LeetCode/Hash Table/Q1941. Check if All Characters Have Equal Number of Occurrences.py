#https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/

class Solution:
    def areOccurrencesEqual(self, s: str) -> bool:
        occur = {}

        for i in s:
            if i not in occur:
                occur[i] = 1
            else:
                occur[i] +=1

        val = occur[s[0]]
        for i in occur:
            if val != occur[i]:
                return False

        return True

        # counts = Counter(s)
        # return len(set(counts.values())) == 1

