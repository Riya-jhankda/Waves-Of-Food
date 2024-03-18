package com.example.wavesoffood

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {

    lateinit var etEmail: EditText
    private lateinit var etPass: EditText
    private lateinit var btnLogin: Button

    // create Firebase authentication object
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        etEmail=findViewById(R.id.maile)
        etPass=findViewById(R.id.passe)
        btnLogin=findViewById(R.id.logine)

        auth = Firebase.auth

        val gso=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken( getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient=GoogleSignIn.getClient(this,gso)

        val gso_btn= findViewById<Button>(R.id.g_btn)

        gso_btn.setOnClickListener {
            SignInGoogle()
        }

        btnLogin.setOnClickListener {
            loginUser()
        }



        val txt_noacc=findViewById<TextView>(R.id.donthave_acc)

        txt_noacc.setOnClickListener{
            val intent = Intent(this,SignActivity::class.java)
            startActivity(intent)

        }

    }

    private fun SignInGoogle() {
        val signInIntent=googleSignInClient.signInIntent

        launcher.launch(signInIntent)
    }
    private val launcher= registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result->
            if(result.resultCode==Activity.RESULT_OK){
                val task=GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleResults(task)
            }
    }

    private fun handleResults(task: Task<GoogleSignInAccount>) {
        if(task.isSuccessful){
            val account:GoogleSignInAccount?=task.result
            if(account!=null){
                updatedUI(account)
            }
        }
        else{
            Toast.makeText(this,task.exception.toString(),Toast.LENGTH_SHORT).show()
        }

    }

    private fun updatedUI(account: GoogleSignInAccount) {
        val credential=GoogleAuthProvider.getCredential(account.idToken,null)
        auth.signInWithCredential(credential).addOnCompleteListener{
            if(it.isSuccessful){
                val intent:Intent=Intent(this,MainActivity::class.java)
                startActivity(intent)

            }
            else{
                Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
            }
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