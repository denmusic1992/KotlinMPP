package sample

import java.text.SimpleDateFormat
import java.util.*

actual class PlatformDate {
    actual fun getCurrentDate(): String {
        val date = Calendar.getInstance().time
        val sdf =
            SimpleDateFormat(dateUtilities.dateFormat)
        return sdf.format(date)
    }
}