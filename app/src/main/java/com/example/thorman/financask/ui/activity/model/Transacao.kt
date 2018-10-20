package com.example.thorman.financask.ui.activity.model

import java.math.BigDecimal
import java.util.Calendar

class Transacao(val valor: BigDecimal,
                val categoria: String = "Indefinida",
                val tipo: Tipo,
                val data: Calendar = Calendar.getInstance())