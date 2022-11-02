#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@author: yanxingyu
@email: 2512466437@qq.com
@time: 2022/8/15 22:17
"""


class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        if len(nums) == 0:
            return [-1, -1]
        if target < nums[0] or target > nums[len(nums) - 1]:
            return [-1, -1]
        mid = (nums[0] + nums[len(nums) - 1]) // 2
        left = 0
        right = len(nums) - 1
        LSide = mid
        while left < right:
            LSide = (left + right) // 2
            if nums[LSide] == target:
                if nums[LSide - 1] < target:
                    break
                else:
                    right = LSide
            elif nums[LSide] < target:
                left = LSide + 1
            else:
                right = LSide
        LSide = (left + right) // 2

        left = 0
        right = len(nums) - 1
        if nums[right] == target:
            return [LSide, right]
        RSide = (left + right) // 2
        while left < right:
            RSide = (left + right) // 2
            if nums[RSide] == target:
                if nums[RSide + 1] > target:
                    break
                else:
                    left = RSide
            elif nums[RSide] < target:
                left = RSide + 1
            else:
                right = RSide
        RSide = (left + right) // 2
        if nums[LSide] != target:
            return [-1, -1]
        else:
            return [LSide, RSide]


dia = Solution()
s = [5, 6, 7, 7, 7, 7, 8, 9]
s = [2, 2]
result = dia.searchRange(s, 2)
print(result)
