package com.example.aulamercadolivre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()

        val autenticacao = Firebase.auth
        val usuarioAtual = autenticacao.currentUser

        if (usuarioAtual != null){
            finish()
            startActivity(
                Intent(
                    this,
                    PrincipalActivity::class.java
                )
            )
        }
    }

    fun entrar(view: View){
        startActivity(
            Intent(
                this,
                CadastroActivity::class.java
            )
        )
    }

    fun logar(view: View){
        startActivity(
            Intent(
                this,
                LoginActivity::class.java
            )
        )
    }
}