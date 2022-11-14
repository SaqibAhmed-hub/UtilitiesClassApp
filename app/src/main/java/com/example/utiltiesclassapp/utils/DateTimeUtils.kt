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

    private const val dateTime = "2021-05-20T14:02:00.109Z"
    private const val DF_DATETIME = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    private const val DF_24HOUR = "HH:mm"  //11:28
    private const val DF_12HOUR = "h:mm a" //11:28 am
    private const val DF_DEFAULT_FORMAT_WITHOUT_TIME = "yyyy-MM-dd" // 2021-05-20
    private const val DF_DATE_TIME_YY_MM_FORMAT = "yyyy-MM-dd'T'HH:mm" // 2021-05-20T11:28
    private const val DF_DATE_TIME_YY_MM_FULL_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss" // 2021-05-20T11:28
    private const val DF_DATE_MM_DD_YY_FORMAT = "MM-dd-yyyy" // 05-20-2021
    private const val DF_DATE_MM_DD_FORMAT = "MMM dd, yyyy" // May 20, 2021
    private const val DF_DATE_MONTH_OF_YEAR_FORMAT = "d MMMM, yyyy" // 20 May, 2021
    private const val DF_DAY_OF_WEEK_MONTH_FORMAT = "EEE, d MMM" // Thu, 20 May





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