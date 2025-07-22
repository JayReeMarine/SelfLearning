#https://leetcode.com/problems/add-binary/description/

class Solution:
    def addBinary(self, a: str, b: str) -> str:
        i, j = len(a) - 1, len(b) -1
        carry = 0
        res = []

        while i >= 0 or j >= 0 or carry:
            v1 = int(a[i]) if i >= 0 else 0
            v2 = int(b[j]) if j >= 0 else 0

            value = v1 + v2 + carry
            res.append(str(value %2))
            carry = value // 2

            # value = v1 + v2 + carry
            # if value == 2:
            #     value = 0
            #     carry = 1
            # elif value == 3:
            #     value = 1
            #     carry = 1
            # elif value == 1:
            #     value = 1
            #     carry = 0
            # elif value == 0:
            #     value = 0
            #     carry = 0
            
            # res.append(str(value))

            i -= 1
            j -= 1

        return ''.join(reversed(res))