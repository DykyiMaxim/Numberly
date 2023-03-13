package com.wm.numberly.domain.model

data class NumbersApiResponse(
    val found: Boolean,
    val number: Int,
    val text: String,
    val type: String
)