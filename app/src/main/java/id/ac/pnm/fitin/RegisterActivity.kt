package id.ac.pnm.fitin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val email = findViewById<EditText>(R.id.editTextTextEmailAddressRegis)
        val alamat = findViewById<EditText>(R.id.editTextAlamat)
        val noHP = findViewById<EditText>(R.id.editTextPhone)
        val password = findViewById<EditText>(R.id.editTextTextPasswordRegis)
        val btnRegister = findViewById<Button>(R.id.buttonRegister)

        btnRegister.setOnClickListener {
            val email: String = email.text.toString()
            val password: String = password.text.toString()
            val intentToLogin = Intent(this, LoginActivity::class.java)
            intentToLogin.putExtra("emailRegis", email)
            intentToLogin.putExtra("passwordRegis", password)
            startActivity(intentToLogin)
        }
    }
}