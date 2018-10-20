package com.example.thorman.financask.ui.activity.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

fun BigDecimal.formataParaBrasileiro() : String {
    val formatoBrasileiro = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))
    return formatoBrasileiro.format(this)
            .replace("R$", "R$ ")
            .replace("-R$ ", "R$ -")
}