package br.edu.mouralacerda.dm1y2022projeto3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.edu.mouralacerda.dm1y2022projeto3.R
import br.edu.mouralacerda.dm1y2022projeto3.model.Produto

class CadastroProduto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_produto)

        findViewById<Button>(R.id.btnSalvar).setOnClickListener {
            val produto = Produto(
                findViewById<EditText>(R.id.edtId).text.toString().toInt(),
                findViewById<EditText>(R.id.edtNome).text.toString(),
                findViewById<EditText>(R.id.edtValor).text.toString().toDouble()
            )

            intent.putExtra("produto", produto)

            setResult(1, intent)

            finish()
        }

    }
}