#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@author: yanxingyu
@email: 2512466437@qq.com
@time: 2022/8/15 16:49
"""


class Solution:

    def generateParenthesis(self, n: int) -> list[str]:
        tSet = set()
        if n == 0:
            return []
        if n == 1:
            tSet.add("()")
            return list(tSet)
        tSet.add("()")
        for i in range(2, n+1):
            newSet = set()
            for j in tSet:
                append(self, newSet, j)
            tSet = newSet
        return list(tSet)


def append(self, newSet: set, j: str):
    newSet.add("()" + j)
    for i in range(1, len(j)):
        newStr = j[0: i] + "()" + j[i:]
        newSet.add(newStr)
    newSet.add(j + "()")


dia = Solution()
s = "[]{(})"

result = dia.generateParenthesis(4)
print(result)



