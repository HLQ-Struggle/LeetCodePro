package com.hlq.leetcode.array

import kotlin.test.currentStackTrace

/**
 * @author HLQ_Struggle
 * @date 2020/11/09
 * @desc LeetCode 14. 最长公共前缀 https://leetcode-cn.com/problems/longest-common-prefix/
 */
fun main() {
    val strs = arrayOf("flower", "flow", "flight")
    val strs1 = arrayOf("flower", "flower", "flower", "flower")
    val strsNull = arrayOf("dog", "racecar", "car")

    println("----> ${longestCommonPrefix(strs)}")
    println("----> ${longestCommonPrefix(strs1)}")
    println("----> ${longestCommonPrefix(strsNull)}")
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
    for(str in strs){
        var j = 0
        while (j < resultStr.length && j < str.length){
            if(str.toCharArray()[j] != resultStr.toCharArray()[j]){
                break
            }
            j++
        }
        resultStr = resultStr.substring(0,j)
        if(resultStr.isEmpty()){
            break
        }
    }
    return resultStr
}