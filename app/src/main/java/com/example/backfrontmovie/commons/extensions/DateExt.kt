package com.example.backfrontmovie.commons.extensions

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String.formatToLatamDate(): String? {
  val strDate = this.stringToDate()

  return strDate?.dateToString()
}

fun String.stringToDate(): Date? {
  val sdf = SimpleDateFormat("yyyy-MM-dd", Locale("pt", "BR"))

  return sdf.parse(this)
}

fun Date.dateToString(): String? {
  val sdf = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR"))

  return sdf.format(this)
}