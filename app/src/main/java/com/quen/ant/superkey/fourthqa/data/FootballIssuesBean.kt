package com.quen.ant.superkey.fourthqa.data

import androidx.annotation.Keep

@Keep
data class FootballIssuesBean(
    val first: String,
    val second: String,
    val third: String,
    val fourth: String,
    val content: String,
    val result: Int,
)
