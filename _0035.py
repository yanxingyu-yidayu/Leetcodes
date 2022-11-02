#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@author: yanxingyu
@email: 2512466437@qq.com
@time: 2022/8/16 12:38
"""


class Solution:
    def searchInsert(self, nums: list[int], target: int) -> int:
        if len(nums) == 0:
            return 0
        if target <= nums[0]:
            return 0
        if target > nums[len(nums)-1]:
            return len(nums)
        left = 0
        right = len(nums) - 1
        mid = (left + right) // 2
        while left < right:
            mid = (left + right) // 2
            if nums[mid] == target:
                if nums[mid - 1] < target:
                    return mid
                else:
                    right = mid
            elif nums[mid] > target:
                if nums[mid - 1] < target:
                    return mid
                else:
                    right = mid
            else:
                if nums[mid + 1] >= target:
                    return mid + 1
                else:
                    left = mid + 1

        return mid

    def searchInsert2(self, nums: list[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        mid = (left + right) // 2
        while left <= right:
            mid = (right - left) // 2 + left
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return left


dia = Solution()
s = [5, 6, 7, 7, 7, 7, 8, 9]
# s = [1, 3]
result = dia.searchInsert2(s, 10)
print(result)

