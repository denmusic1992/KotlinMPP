package sample.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipesEntity(
    @SerialName("href") val href: String,
    @SerialName("title") val title: String,
    @SerialName("version") val version: Double,
    @SerialName("results") val results: List<Result>
) {
    @Serializable
    data class Result(
        @SerialName("href") val href: String,
        @SerialName("ingredients") val ingredients: String,
        @SerialName("thumbnail") val thumbnail: String,
        @SerialName("title") val title: String
    )
}