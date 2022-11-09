package com.example.utiltiesclassapp.utils

import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtils {

    /*
    DATE & TIME
    YYYY = four-digit year
    MM   = two-digit month (01=January, etc.)
    DD   = two-digit day of month (01 through 31)
    hh   = two digits of hour (00 through 23) (am/pm NOT allowed)
    mm   = two digits of minute (00 through 59)
    ss   = two digits of second (00 through 59)
    s    = one or more digits representing a decimal fraction of a second
    TZD  = time zone designator (Z or +hh:mm or -hh:mm)
    */

    private const val dateTime = "2022-11-08T14:02:00.109Z"
    private const val DF_DATETIME = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    private const val DF_24HOUR = "HH:mm"
    private const val DF_12HOUR = "h:mm a"

    private val TIME_ZONE = TimeZone.getTimeZone("UTC")


    fun convertDateToTimeZone(date: String): Date? {
        val dateFormat = SimpleDateFormat(DF_DATETIME, Locale.ENGLISH)
        dateFormat.timeZone = TIME_ZONE
        return try {
            val dateString =  dateFormat.format(date)
            dateFormat.parse(dateString)
        }catch (e : Exception){
            e.printStackTrace()
            null
        }
    }

}