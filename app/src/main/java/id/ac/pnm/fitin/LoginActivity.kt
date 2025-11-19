package id.ac.pnm.fitin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editTextEmail: EditText = findViewById<EditText>(R.id.editTextEmailAddress)
        val editTextPassword: EditText = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        val register = findViewById<TextView>(R.id.textViewRegister)
        val akun: String = intent.getStringExtra("emailRegis").toString()
        val pw: String = intent.getStringExtra("passwordRegis").toString()

        buttonLogin.setOnClickListener {
            val email: String = editTextEmail.text.toString()
            val password: String = editTextPassword.text.toString()

            if(email == akun && password == pw){
                val intentLogin2Main = Intent(this, MainActivity::class.java)
                intentLogin2Main.putExtra("emailAddress", email)
                intentLogin2Main.putExtra("password", password)
                startActivity(intentLogin2Main)
            } else {
                Toast.makeText(this, "Email atau password salah, silahkan coba lagi", Toast.LENGTH_LONG).show()
            }

        }
        register.setOnClickListener {
            val intentToRegister = Intent(this, RegisterActivity::class.java)
            startActivity(intentToRegister)
        }

    }
}