package com.wm.numberly.domain.repository

import com.wm.numberly.domain.model.Fact
import com.wm.numberly.utils.Resource

interface NumbersRepository {
    suspend fun getNumber(Number: String): Resource<Fact>
    suspend fun getRandomNumber(): Resource<Fact>


}