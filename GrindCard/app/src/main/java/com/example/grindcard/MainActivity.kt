package com.example.grindcard

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView

class MainActivity : AppCompatActivity() {

    private lateinit var gvTabla:GridView

    var nombre = arrayListOf<String>("Roberto","Alvaro","Pedro","Lopez")
    var  departamento = arrayListOf<String>("San Vicete","San Salvador","Santa Ana","Chalatenango")
    var imagen = arrayOf(
                    R.drawable.image1,
                    R.drawable.image2,
                    R.drawable.image3,
                    R.drawable.image4
    )
    var imagenesLista = arrayOf(
                Imgitems(imagen.get(0),nombre.get(0),departamento.get(0)),
                Imgitems(imagen.get(1),nombre.get(1),departamento.get(1)),
                Imgitems(imagen.get(2),nombre.get(2),departamento.get(2)),
                Imgitems(imagen.get(3),nombre.get(3),departamento.get(3))

    )

    var myImagenLista = arrayListOf<Imgitems>()

    var adaptador:AdaptadorModificado? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for(imagen in imagenesLista){
            myImagenLista.add(imagen)
        }

        gvTabla = findViewById(R.id.gtTabla)

        adaptador = AdaptadorModificado(myImagenLista, this,)
        gvTabla.adapter = adaptador
        gvTabla.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var ventana:Intent = Intent(applicationContext,Detalles::class.java)

                ventana.putExtra("imagen",imagen.get(p2))
                ventana.putExtra("nombre",nombre.get(p2))
                ventana.putExtra("departamento",departamento.get(p2))

                startActivity(ventana)

            }
        }


    }
}