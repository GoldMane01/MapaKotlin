package com.example.mapa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    var items:MutableList<Ciudad> = mutableListOf<Ciudad>()
    private var intentLaunch: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        items = cargar_lista()
        val lv: ListView =findViewById(R.id.lista)
        val adapter=MyAdapter(this,R.layout.list_item,items)
        lv.adapter=adapter
        lv.setOnItemClickListener(this)

        intentLaunch = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result: ActivityResult ->
            if(result.resultCode == RESULT_OK) {
            }
        }

    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val intent = Intent(this, MapsActivity::class.java)
        intent.putExtra("lat", items[p2].lat)
        intent.putExtra("lon", items[p2].lon)
        intentLaunch?.launch(intent)
    }

    fun cargar_lista():MutableList<Ciudad> {
        val imagenes = intArrayOf(
            R.drawable.almeria, R.drawable.cadiz, R.drawable.cordoba, R.drawable.granada,
            R.drawable.huelva, R.drawable.jaen, R.drawable.malaga, R.drawable.sevilla
        )
        val nombres = arrayOf(
            "Almería","Cádiz","Córdoba","Granada","Huelva","Jaén","Málaga","Sevilla"
        )
        val habitantes = arrayOf(
            124324325,2354325,12464536,1356543,4263546,25436,457325,5676523
        )
        val lat = arrayOf(
            36.8334896592712,36.5210067086058,37.888965223058015,37.17601729183353,37.26205507628663,37.77900764164895,36.72083,37.38873307868959
        )
        val lon = arrayOf(
            -2.463382362027269,-6.280235674927419,-4.776932680590586,-3.5977953662813675,-6.942866206907708,-3.786651269827342,-4.42129,-5.985271133487496
        )
        for(i in nombres.indices) {
            val ciudad = Ciudad(nombres[i],imagenes[i],habitantes[i],lat[i],lon[i])
            items.add(ciudad)
        }
        return items
    }

}