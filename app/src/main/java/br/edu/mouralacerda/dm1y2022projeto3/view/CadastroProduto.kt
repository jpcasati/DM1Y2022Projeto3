package br.edu.mouralacerda.dm1y2022projeto3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.edu.mouralacerda.dm1y2022projeto3.R
import br.edu.mouralacerda.dm1y2022projeto3.databinding.ActivityCadastroProdutoBinding
import br.edu.mouralacerda.dm1y2022projeto3.databinding.ActivityMainBinding
import br.edu.mouralacerda.dm1y2022projeto3.model.Produto

class CadastroProduto : AppCompatActivity() {

    private val b by lazy {
        ActivityCadastroProdutoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        b.btnSalvar.setOnClickListener {
            val produto = Produto(
                b.edtId.text.toString().toInt(),
                b.edtNome.text.toString(),
                b.edtValor.text.toString().toDouble()
            )

            intent.putExtra("produto", produto)

            setResult(1, intent)

            finish()
        }

    }
}