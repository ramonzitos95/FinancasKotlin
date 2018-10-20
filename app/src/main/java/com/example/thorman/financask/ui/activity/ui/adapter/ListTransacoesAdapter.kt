package com.example.thorman.financask.ui.activity.ui.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.thorman.financask.R
import com.example.thorman.financask.ui.activity.extension.formataParaBrasileiro
import com.example.thorman.financask.ui.activity.extension.limitaEmAte
import com.example.thorman.financask.ui.activity.model.Tipo
import com.example.thorman.financask.ui.activity.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListTransacoesAdapter(private val transacoes: List<Transacao>,
                            private val context: Context) : BaseAdapter() {

    private val limiteDaCategoria = 14

    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[posicao]

        adicionaValor(viewCriada, transacao)
        adicionaIcone(viewCriada, transacao)
        adicionaCategoria(viewCriada, transacao)
        formataDataBrasileiro(viewCriada, transacao)

        return viewCriada
    }

    fun adicionaValor(viewCriada: View, transacao: Transacao) {

        val cor: Int = corPor(transacao.tipo)

        viewCriada.transacao_valor.setTextColor(cor)
        viewCriada.transacao_valor.text = transacao.valor.formataParaBrasileiro()
    }

    fun adicionaIcone(viewCriada: View, transacao: Transacao) {

        val icone = iconePor(transacao.tipo)
        viewCriada.transacao_icone.setBackgroundResource(icone)
    }

    fun adicionaCategoria(viewCriada: View, transacao: Transacao) {

        viewCriada.transacao_categoria.text = transacao.categoria.limitaEmAte(limiteDaCategoria)
    }

    fun formataDataBrasileiro(viewCriada: View, transacao: Transacao) {

        viewCriada.transacao_data.text = transacao.data.formataParaBrasileiro()
    }

    private fun corPor(tipo: Tipo) : Int
    {
        return  if(tipo == Tipo.RECEITA) {
            ContextCompat.getColor(context, R.color.receita)
        }
        else {
            ContextCompat.getColor(context, R.color.despesa)
        }
    }

    private fun iconePor(tipo: Tipo) : Int
    {
        return if(tipo == Tipo.RECEITA)
        {
            R.drawable.icone_transacao_item_receita
        }
        else
        {
            R.drawable.icone_transacao_item_despesa
        }
    }

    override fun getItem(posicao: Int): Transacao {
        return transacoes[posicao]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return transacoes.size
    }


}