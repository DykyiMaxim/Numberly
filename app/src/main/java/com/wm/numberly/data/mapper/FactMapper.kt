package com.wm.numberly.data.mapper

import com.wm.numberly.domain.model.Fact
import com.wm.numberly.domain.model.NumbersApiResponse

fun NumbersApiResponse.toFact(): Fact {
    return Fact(
        text = text,
        number = number.toString(),
        found = found
    )
}
