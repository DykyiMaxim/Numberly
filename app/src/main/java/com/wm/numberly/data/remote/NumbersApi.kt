package com.wm.numberly.data.remote

import com.wm.numberly.domain.model.NumbersApiResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface NumbersApi {
    @GET("/{UserNumber}")
    @Headers("Content-Type:application/json")
    suspend fun getNumber(
        @Path("UserNumber") Number: String
    ): NumbersApiResponse

    @GET("/random")
    @Headers("Content-Type:application/json")
    suspend fun getRandomNumber(): NumbersApiResponse

    companion object {
        var BASE_URL = "http://numbersapi.com/"
    }
}