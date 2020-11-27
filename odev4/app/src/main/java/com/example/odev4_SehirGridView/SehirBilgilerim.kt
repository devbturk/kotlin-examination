package com.example.odev4_SehirGridView

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sehir_bilgilerim.*

class SehirBilgilerim: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sehir_bilgilerim)
        val bundle = intent.extras

        ivSehirresmi.setImageResource(bundle.getInt("image"))
        tvSehirAdi.text = bundle.getString("sehirAd")
        tvSehirHakkinda.text = bundle.getString("sehirBilgileri")
    }

}