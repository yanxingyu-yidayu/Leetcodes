#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@author: yanxingyu
@email: 2512466437@qq.com
@time: 2022/8/22 10:34
"""
from typing import List


def recursion(candidates: List[int], target: int):
    results: List[List[int]] = []
    if target == 0:
        results.append([0])
        return results
    if len(candidates) == 0:
        li = []
        results.append(li)
        return results
    if candidates[0] > target:
        results.append([])
        return results
    Sum = 0
    for element in candidates:
        Sum += element
    if Sum < target:
        return results
    i = len(candidates) - 1
    while i >= 0:
        if i < len(candidates) - 1 and candidates[i] == candidates[i + 1]:
            i -= 1
            continue
        tmpTarget = target - candidates[i]
        if tmpTarget < 0:
            i -= 1
            continue
        tmpCandidates = candidates[:i]
        tmpResults = recursion(tmpCandidates, tmpTarget)
        for j in tmpResults:
            if 0 in j:
                j.append(candidates[i])
                results.append(j)
        i -= 1
    return results


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates = sorted(candidates)
        results: List[List[int]] = []
        maxIndex: int = len(candidates) - 1
        if candidates[0] > target:
            # results.append([])
            return results
        Sum = 0
        for element in candidates:
            Sum += element
        if Sum < target:
            return results
        while maxIndex >= 0:
            if candidates[maxIndex] <= target:
                break
            maxIndex = maxIndex - 1
        # 每个列表最大值位candidates[i]，
        while maxIndex >= 0:
            if maxIndex < len(candidates) - 1 and candidates[maxIndex] == candidates[maxIndex + 1]:
                maxIndex -= 1
                continue
            i = maxIndex
            #target = target - candidates[i]
            # if target < candidates[0]:
            #     maxIndex = maxIndex - 1
            #     continue
            tmpCandidates = candidates[:i]
            tmpresults = recursion(tmpCandidates, target - candidates[i])
            for j in tmpresults:
                if 0 in j:
                    j.append(candidates[i])
                    if j not in results:
                        results.append(j)
            maxIndex = maxIndex - 1
        for j in results:
            if j == [] or 0 not in j:
                results.remove(j)
            j.remove(0)
        return results


dia = Solution()
s = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]

# s = [2,2]
target = 8
target = 27
result = dia.combinationSum2(s, target)
print(result)


