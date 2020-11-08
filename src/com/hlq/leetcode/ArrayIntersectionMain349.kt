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
    intersection(nums1, nums2)
    // Kotlin intersect
    intersection1(nums1, nums2)
    intersection2(nums1, nums2)
    // 排序 + 双指针
    intersection3(nums1, nums2)
}

/**
 * 排序 + 双指针
 */
fun intersection3(nums1: IntArray, nums2: IntArray): IntArray {
    if (nums1.isEmpty() || nums2.isEmpty()) {
        return IntArray(0)
    }
    var i = 0
    var j = 0
    var index = 0
    var resultSet = hashSetOf<Int>()
    nums1.sort()
    nums2.sort()
    while (i < nums1.size && j < nums2.size) {
        if (nums1[i] == nums2[j]) {
            resultSet.add(nums1[i])
            i++
            j++
        } else if (nums1[i] < nums2[j]) {
            i++
        } else if (nums1[i] > nums2[j]) {
            j++
        }
    }
    var resultArray = IntArray(resultSet.size)
    for (resultNum in resultSet) {
        resultArray[index++] = resultNum
    }
    println(resultArray.asList())
    return resultArray
}

/**
 * Kotlin intersect
 */
fun intersection2(nums1: IntArray, nums2: IntArray): IntArray {
    if (nums1.isEmpty() || nums2.isEmpty()) {
        return IntArray(0)
    }
    return nums1.intersect(nums2.asList()).toIntArray()
}

/**
 * Kotlin intersect
 */
fun intersection1(nums1: IntArray, nums2: IntArray): IntArray {
    if (nums1.isEmpty() || nums2.isEmpty()) {
        return IntArray(0)
    }
    val tempSet = nums1.asList().intersect(nums2.asList())
    var resultArray = IntArray(tempSet.size)
    var index = 0
    for (result in tempSet) {
        resultArray[index++] = result
    }
    println(resultArray.asList())
    return resultArray
}

/**
 * Set + contains
 */
fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    if (nums1.isEmpty() || nums2.isEmpty()) {
        return IntArray(0)
    }
    var tempSet = hashSetOf<Int>()
    var resultSet = hashSetOf<Int>()
    for (num1 in nums1) {
        tempSet.add(num1)
    }
    for (num2 in nums2) {
        if (tempSet.contains(num2)) {
            resultSet.add(num2)
        }
    }
    var resultIntArray = IntArray(resultSet.size)
    var index = 0
    for (resultNum in resultSet) {
        resultIntArray[index++] = resultNum
    }
    println(resultIntArray.asList())
    return resultIntArray
}
