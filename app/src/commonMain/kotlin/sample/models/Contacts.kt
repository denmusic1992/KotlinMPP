package sample.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Contacts(
    @SerialName("address")
    val address: Address,
    @SerialName("about")
    val about: String
) {
    @Serializable
    data class Address(
        @SerialName("dezhurka")
        val dezhurka: String,
        @SerialName("reception")
        val reception: String
    )

    override fun toString(): String {
        return " Адрес: $about, телефон дежурной части: ${address.dezhurka}, телефон ресепшена: ${address.reception}"
    }
}