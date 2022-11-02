#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@author: yanxingyu
@email: 2512466437@qq.com
@time: 2022/8/11 11:06
"""
M = 1000
D = 500
C = 100
L = 50
X = 10
V = 5
I = 1

class Solution:
    def romanToInt(self, s: str) -> int:
        num = 0
        length = len(s)
        i = -1
        while i < length - 1:
            i += 1
            if s[i] == 'M':
                num += 1000
            if s[i] == 'D':
                num += 500
            if s[i] == 'C':
                if i < length - 1 and s[i + 1] == 'M':
                    num += 900
                    i = i + 1
                    continue
                if i < length - 1 and s[i + 1] == 'D':
                    num += 400
                    i += 1
                    continue
                num += 100
            if s[i] == 'L':
                num += 50
            if s[i] == 'X':
                if i < length - 1 and s[i + 1] == 'C':
                    num += 90
                    i += 1
                    continue
                if i < length - 1 and s[i + 1] == 'L':
                    num += 40
                    i += 1
                    continue
                num += 10
            if s[i] == 'V':
                num += 5
            if s[i] == 'I':
                if i < length - 1 and s[i + 1] == 'X':
                    num += 9
                    i += 1
                    continue
                if i < length - 1 and s[i + 1] == 'V':
                    num += 4
                    i += 1
                    continue
                num += 1
        return num


dia = Solution()
s = "MCMXCIV"
result = dia.romanToInt(s)
print(result)


