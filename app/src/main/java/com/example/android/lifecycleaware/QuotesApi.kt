package com.example.android.lifecycleaware

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {

    @GET("/quotes")//api endpoint here
    //in query add query page number
    suspend fun getQuotes(@Query("page")pageNo:Int):Response<QuoteList>
}