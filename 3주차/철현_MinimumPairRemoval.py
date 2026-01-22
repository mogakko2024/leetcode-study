class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
        result = 0

        while not self.isSorted(nums):
            result += 1

            minValue = float("inf")
            minIndex = -1

            for i in range(len(nums) - 1):
                if nums[i] + nums[i + 1] < minValue:
                    minValue = nums[i] + nums[i + 1]
                    minIndex = i

            # 내 코드
            # new_nums = nums[:minIndex]
            # new_nums.append(minValue)
            # new_nums.extend(nums[minIndex+2:])
            # nums = new_nums
            nums = nums[:minIndex] + [minValue] + nums[minIndex+2:]
        return result

    def isSorted(self, nums: List[int]) -> bool:
        for i in range(len(nums) - 1):
            if nums[i] > nums[i + 1]:
                return False
        return True

