package br.edu.mouralacerda.dm1y2022projeto3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import br.edu.mouralacerda.dm1y2022projeto3.R
import br.edu.mouralacerda.dm1y2022projeto3.model.Produto
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    val listaDeProdutos = ArrayList<Produto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoAdicionar = findViewById<FloatingActionButton>(R.id.btnNovoProduto)
        botaoAdicionar.setOnClickListener {

            val intencao = Intent(this, CadastroProduto::class.java)
            startActivityForResult(intencao, 1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == 1) {
            if(data != null) {
                val p = data.getSerializableExtra("produto") as Produto
                listaDeProdutos.add(p)
                atualizarLista()
            }
        }
    }

    private fun atualizarLista() {
        val adp = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listaDeProdutos
        )

        findViewById<ListView>(R.id.lstProdutos).adapter = adp
    }

}