package com.wm.numberly.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fact(
    var text: String = "NThing",
    var number: String = "25",
    val found: Boolean = true
) : Parcelable
