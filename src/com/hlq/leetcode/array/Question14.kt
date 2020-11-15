package com.hlq.leetcode.array

import java.util.*

/**
 * @author HLQ_Struggle
 * @date 2020/11/09
 * @desc LeetCode 14. 最长公共前缀 https://leetcode-cn.com/problems/longest-common-prefix/
 */
fun main() {
    val strs = arrayOf("flower", "flow", "flight")
    val strs1 = arrayOf("flower", "flower", "flower", "flower")
    val strsNull = arrayOf("dog", "racecar", "car")

    // 暴力解法 1
    println("----> ${longestCommonPrefix(strs)}")
    println("----> ${longestCommonPrefix(strs1)}")
    println("----> ${longestCommonPrefix(strsNull)}")

    // 暴力解法 2 - 3
    println("----> ${longestCommonPrefix2(strs)}")

    // 排序法
    println("----> ${longestCommonPrefix3(strs)}")

    // 获取最后一次相同位置
    println("----> ${longestCommonPrefix4(strs)}")
}

fun longestCommonPrefix4(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }
    if (strs.size == 1) {
        return if(strs[0].isEmpty()) "" else strs[0]
    }
    // 获取输入数组中最短长度
    var min = Int.MAX_VALUE
    for(str in strs){
        if(min > str.length){
            min = str.length
        }
    }
    // 获取最后一次相同的位置
    var isl = true
    var index = 0
    while (index < min){
        for(i in strs.indices){
            if(strs[0][index] != strs[i][index]){
                isl = false
                break
            }
        }
        if(!isl){
            break
        }
        index++
    }
    return strs[0].substring(0,index)
}

/**
 * 排序法
 */
fun longestCommonPrefix3(strs: Array<String>): String {
    var resultStr = ""
    if (strs.isEmpty()) {
        return resultStr
    }
    if (strs.size == 1) {
        return strs[0]
    }
    var len = strs.size
    Arrays.sort(strs)
    for (i in strs[0].indices) {
        if (strs[len - 1][i] == strs[0][i]) {
            resultStr += strs[0][i]
        } else {
            break
        }
    }
    return resultStr
}

/**
 * 暴力解法 2
 */
fun longestCommonPrefix2(strs: Array<String>): String {
    var resultStr = ""
    if (strs.isEmpty()) {
        return resultStr
    }
    if (strs.size == 1) {
        return strs[0]
    }
    resultStr = strs[0]
    for (i in 1 until strs.size) {
        var j = 0
        while (j < resultStr.length && j < strs[i].length) {
            if (strs[i][j] != resultStr[j]) {
                break
            }
            j++
        }
        resultStr = resultStr.substring(0, j)
        if (resultStr.isEmpty()) {
            break
        }
    }
    return resultStr
}

/**
 * 暴力解法 1
 */
fun longestCommonPrefix(strs: Array<String>): String {
    var resultStr = ""
    if (strs.isEmpty()) {
        return resultStr
    }
    if (strs.size == 1) {
        return strs[0]
    }
    resultStr = strs[0]
    for (str in strs) {
        var j = 0
        while (j < resultStr.length && j < str.length) {
            if (str.toCharArray()[j] != resultStr.toCharArray()[j]) {
                break
            }
            j++
        }
        resultStr = resultStr.substring(0, j)
        if (resultStr.isEmpty()) {
            break
        }
    }
    return resultStr
}