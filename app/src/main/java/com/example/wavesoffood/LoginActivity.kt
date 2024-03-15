package com.example.wavesoffood

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {

    lateinit var etEmail: EditText
    private lateinit var etPass: EditText
    private lateinit var btnLogin: Button

    // create Firebase authentication object
    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        etEmail=findViewById(R.id.maile)
        etPass=findViewById(R.id.passe)
        btnLogin=findViewById(R.id.logine)

        auth = Firebase.auth

        btnLogin.setOnClickListener {
            loginUser()
        }



        val txt_noacc=findViewById<TextView>(R.id.donthave_acc)

        txt_noacc.setOnClickListener{
            val intent = Intent(this,SignActivity::class.java)
            startActivity(intent)

        }

    }

    private fun loginUser() {
        val email = etEmail.text.toString()
        val pass = etPass.text.toString()


        // check pass
        if (email.isBlank() || pass.isBlank() ) {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}