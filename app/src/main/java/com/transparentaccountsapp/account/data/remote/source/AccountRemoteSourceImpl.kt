package com.transparentaccountsapp.account.data.remote.source

import android.util.Log
import com.transparentaccountsapp.BuildConfig
import com.transparentaccountsapp.account.data.remote.model.AccountDetailsDto
import com.transparentaccountsapp.account.data.remote.model.AccountDto
import com.transparentaccountsapp.account.data.remote.model.AccountsResponseDto
import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.core.data.remote.httpClient
import com.transparentaccountsapp.core.data.remote.json
import com.transparentaccountsapp.requestHandling.domain.model.ResultData
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType

class AccountRemoteSourceImpl : AccountRemoteSource {

    val apiUrl = BuildConfig.API_URL
    val apiKey = BuildConfig.API_KEY

    override suspend fun getAllAccounts(): ResultData<List<AccountDto>, AccountError> {
        return try {
            val response = httpClient.get(
                urlString = "$apiUrl/"
            ) {
                header("WEB-API-key", apiKey)
                contentType(ContentType.Application.Json)
            }

            when (response.status) {
                HttpStatusCode.OK -> {
                    val response = json.decodeFromString<AccountsResponseDto>(
                        string = response.bodyAsText()
                    )
                    ResultData.Success(data = response.accounts)
                }
                else -> {
                    ResultData.Error(error = AccountError.AccountsFetchError)
                }
            }
        } catch (e: Exception) {
            Log.e("AccountRemoteSourceImpl", "Error fetching accounts: ${e.message}")
            ResultData.Error(error = AccountError.AccountsFetchError)
        }
    }

    override suspend fun getAccountDetails(
        accountNumber: String
    ): ResultData<AccountDetailsDto, AccountError> {
        return try {
            val response = httpClient.get(
                urlString = "$apiUrl/$accountNumber"
            ) {
                header("WEB-API-key", apiKey)
                contentType(ContentType.Application.Json)
            }

            when (response.status) {
                HttpStatusCode.OK -> {
                    val response = json.decodeFromString<AccountDetailsDto>(
                        string = response.bodyAsText()
                    )
                    ResultData.Success(data = response)
                }
                HttpStatusCode.NotFound -> {
                    ResultData.Error(error = AccountError.AccountNotFoundError)
                }
                else -> {
                    ResultData.Error(error = AccountError.AccountFetchError)
                }
            }
        } catch (e: Exception) {
            Log.e("AccountRemoteSourceImpl", "Error fetching account details: ${e.message}")
            ResultData.Error(error = AccountError.AccountFetchError)
        }
    }

}