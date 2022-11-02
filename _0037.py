#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@author: yanxingyu
@email: 2512466437@qq.com
@time: 2022/8/16 15:59
"""

rows: list[list[str]] = [[], [], [], [], [], [], [], [], []]
cols: list[list[str]] = [[], [], [], [], [], [], [], [], []]
boxes: list[list[str]] = [[], [], [], [], [], [], [], [], []]
count: int = 0

def fillSure(board, count, blanks) -> bool:
    r = 10
    c = 10
    ind = 10
    for bl in blanks:
        remainder = ["1", "2", "3", "4", "5", "6", "7", "8", "9"]
        i = bl[0]
        j = bl[1]
        index = i // 3 + (j // 3) * 3
        remainder = list(set(remainder).difference(set(rows[i])))
        remainder = list(set(remainder).difference(set(cols[j])))
        remainder = list(set(remainder).difference(set(boxes[index])))
        poss = len(remainder)
        if poss == 1:
            r = i
            c = j
            ind = index
            break
    ch = remainder[0]
    board[r][c] = ch
    blanks.remove([r, c])
    rows[r].append(ch)
    cols[c].append(ch)
    boxes[ind].append(ch)
    count -= 1
    print(f'坐标[{r + 1}, {c + 1}]写{ch}')
    for st in board:
        print(st)
    print(count)
    if count == 0:
        return True

def fillTest(board, count, blanks) -> bool:
    for i in range(len(board)):
        strs = board(i)
        for j in range(len(strs)):
            if strs[j] == ".":
                remainder = ["1", "2", "3", "4", "5", "6", "7", "8", "9"]
                index = i // 3 + (j // 3) * 3
                remainder = list(set(remainder).difference(set(rows[i])))
                remainder = list(set(remainder).difference(set(cols[j])))
                remainder = list(set(remainder).difference(set(boxes[index])))


def fillBoard2(board, count, blanks) -> bool:
    fillSure(board, count, blanks)
    fillTest(board, count, blanks)




def fillBoard(board, count, blanks) -> bool:
    r = 10
    c = 10
    ind = 10
    Min = 9
    remainder = ["1", "2", "3", "4", "5", "6", "7", "8", "9"]
    for bl in blanks:
        remainder = ["1", "2", "3", "4", "5", "6", "7", "8", "9"]
        i = bl[0]
        j = bl[1]
        index = i // 3 + (j // 3) * 3
        remainder = list(set(remainder).difference(set(rows[i])))
        remainder = list(set(remainder).difference(set(cols[j])))
        remainder = list(set(remainder).difference(set(boxes[index])))
        poss = len(remainder)
        if poss == 1:
            Min = poss
            r = i
            c = j
            ind = index
            break
        if poss < Min:
            Min = poss
            r = i
            c = j
            ind = index
        if poss == Min:
            len1 = len(boxes[index]) + len(rows[i]) + len(cols[j])
            len2 = len(boxes[ind]) + len(rows[r]) + len(cols[c])
            if len1 > len2:
                Min = poss
                r = i
                c = j
                ind = index
    # 满了没有“。”
    if r == 10 and c == 10:
        return True
    remainder = ["1", "2", "3", "4", "5", "6", "7", "8", "9"]
    remainder = list(set(remainder).difference(set(rows[r])))
    remainder = list(set(remainder).difference(set(cols[c])))
    index = r // 3 + (c // 3) * 3
    remainder = list(set(remainder).difference(set(boxes[index])))
    if not remainder:
        print(f'坐标[{r}, {c}]无法写入')
        return False
    for ch in remainder:
        board[r][c] = ch
        blanks.remove([r, c])
        rows[r].append(ch)
        cols[c].append(ch)
        boxes[index].append(ch)
        count -= 1
        print(f'坐标[{r+1}, {c+1}]写{ch}，可选{remainder}')
        for st in board:
            print(st)
        print(count)
        if count == 0:
            return True
        full = fillBoard(board, count, blanks)
        if not full:
            board[r][c] = "."
            blanks.append([r, c])
            rows[r].remove(ch)
            cols[c].remove(ch)
            boxes[index].remove(ch)
            count += 1
            print(f'坐标[{r+1}, {c+1}]写{ch}错误，回退')
            continue
        else:
            break


class Solution:
    def solveSudoku(self, board: list[list[str]]) -> None:
        global count
        count = 0
        blanks = []
        for i in range(len(board)):
            strs = board[i]
            for j in range(len(strs)):
                if strs[j] == ".":
                    blanks.append([i, j])
                    count += 1
                    continue
                rows[i].append(strs[j])
                cols[j].append(strs[j])
                index = i // 3 + (j // 3) * 3
                boxes[index].append(strs[j])
        while count > 0:
            full = fillBoard(board, count, blanks)
            if full:
                break
        # fillBoard(board, count, blanks)
        for st in board:
            print(st)


dia = Solution()
s = [5, 6, 7, 7, 7, 7, 8, 9]
# s = [1, 3]
board = [["5", "3", ".", ".", "7", ".", ".", ".", "."]
    , ["6", ".", ".", "1", "9", "5", ".", ".", "."]
    , [".", "9", "8", ".", ".", ".", ".", "6", "."]
    , ["8", ".", ".", ".", "6", ".", ".", ".", "3"]
    , ["4", ".", ".", "8", ".", "3", ".", ".", "1"]
    , ["7", ".", ".", ".", "2", ".", ".", ".", "6"]
    , [".", "6", ".", ".", ".", ".", "2", "8", "."]
    , [".", ".", ".", "4", "1", "9", ".", ".", "5"]
    , [".", ".", ".", ".", "8", ".", ".", "7", "9"]]

board = [[".", ".", "9", "7", "4", "8", ".", ".", "."],
         ["7", ".", ".", ".", ".", ".", ".", ".", "."],
         [".", "2", ".", "1", ".", "9", ".", ".", "."],
         [".", ".", "7", ".", ".", ".", "2", "4", "."],
         [".", "6", "4", ".", "1", ".", "5", "9", "."],
         [".", "9", "8", ".", ".", ".", "3", ".", "."],
         [".", ".", ".", "8", ".", "3", ".", "2", "."],
         [".", ".", ".", ".", ".", ".", ".", ".", "6"],
         [".", ".", ".", "2", "7", "5", "9", ".", "."]]
dia.solveSudoku(board)
# print(result)
