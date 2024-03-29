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

class SignActivity : AppCompatActivity() {

    lateinit var etEmail: EditText
    lateinit var name: EditText
    private lateinit var etPass: EditText
    private lateinit var btnSignUp: Button

    // create Firebase authentication object
    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        etEmail=findViewById(R.id.signUpMail)
        name=findViewById(R.id.signUpName)
        etPass=findViewById(R.id.signUpPass)
        btnSignUp=findViewById(R.id.signUpbtn)

        auth = Firebase.auth

        btnSignUp.setOnClickListener {
            signUpUser()
        }

        val txt_acc_exist=findViewById<TextView>(R.id.alreadyacc)


        txt_acc_exist.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signUpUser() {
        val email = etEmail.text.toString()
        val pass = etPass.text.toString()
        val Upname = name.text.toString()

        // check pass
        if (email.isBlank() || pass.isBlank() || Upname.isBlank()) {
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