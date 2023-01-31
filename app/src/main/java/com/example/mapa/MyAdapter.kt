package com.example.mapa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(val contexto:Context, val layout:Int, val ciudades:MutableList<Ciudad>): BaseAdapter() {
    override fun getCount(): Int {
        return ciudades.size
    }

    override fun getItem(p0: Int): Any {
        return ciudades[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var vista = convertView
        val holder:ViewHolder
        if(vista == null) {
            val inflater = LayoutInflater.from(contexto)
            vista = inflater.inflate(R.layout.list_item, null)
            holder = ViewHolder()
            holder.texto = vista.findViewById(R.id.tvNombre)
            holder.foto = vista.findViewById(R.id.ivFoto)
            vista.tag = holder
        } else {
            holder = vista.tag as ViewHolder
        }
        val ciudad = ciudades[position]
        if(ciudad!=null) {
            holder.texto?.text = ciudad.nombre
            holder.foto?.setImageDrawable(contexto.getDrawable(ciudad.imagen))
        }
        return vista
    }

    internal class ViewHolder {
        var foto: ImageView? = null
        var texto: TextView? = null
    }
}