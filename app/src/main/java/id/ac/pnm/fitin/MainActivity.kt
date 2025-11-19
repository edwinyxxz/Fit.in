package id.ac.pnm.fitin

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textViewUsername = findViewById<TextView>(R.id.textViewUsername)
        val Usr: String = intent.getStringExtra("userEmail").toString()?:""
        textViewUsername.text = "Hey there, $Usr"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCatalog)
        fun getCatalog(): List<Catalog> {
            val data = mutableListOf<Catalog>()
            data.add(Catalog(
                R.drawable.celana,
                "Cattwin Reworked pants",
                "Rp. 250.000",
                Category.Celana
            ))
            data.add(Catalog(
                R.drawable.knit,
                "Totoro day's",
                "Rp. 200.000",
                Category.Knit
            ))
            data.add(Catalog(
                R.drawable.jaket,
                "Memorable autumn in collage",
                "Rp. 250.000",
                Category.Jaket
            ))
            data.add(Catalog(
                R.drawable.kemeja,
                "Fragmenta caeli",
                "200.000",
                Category.Kemeja
            ))
            data.add(Catalog(
                R.drawable.dasi,
                "Dasi Mix Collection",
                "Rp. 50.000",
                Category.Dasi
            ))
            data.add(Catalog(
                R.drawable.cardigan,
                "Doctorium cardigan",
                "Rp. 150.000",
                Category.Cardigan
            ))
            return data
        }
        recyclerView.adapter = CatalogAdapter(getCatalog(), ::openDetailProduct)
    }
    fun openDetailProduct (catalog: Catalog){
        val intentMainToDetail = Intent(this, DetailProductActivity::class.java)
        intentMainToDetail.putExtra("judul", catalog.Name)
        intentMainToDetail.putExtra("img", catalog.Image)
        intentMainToDetail.putExtra("harga", catalog.Price)
        intentMainToDetail.putExtra("kategori", catalog.Category.name)
        startActivity(intentMainToDetail)
    }
}