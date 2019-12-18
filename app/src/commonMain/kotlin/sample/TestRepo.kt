package sample

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import sample.interfaces.RequestApi
import sample.models.Contacts
import sample.models.RecipesEntity
import kotlin.jvm.Synchronized

class TestRepo(private val api: RequestApi) {

    companion object {
        @Synchronized
        fun getRepo(): TestRepo = TestRepo(RequestApi())
    }

    suspend fun getRecipe(): String {
        return api.getTestRequest()
    }

    suspend fun searchRecipe(search: String): RecipesEntity =
        Json(JsonConfiguration.Stable).parse(RecipesEntity.serializer(), api.searchRequest(search))

    suspend fun getContacts(): Contacts =
        Json(JsonConfiguration.Stable).let {
            it.parse(Contacts.serializer(), api.getContacts())
        }
}