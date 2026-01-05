class Solution:
    def sumFourDivisors(self, nums: List[int]) -> int:
        result = 0

        for num in nums:
            divisors = self.getDivisors(num)
            if  len(divisors) == 4:
                result += sum(divisors)
        
        return result

    def getDivisors(self, num: int) -> List[int]:
        divisors = []

        for i in range(1, int(num ** 0.5) + 1):
            if num % i == 0:
                if i == num//i:
                    divisors.append(i)
                else:
                    divisors.extend([i, num//i])

        return divisors
            
