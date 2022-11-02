#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@author: yanxingyu
@email: 2512466437@qq.com
@time: 2022/8/22 16:28
"""
from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        left = 0
        right = 0
        Sum = 0
        i = 0
        Len = len(height)
        height.append(0)
        # while i < len(height):
        while left < Len - 1:
            # 先找到第一个左边，就是第一个极大值
            while height[left] <= height[left + 1]:
                left += 1
            # 确定好左边，开始找右边
            right = left + 1
            tmp = 0
            while right < Len:
                if height[right - 1] < height[right] and height[right] > height[right + 1]:
                    break
                tmp += height[left] - height[right]
                right += 1
            if right < Len:
                Sum += tmp
                if height[right] < height[left]:
                    Sum -= (height[left] - height[right]) * (right - left - 1)
            left = right
        return Sum


dia = Solution()
s = [4, 2, 0, 3, 2, 5]
result = dia.trap(s)
print(result)
