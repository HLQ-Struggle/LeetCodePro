package com.hlq.leetcode

/**
 * @author HLQ_Struggle
 * @date 2020/11/08
 * @desc LeetCode 349. 两个数组的交集 https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
fun main(args: Array<String>) {
    val nums1 = IntArray(4)
    nums1[0] = 1
    nums1[1] = 2
    nums1[2] = 2
    nums1[3] = 1

    val nums2 = IntArray(2)
    nums2[0] = 2
    nums2[1] = 2

    // Set + contains
    intersection(nums1,nums2)
    // Kotlin intersect
    intersection1(nums1,nums2)

}

/**
 * Kotlin intersect
 */
fun intersection1(nums1: IntArray, nums2: IntArray): IntArray {
    if(nums1.isEmpty() || nums2.isEmpty()){
        return IntArray(0)
    }
    val tempSet = nums1.asList().intersect(nums2.asList())
    var resultArray = IntArray(tempSet.size)
    var index = 0
    for(result in tempSet){
        resultArray[index++] = result
    }
    return resultArray
}

/**
 * Set + contains
 */
fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    if(nums1.isEmpty() || nums2.isEmpty()){
        return IntArray(0)
    }
    var tempSet = hashSetOf<Int>()
    var resultSet = hashSetOf<Int>()
    for(num1 in nums1){
        tempSet.add(num1)
    }
    for (num2 in nums2){
        if(tempSet.contains(num2)){
            resultSet.add(num2)
        }
    }
    var resultIntArray = IntArray(resultSet.size)
    var index = 0
    for(resultNum in resultSet){
        resultIntArray[index++] = resultNum
    }
    return resultIntArray
}
