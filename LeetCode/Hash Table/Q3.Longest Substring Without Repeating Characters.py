#https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # res = []
        # s_list = [char for char in s]
        # for i in range(len(s_list)):
        #     seen = []
        #     seen.append(s_list[i])
        #     for j in range(i+1,len(s_list)):
        #         if s_list[j] in seen:
        #             res.append(len(seen))
        #             break
        #         else:
        #             seen.append(s_list[j])
        # return max(res)
        seen = {}
        left = 0
        max_length = 0
        for right in range(len(s)):
            while s[right] in seen:
                seen.remove(s[left])
                left += 1
            seen.add(s[right])
            max_length = max(max_length, right -left +1)
        return max_length


s= "pwwkew"

solution = Solution()
print(solution.lengthOfLongestSubstring(s))
# Output: 3