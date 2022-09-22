package br.edu.mouralacerda.dm1y2022projeto3.model

import java.io.Serializable

data class Produto (
    val id: Int,
    val nome: String,
    val valor: Double
) : Serializable
{
    override fun toString(): String {
        return "${this.id} / ${this.nome} / ${this.valor}"
    }
}