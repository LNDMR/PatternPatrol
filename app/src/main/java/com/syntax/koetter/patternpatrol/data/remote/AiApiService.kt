package com.syntax.koetter.patternpatrol.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// TODO: Understand all of it

// the BASE_URL constant represents the base URL for the API and is used to create the Retrofit instance
// TODO: implement URL
const val BASE_URL = "https://somewebsite.com/api/"

// the Moshi object is used to serialize and deserialize JSON data in the API response
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// the Retrofit object is responsible for creating a service that exposes the methods defined in the ApiService interface
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

// the interface defines a single method that returns a list of AiApiResponse from the API
// TODO: define the API response and method
interface AiApiService {
    // @GET("keyword")
    // suspend fun getResponse(...) : ...
}
