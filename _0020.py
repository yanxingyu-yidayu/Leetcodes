#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@author: yanxingyu
@email: 2512466437@qq.com
@time: 2022/8/15 16:19
"""


class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for i in range(len(s)):
            if s[i] == "(":
                stack.append('(')
            if s[i] == "[":
                stack.append('[')
            if s[i] == "{":
                stack.append('{')
            if s[i] == ")":
                if len(stack) == 0:
                    return False
                top = stack.pop()
                if top != "(":
                    return False
            if s[i] == "]":
                if len(stack) == 0:
                    return False
                top = stack.pop()
                if top != "[":
                    return False
            if s[i] == "}":
                if len(stack) == 0:
                    return False
                top = stack.pop()
                stack.get(top)
                # if stack[-1] == "{":可用此判断栈顶
                if top != "{":
                    return False
        if len(stack) == 0:
            return True
        else:
            return False


dia = Solution()
s = "[]{(})"

result = dia.isValid(s)
print(result)







