#website: https://neetcode.io/problems/string-encode-and-decode

class Solution:
    """
    This class provides methods to encode a list of strings into a single string
    and decode that single string back into the original list of strings.
    """

    """
    @param: strs: A list of strings
    @return: A single encoded string representing the list of strings
    """
    def encode(self, strs: list[str]) -> str:
        # Initialize an empty string to hold the encoded result
        res = ""
        # Iterate through each string in the list
        for s in strs:
            # Append the length of the string, followed by '#', then the string itself
            # This format ensures each string is uniquely identifiable during decoding
            res += str(len(s)) + "#" + s
        # Return the encoded string
        return res

    """
    @param: s: A single encoded string
    @return: The decoded list of original strings
    """
    def decode(self, s: str) -> list[str]:
        # Initialize an empty list to store the decoded strings
        res = []
        # Initialize a pointer to traverse the encoded string
        i = 0

        # Loop until the pointer reaches the end of the encoded string
        while i < len(s):
            # Start a secondary pointer `j` at the current position `i`
            j = i
            # Move `j` forward to find the delimiter '#'
            while s[j] != "#":
                j += 1
            # Convert the substring from `i` to `j` into an integer
            # This gives the length of the next string
            length = int(s[i:j])
            # Extract the string of the given length starting after the '#'
            res.append(s[j + 1:j + 1 + length])
            # Move the main pointer `i` to the end of the current string
            # This prepares `i` for processing the next encoded segment
            i = j + 1 + length
        # Return the list of decoded strings
        return res

Solution = Solution()
input_data= ["neet","code","love","you"]

output_data=["neet","code","love","you"]

encoded_string = Solution.encode(input_data)
print(encoded_string)

decoded_string= Solution.decode(encoded_string)
print(decoded_string)

