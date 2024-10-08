package com.example.little_lemon.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class Network(private val httpClient: HttpClient) {
    companion object {
        const val URL =
            "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"
    }

    suspend fun fetchMenuItem(): MenuDTO {
        return httpClient.get(URL).body()
    }
}

