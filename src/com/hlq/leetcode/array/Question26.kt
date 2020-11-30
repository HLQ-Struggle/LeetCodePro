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
    var resultCount = 0
    for(i in nums.indices){
        if(nums[i] != nums[resultCount]){
            nums[++resultCount] = nums[i]
        }
    }
    return ++resultCount
}

/**
 * LeetCode 执行用时范例
 */
fun removeDuplicates1(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var i = 0
    for (j in 1 until nums.size) {
        if (nums[j] != nums[i]) {
            i++
            nums[i] = nums[j]
        }
    }
    return i + 1
}

/**
 * LeetCode 执行消耗内存范例
 */
fun removeDuplicates2(nums: IntArray): Int {
    if(nums == null){
        return 0
    }
    if(nums.size == 1){
        return 1
    }
    var i = 0
    for(j in 1 until nums.size){
        if(nums[i] != nums[j]){
            i++
            nums[i] = nums[j]
        }
    }
    return i+1
}
