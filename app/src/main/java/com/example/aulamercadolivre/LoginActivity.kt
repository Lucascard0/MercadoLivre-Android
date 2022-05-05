package com.example.aulamercadolivre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    lateinit var editEmail: EditText;
    lateinit var editSenha: EditText;
    lateinit var autenticacao: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        inicializaComponentesInterface()
    }

    fun entrar(view: View){

        val email = editEmail.text.toString()
        val senha = editSenha.text.toString()

        if (validarCampos()){

            //Login usuario
            autenticacao.signInWithEmailAndPassword(
                email, senha
            ).addOnCompleteListener{
                if(it.isSuccessful){

                    Toast.makeText(this, "Sucesso ao fazer login de usuário", Toast.LENGTH_SHORT).show()
                    finish()
                    startActivity(
                        Intent(
                            this,
                            PrincipalActivity::class.java
                        )
                    )

                }else{
                    Toast.makeText(this, "Erro ao logar usuário", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun validarCampos(): Boolean {
        if(editEmail.text.isNotEmpty() ){
            if(editSenha.text.isNotEmpty() ){
                return true
            }
        }
        return false
    }

    fun inicializaComponentesInterface() {
        editEmail = findViewById(R.id.edit_email_login)
        editSenha = findViewById(R.id.edit_senha_login)
        autenticacao = Firebase.auth
    }
}