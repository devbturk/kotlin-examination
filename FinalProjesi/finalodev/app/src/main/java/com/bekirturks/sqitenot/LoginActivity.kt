package com.bekirturks.sqitenot

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bekirturks.sqitenot.database.DatabaseHelper
import com.bekirturks.sqitenot.model.User
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val databaseHelper = DatabaseHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnRegisterListener()
        btnLoginListener()
    }

    private fun btnRegisterListener() {
        btnRegister.setOnClickListener() {
            if (!databaseHelper.checkUser(txtUsername.text.toString().trim())) {
                val user = User()
                user.username = txtUsername.text.toString().trim()
                user.password = txtPassword.text.toString().trim()
              databaseHelper.addUser(user)
                Toast.makeText(this,"Kullanıcı başarıyla oluşturuldu\n",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Kullanıcı zaten var\n",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun btnLoginListener(){
        btnLogin.setOnClickListener(){
            if(databaseHelper.checkUser(txtUsername.text.toString().trim(),txtPassword.text.toString().trim())){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this,"Giriş başarılı\n",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Kullanıcı adı veya şifre yanlış, lütfen tekrar deneyin\n",Toast.LENGTH_SHORT).show()
            }

        }
    }
}