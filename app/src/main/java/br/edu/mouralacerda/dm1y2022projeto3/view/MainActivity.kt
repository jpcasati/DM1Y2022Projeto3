package br.edu.mouralacerda.dm1y2022projeto3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import br.edu.mouralacerda.dm1y2022projeto3.R
import br.edu.mouralacerda.dm1y2022projeto3.databinding.ActivityMainBinding
import br.edu.mouralacerda.dm1y2022projeto3.model.Produto
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val b by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val listaDeProdutos = ArrayList<Produto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        b.btnNovoProduto.setOnClickListener {

            val intencao = Intent(this, CadastroProduto::class.java)
            startActivityForResult(intencao, 1)
        }

        b.btnNovoProduto.setOnLongClickListener {
            Toast.makeText(
                this,
                "Clique rápido para adicionar",
                Toast.LENGTH_SHORT
            ).show()
            true
        }

        b.lstProdutos.setOnItemLongClickListener { adapterView, view, i, l ->

            val builder = AlertDialog.Builder(this)
            builder
                .setTitle("Apagar Produto")
                .setMessage("Deseja realmente apagar o produto selecionado?")
                .setPositiveButton("Sim") { dialog, which ->
                    listaDeProdutos.removeAt(i)
                    atualizarLista()
                    Toast.makeText(this, "Produto removido com sucesso!",
                        Toast.LENGTH_LONG).show()
                }
                .setNegativeButton("Não") { dialog, which ->
                    Toast.makeText(this, "Produto não removido!",
                        Toast.LENGTH_LONG).show()
                }
                .show()
            true
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

        b.lstProdutos.adapter = adp
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_principal, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(listaDeProdutos.size > 1) {
            if (item.itemId == R.id.menuOrdenarId) {
                Toast.makeText(
                    this, "Ordenando a lista por ID",
                    Toast.LENGTH_LONG
                ).show()
                // Ordeno a lista por ID aqui
            } else if (item.itemId == R.id.menuOrdenarValor) {
                Toast.makeText(
                    this, "Ordenando a lista por Valor",
                    Toast.LENGTH_LONG
                ).show()
                // Ordeno a lista por Valor aqui
            }
        } else {
            Toast.makeText(this, "Não é necessário ordenar a lista",
                Toast.LENGTH_LONG).show()
        }

        if(item.itemId == R.id.menuFechar) {
            // Alert dialog para fechar App
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Utilize o menu para sair",
            Toast.LENGTH_LONG).show()
    }

}