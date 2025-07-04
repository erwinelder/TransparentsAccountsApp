package com.transparentaccountsapp.account.data.remote.source

import android.util.Log
import com.transparentaccountsapp.BuildConfig
import com.transparentaccountsapp.account.data.remote.model.AccountDto
import com.transparentaccountsapp.account.data.remote.model.AccountsResponseDto
import com.transparentaccountsapp.core.data.remote.httpClient
import com.transparentaccountsapp.core.data.remote.json
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType

class AccountRemoteSourceImpl : AccountRemoteSource {

    val apiUrl = BuildConfig.API_URL
    val apiKey = BuildConfig.API_KEY

    override suspend fun getAllAccounts(): List<AccountDto> {
        return try {
            val response = httpClient.get(
                urlString = "$apiUrl/"
            ) {
                header("WEB-API-key", apiKey)
                contentType(ContentType.Application.Json)
            }

            if (response.status == HttpStatusCode.OK) {
                json.decodeFromString<AccountsResponseDto>(string = response.bodyAsText()).accounts
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            Log.e("AccountRemoteSourceImpl", "Error fetching accounts: ${e.message}")
            emptyList()
        }
    }

}