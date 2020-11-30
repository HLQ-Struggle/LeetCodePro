package com.hlq.leetcode.array

/**
 * @author HLQ_Struggle
 * @date 2020/11/30
 * @desc LeetCode 26. 删除排序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */

fun main() {
    val nums = intArrayOf(0,0,1,1,1,2,2,3,3,4)

    println("----> ${removeDuplicates(nums)}")
}

/**
 * 双指针解法
 */
fun removeDuplicates(nums: IntArray): Int {
    if(nums.isEmpty()){
        return 0
    }
    var result = 0
    for(i in nums.indices){
        if(nums[i] != nums[result]){
            nums[++result] = nums[i]
        }
    }
    return ++result
}