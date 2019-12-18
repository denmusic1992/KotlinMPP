package sample.interfaces

import io.ktor.client.HttpClient
import io.ktor.client.features.DefaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.url

class RequestApi {

    companion object {
        const val baseURL = "https://support.citykrepost.ru/api_mobile2/"

        const val testUrl = "http://www.recipepuppy.com/api/?i=onions,garlic&q=omelet"

        const val searchUrl = "http://www.recipepuppy.com/"

    }

    private val client = HttpClient {
        install(DefaultRequest) {
            //contentType(ContentType.Application.Json)
            //headers.append("Content-Type", "application/json")
            headers.append("Accept", "application/json")
        }
    }


    suspend fun getTestRequest(): String {
        return client.get {
            url(testUrl)
        }
    }

    suspend fun searchRequest(search: String): String {
        return client.get {
            url("$searchUrl$search")
        }
    }

    suspend fun getContacts(): String {
        return client.get {
            url("${baseURL}companies/info")
        }
    }
}