class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        length = len(nums)
        target = length / 2

        cnt = {}

        for num in nums:
            cnt[num] = cnt.get(num, 0) + 1

            if cnt[num] > target:
                return num

        return 0
