#https://leetcode.com/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150
from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        """
        Groups anagrams together from a list of strings.

        Args:
        strs (list[str]): A list of input strings.

        Returns:
        list[list[str]]: A list of lists, where each inner list contains anagrams grouped together.
        """

        # Step 1: Create a defaultdict with list as default value type
        # This ensures each key automatically starts with an empty list when first accessed
        counter = defaultdict(list)

        # Step 2: Iterate through each string in the input list
        for s in strs:
            # Sort the characters of the string to create a common key for anagrams
            key = "".join(sorted(s))  # Example: "eat" → "aet", "tea" → "aet"
            
            # Append the original string to the corresponding anagram group in the dictionary
            counter[key].append(s)

        # Step 3: Return only the values (grouped anagrams) as a list of lists
        result = list(counter.values())

        return result
   

Solution = Solution()
print(Solution.groupAnagrams(["eat","tea","tan","ate","nat","bat"]))  # [["bat"],["nat","tan"],["ate","eat","tea"]]

print(Solution.groupAnagrams([""]))  # [[""]]

print(Solution.groupAnagrams(["a"]))  # [["a"]]


"""Approach
take out string
char array
sort it
convert to string
use this string as a key
then push all the related element to key
"""