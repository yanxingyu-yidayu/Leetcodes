#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@author: yanxingyu
@email: 2512466437@qq.com
@time: 2022/8/11 16:24
"""
from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        slen = len(strs)
        commonStr = ""
        flag = True
        Len = 0
        if strs[0] == "":
            return ""
        while flag:
            str0 = strs[0]
            if Len == len(str0):
                flag = False
                return commonStr
            ch = str0[Len]
            for i in range(0, slen):
                if strs[i] == "":
                    return ""
                stri = strs[i]
                if Len == len(stri):
                    flag = False
                    return commonStr
                if stri[Len] != ch:
                    flag = False
                    break
            if flag:
                commonStr += ch
                Len += 1

        return commonStr


dia = Solution()
s = ['xiaoWang', 'xiaoZhang', 'xiaoHua', '']
s = ['x']
result = dia.longestCommonPrefix(s)
print(result)



