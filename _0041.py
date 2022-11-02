#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@author: yanxingyu
@email: 2512466437@qq.com
@time: 2022/8/22 15:33
"""
from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        # 1234  12345  -1-1-1-1-1
        Len = len(nums) + 1
        indexes = [-1] * Len
        for num in nums:
            if Len > num > 0:
                if indexes[num - 1] == -1:
                    indexes[num - 1] = num
        for i in range(len(indexes)):
            if indexes[i] == -1:
                return i+1
        return 1


dia = Solution()
s = [2,1]
result = dia.firstMissingPositive(s)
print(result)
