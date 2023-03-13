package com.wm.numberly.presentation.GetFactScreen

import com.wm.numberly.domain.model.Fact

data class GetFactState(
    var fact: Fact = Fact("", "", true),
    val isLoading: Boolean = true,
    val error: String = ""
)

