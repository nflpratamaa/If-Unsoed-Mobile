package com.example.prak_pertemuan_1.data.network

import com.example.prak_pertemuan_1.data.mobile.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response

interface OpenLibraryApi {

    @GET(value = "search.json")
    suspend fun searchBooks(
        @Query(value = "q") query: String,
        @Query(value = "limit") limit: Int

    ): Response<SearchResponse>
}