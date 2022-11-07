package com.example.grindcard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorModificado(
    var imagenLista:ArrayList<Imgitems>,
    var context: Context
)
    : BaseAdapter() {
    override fun getCount(): Int {
        return imagenLista.size
    }

    override fun getItem(p0: Int): Any {
        return imagenLista[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
         var vista = p1
         if (vista == null){
             vista = LayoutInflater.from(context).inflate(R.layout.fila_items,p2,false)
         }
        var imagenvista:ImageView = vista!!.findViewById(R.id.iv_imagen)
        var tvNombre:TextView=vista!!.findViewById(R.id.tv_Nombre)
        var tvDepartamento:TextView=vista!!.findViewById(R.id.tv_Departamento)

        val imgIdentificador= imagenLista[p0]
        imagenvista.setImageResource(imgIdentificador.imagen)
        tvNombre.text = imgIdentificador.nombre
        tvDepartamento.text = imgIdentificador.departamento

        return vista!!
    }
}