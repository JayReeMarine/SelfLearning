#https://leetcode.com/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150
from collections import defaultdict

class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        """
        Determines if the `ransomNote` can be constructed using the letters in `magazine`.
        Each letter in `magazine` can only be used once.

        Args:
        ransomNote (str): The string representing the ransom note.
        magazine (str): The string representing the available letters.

        Returns:
        bool: True if `ransomNote` can be constructed, False otherwise.
        """

        # Step 1: Create a dictionary to store character counts from `magazine`
        counter = defaultdict(int)  # Default value for missing keys is 0

        # Step 2: Count occurrences of each character in `magazine`
        for i in magazine:
            counter[i] += 1  # Increment the count for character `i`

        # Step 3: Iterate through `ransomNote` and check if letters are available
        for i in ransomNote:
            if counter[i] == 0:  # If a letter is missing, return False immediately
                return False
            elif counter[i] > 0:
                counter[i] -= 1  # Use one occurrence of the letter

        # Step 4: If all characters in `ransomNote` were found in `magazine`, return True
        return True
