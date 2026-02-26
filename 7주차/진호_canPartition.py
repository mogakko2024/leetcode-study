class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)

        # 총 합이 홀수면 불가능
        if total % 2 != 0:
            return False

        # 같은 합을 가지는 두 부분집합을 찾는 것이므로 총 합의 절반을 목표로 함
        target = total // 2

        # dp[i] = i 의 합을 가지는 부분집합이 존재하는지 여부
        dp = [False] * (target + 1)
        # 0 의 합을 가지는 부분집합은 항상 존재하므로 True
        dp[0] = True

        # 각 숫자를 확인하면서 해당 숫자를 포함하는 부분집합이 존재하는지 확인
        for num in nums:
            for i in range(target, num - 1, -1):
                dp[i] = dp[i] or dp[i - num]

        # 목표 합을 가지는 부분집합이 존재하는지 여부 반환
        return dp[target]
