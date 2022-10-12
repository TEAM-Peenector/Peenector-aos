package com.example.peenector.util

import java.util.regex.Pattern

class AutoChecking {
    val pwPattern = "^[a-zA-Z]*\$"
    val namePattern = "^[가-힣]*\$"

    val patternPw = Pattern.compile(pwPattern) // 패턴 컴파일
    val patternName = Pattern.compile(namePattern)

    fun isSignUpClassOfValid(classOf: String) { //성립조건
        classOf.length == 9
    }

    fun isSignUoNameValid(name: String) {
        patternName.matcher(name)
    }

    fun isSignUpPassword(password: String) {
        password.length >= 8
        patternPw.matcher(password)
    }

}