#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@author: yanxingyu
@email: 2512466437@qq.com
@time: 2022/8/16 14:50
"""


class Solution:
    def isValidSudoku(self, board: list[list[str]]) -> bool:
        rows: list[list[str]] = [[], [], [], [], [], [], [], [], []]
        cols: list[list[str]] = [[], [], [], [], [], [], [], [], []]
        boxes: list[list[str]] = [[], [], [], [], [], [], [], [], []]
        for i in range(len(board)):
            strs = board[i]
            for j in range(len(strs)):
                if strs[j] == ".":
                    continue
                if strs[j] in rows[i]:
                    return False
                else:
                    rows[i].append(strs[j])
                if strs[j] in cols[j]:
                    return False
                else:
                    cols[j].append(strs[j])
                index = i // 3 + (j // 3) * 3
                if strs[j] in boxes[index]:
                    return False
                else:
                    boxes[index].append(strs[j])
        return True


dia = Solution()
s = [5, 6, 7, 7, 7, 7, 8, 9]
# s = [1, 3]
board = [["8", "3", ".", ".", "7", ".", ".", ".", "."]
    , ["6", ".", ".", "1", "9", "5", ".", ".", "."]
    , [".", "9", "8", ".", ".", ".", ".", "6", "."]
    , ["8", ".", ".", ".", "6", ".", ".", ".", "3"]
    , ["4", ".", ".", "8", ".", "3", ".", ".", "1"]
    , ["7", ".", ".", ".", "2", ".", ".", ".", "6"]
    , [".", "6", ".", ".", ".", ".", "2", "8", "."]
    , [".", ".", ".", "4", "1", "9", ".", ".", "5"]
    , [".", ".", ".", ".", "8", ".", ".", "7", "9"]]

result = dia.isValidSudoku(board)
print(result)
