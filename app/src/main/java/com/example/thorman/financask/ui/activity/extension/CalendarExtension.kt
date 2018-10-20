package com.example.thorman.financask.ui.activity.extension

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.formataParaBrasileiro() : String
{
    val formatoDataBrasileiro = "dd/MM/yyyy"
    var format = SimpleDateFormat(formatoDataBrasileiro)
    return format.format(this.time)
}
