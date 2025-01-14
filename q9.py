class Solution:
    def isPalindrome(self, x: int) -> bool:
        x_str = str(x)

        for i in range(len(x_str)//2):
            if x_str[i] != x_str[-(i+1)]:
                return False
        return True

    #solve it without converting string
    def isPalindrome(self, x: int) -> bool:
        if x<0 or (x !=0 and x %10 ==0):
            return False
    
        half = 0 
        while x > half:
            half = (half *10) + (x%10)
            x = x//10
        
        return x == half or x == half //10



x = 121
solution = Solution()
print(solution.isPalindrome(x))