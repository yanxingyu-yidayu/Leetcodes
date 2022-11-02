#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@author: yanxingyu
@email: 2512466437@qq.com
@time: 2022/8/10 21:37
"""
import sys
from this import s


class Solution:
    def myAtoi(self, s: str) -> int:
        # len : int = len(s)
        INT_MAX = 2 ** 31 - 1
        INT_MIN = -2 ** 31
        sLen = len(s)
        if sLen == 0:
            return 0
        i = 0
        Sum: int = 0
        flag = True
        c = s[i]
        while c == ' ':
            i += 1
            if i == sLen:
                return 0
            c = s[i]
        if c == '-':
            i += 1
            flag = False
            if i == sLen:
                return 0
            c = s[i]
            if c > '9' or c < '0':
                return 0
        if c == '+':
            i += 1
            if i == sLen:
                return 0
            c = s[i]
            if c > '9' or c < '0':
                return 0
        while '9' >= c >= '0':
            n: int = ord(c) - ord('0')
            Sum = Sum * 10 + n
            if Sum > INT_MAX:
                if flag:
                    return INT_MAX
                else:
                    return -1 - INT_MAX
            i += 1
            if i == sLen:
                break
            c = s[i]
        if flag:
            return Sum
        else:
            return 0 - Sum


dia = Solution()
s = "  987934636434587"
result = dia.myAtoi(s)
print(result)
