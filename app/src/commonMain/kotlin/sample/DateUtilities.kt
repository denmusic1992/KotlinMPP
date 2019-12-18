package sample

val dateUtilities: DateUtilities = DateUtilities()

class DateUtilities  {
    val platformDate= PlatformDate()
    val dateFormat = "dd-MM-yyyy HH:mm:ss"
}

expect class PlatformDate() {
    fun getCurrentDate(): String
}
