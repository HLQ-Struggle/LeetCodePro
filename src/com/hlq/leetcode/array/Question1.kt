package com.hlq.leetcode.array

/**
 * @author HLQ_Struggle
 * @date 2020/11/09
 * @desc LeetCode 1. 两数之和 https://leetcode-cn.com/problems/two-sum/
 */
fun main() {
    val nums = IntArray(3)
    nums[0] = 3
    nums[1] = 2
    nums[2] = 4
//    nums[3] = 15

    val target = 6

    // 暴力解法 一
    twoSum(nums, target)
}

/**
 * 双指针解法
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    // 基本校验
    if (nums.isEmpty()) {
        return IntArray(0)
    }
    var resultArray = IntArray(2)
    var isl = false
    var i = 0
    var j = 1
    while (i < nums.size - 1) {
        while (j < nums.size) {
            if (nums[i] + nums[j] == target) {
                resultArray[0] = i
                resultArray[1] = j
                isl = true
                break
            }
            j++
        }
        if (isl) {
            break
        }
        i++
        j = i + 1
    }
    return resultArray
}