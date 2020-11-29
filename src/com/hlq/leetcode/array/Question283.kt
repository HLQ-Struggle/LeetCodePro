package com.hlq.leetcode.array

/**
 * @author HLQ_Struggle
 * @date 2020/11/29
 * @desc LeetCode 283. 移动零 https://leetcode-cn.com/problems/move-zeroes/
 */

fun main() {
    val nums = intArrayOf(0, 1, 0, 3, 12)

    // 暴力解法 双指针
//    moveZeroes(nums)

    // 偷梁换柱法
    moveZeroes1(nums)

    // LeetCode 执行用时为 204 ms 的范例
//    moveZeroes2(nums)

    // LeetCode 执行消耗内存为 35048 kb 的范例
//    moveZeroes3(nums)
}

/**
 * 暴力解法
 */
fun moveZeroes(nums: IntArray): Unit {
    if (nums.isEmpty()) {
        return
    }
    for (i in nums.indices) {
        if (nums[i] == 0) {
            for (j in i until nums.size) {
                if (nums[j] != 0) {
                    var tempNum = nums[i]
                    nums[i] = nums[j]
                    nums[j] = tempNum
                    break
                }
            }
        }
    }
}

/**
 * 暴力解法
 */
fun moveZeroes1(nums: IntArray): Unit {
    if (nums.isEmpty()) {
        return
    }
    var j = 0
    for (i in nums.indices) {
        if (nums[i] != 0) {
            nums[j++] = nums[i]
        }
    }
    while (j < nums.size) {
        nums[j++] = 0
    }
}

/**
 * 执行用时为 204 ms 的范例
 */
fun moveZeroes2(nums: IntArray): Unit {
    var pointA = 0
    var pointB = 0
    while (pointB < nums.size) {
        val numB = nums[pointB]
        if (numB != 0) {
            nums[pointB] = nums[pointA]
            nums[pointA] = numB
            pointA++
        }
        pointB++
    }
}

/**
 * 执行消耗内存为 35048 kb 的范例
 */
fun moveZeroes3(nums: IntArray): Unit {
    var a = 0
    var b = 0
    while (b < nums.size) {
        if (nums[b] != 0) {
            nums[a] = nums[b]
            if (b > a) {
                nums[b] = 0
            }
            a++
        }
        b++
    }
}