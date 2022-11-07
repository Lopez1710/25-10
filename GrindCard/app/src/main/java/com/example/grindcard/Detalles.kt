package com.example.grindcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Detalles : AppCompatActivity() {

    lateinit var imFoto:ImageView
    lateinit var tvnombre:TextView
    lateinit var tvDepartamento:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

        imFoto=findViewById(R.id.img_Foto)
        tvnombre=findViewById(R.id.tv_name)
        tvDepartamento=findViewById(R.id.tv_location)

        val bundle:Bundle= getIntent().getExtras()!!
        imFoto.setImageResource(bundle.getInt("imagen"))
        tvnombre.setText(bundle.getString("nombre"))
        tvDepartamento.setText(bundle.getString("departamento"))
    }
}