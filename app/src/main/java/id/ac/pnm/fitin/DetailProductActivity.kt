package id.ac.pnm.fitin

import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_product)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageDetailProduct = findViewById<ImageView>(R.id.image_Detailproduct)
        val textViewDetailJudul = findViewById<TextView>(R.id.textViewDetailName)
        val textViewDetailHarga = findViewById<TextView>(R.id.textViewDetailPrice)
        val textViewDetailkategori = findViewById<TextView>(R.id.textViewDetailCategory)
        val btnBeli = findViewById<Button>(R.id.buttonBeli)

        val img: Int = intent.getIntExtra("img", 0)
        imageDetailProduct.setImageResource(img)
        val judul: String = intent.getStringExtra("judul").toString()?:""
        textViewDetailJudul.text = "$judul"
        val harga: String = intent.getStringExtra("harga").toString()?:""
        textViewDetailHarga.text = "$harga"
        val kategori: String = intent.getStringExtra("kategori").toString()?:""
        textViewDetailkategori.text = "$kategori"

        btnBeli.setOnClickListener {
            val intentChat = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://wa.me/6282334500709?text=Halo,%20saya%20beli%20product${judul}"))
            startActivity(intentChat)
        }
    }
}