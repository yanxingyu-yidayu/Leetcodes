#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@author: yanxingyu
@email: 2512466437@qq.com
@time: 2022/8/11 9:19
"""


class Solution:
    def intToRoman(self, num: int) -> str:
        # I 1; V 5;X 10;L 50;C 100;D 500;M 1000;

        roman: str = ""
        numK: int = int(num / 1000)
        num = num % 1000
        numH: int = int(num / 100)
        num = num % 100
        numX: int = int(num / 10)
        numI: int = int(num % 10)
        # 千位
        for i in range(numK):
            roman = roman + "M"
        # 百位
        if numH == 9:
            roman = roman + "CM"
        elif numH >= 5:
            roman = roman + "D"
            for i in range(5, numH):
                roman = roman + "C"
        elif numH == 4:
            roman = roman + "CD"
        else:
            for i in range(numH):
                roman = roman + "C"
        # 十位
        if numX == 9:
            roman = roman + "XC"
        elif numX >= 5:
            roman = roman + "L"
            for i in range(5, numX):
                roman = roman + "X"
        elif numX == 4:
            roman = roman + "XL"
        else:
            for i in range(numX):
                roman = roman + "X"
        # 个位
        if numI == 9:
            roman = roman + "IX"
        elif numI >= 5:
            roman = roman + "V"
            for i in range(5, numI):
                roman = roman + "I"
        elif numI == 4:
            roman = roman + "IV"
        else:
            for i in range(numI):
                roman = roman + "I"
        return roman


dia = Solution()
s = 547
result = dia.intToRoman(s)
print(result)
