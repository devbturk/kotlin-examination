package com.example.my_odev3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editxtAd =findViewById(R.id.editxtAd) as EditText
        val editSoyad = findViewById(R.id.editxtSoyad) as EditText
        val editYas = findViewById(R.id.editxtYas) as EditText
        val editMail =findViewById(R.id.editxtMail) as EditText
       var sifre1 = findViewById(R.id.editxtSifre) as EditText
       var sifre2 = findViewById(R.id.editxtSifretekrar) as EditText



        val btnKayit = findViewById(R.id.btnKayit) as Button
        btnKayit.setOnClickListener {
            val mailKontrol = editMail.text.toString()
            val boolean = mailKontrol.contains("@")
            if (editxtAd.length() >= 2){}
                else(Toast.makeText(this, "Ad bilgisini yanlış girdiniz ", Toast.LENGTH_LONG).show())
            if (editSoyad.length() >= 2){}
                else{Toast.makeText(this, "soyad bilgisini yanlış girdiniz ", Toast.LENGTH_LONG).show()}
            if (editYas.text.isEmpty() || editYas.text.toString().toInt() !in 18..100)
            {Toast.makeText(this, "Yaş bilgisini yanlış girdiniz ", Toast.LENGTH_LONG).show()}
            if(boolean == false)
            {Toast.makeText(this, "eposta formatı hatalıdır ", Toast.LENGTH_LONG).show()}
            if (sifre1.text.toString().trim().length < 5){
                Toast.makeText(this, "Şifre en az 5 karakterden oluşmalıdır ", Toast.LENGTH_LONG).show()
            }
            else if (sifre2.text.toString() != sifre1.text.toString() )
            {Toast.makeText(this, "Girilen şifreler uyuşmuyor ", Toast.LENGTH_LONG).show()}
            else{
                Toast.makeText(this, "Kayıt Yapıldı  ", Toast.LENGTH_LONG).show()
            }

        }










    }
}