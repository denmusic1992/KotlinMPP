package sample



actual class PlatformDate {
    private lateinit var dateProtocol: DateProtocol

    fun setImplementation(protocol: DateProtocol) {
        dateProtocol = protocol
    }

    actual fun getCurrentDate(): String {
        return dateProtocol.getIosDate()
    }
}