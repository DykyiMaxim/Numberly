package com.wm.numberly.data.repositry


import com.wm.numberly.data.mapper.toFact
import com.wm.numberly.data.remote.NumbersApi
import com.wm.numberly.domain.model.Fact
import com.wm.numberly.domain.repository.NumbersRepository
import com.wm.numberly.utils.Resource
import java.io.IOException
import javax.inject.Inject

class NumbersRepositoryImpl @Inject constructor(
    private val api: NumbersApi
) : NumbersRepository {


    override suspend fun getNumber(Number: String): Resource<Fact> {

        return try {
            val response = api.getNumber(Number)
            val result = response.toFact()
            Resource.Success(result)
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Error(
                message = "Couldn't load Number info"
            )
        }

    }

    override suspend fun getRandomNumber(): Resource<Fact> {
        return try {
            val response = api.getRandomNumber()
            val result = response.toFact()
            Resource.Success(result)
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Error(
                message = "Couldn't load Number info"
            )
        }
    }
}






