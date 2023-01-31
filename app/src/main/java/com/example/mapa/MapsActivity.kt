package com.example.mapa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.mapa.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val almeria = LatLng(36.83956473229845, -2.470736796607865)
        val cadiz = LatLng(36.523193078458405, -6.29110213778655)
        val cordoba = LatLng(37.90108624898978, -4.782334652111835)
        val granada = LatLng(37.176694046516616, -3.6057728622560816)
        val huelva = LatLng(37.27038146342348, -6.934750646354697)
        val jaen = LatLng(37.78631314166246, -3.799559509997027)
        val malaga = LatLng(36.72315816667399, -4.429366129132443)
        val sevilla = LatLng(37.39145115451652, -5.9935012144700925)
        mMap.addMarker(MarkerOptions().position(almeria).title("Almería").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.almeria)).snippet("Habitantes: 124324325"))
        mMap.addMarker(MarkerOptions().position(cadiz).title("Cádiz").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.cadiz)).snippet("Habitantes: 2354342525"))
        mMap.addMarker(MarkerOptions().position(cordoba).title("Córdoba").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.cordoba)).snippet("Habitantes: 34235435325"))
        mMap.addMarker(MarkerOptions().position(granada).title("Granada").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.granada)).snippet("Habitantes: 3256436354"))
        mMap.addMarker(MarkerOptions().position(huelva).title("Huelva").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.huelva)).snippet("Habitantes: 945343"))
        mMap.addMarker(MarkerOptions().position(jaen).title("Jaén").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.jaen)).snippet("Habitantes: 1266754"))
        mMap.addMarker(MarkerOptions().position(malaga).title("Málaga").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.malaga)).snippet("Habitantes: 54237654"))
        mMap.addMarker(MarkerOptions().position(sevilla).title("Sevilla").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.sevilla)).snippet("Habitantes: 16543654"))


        val lat = intent.getDoubleExtra("lat",0.0)
        val lon = intent.getDoubleExtra("lon",0.0)

        val cameraPositionInicial = CameraPosition.Builder().target(sevilla).zoom(10.0f).build()
        val cameraUpdateInicial = CameraUpdateFactory.newCameraPosition(cameraPositionInicial)

        mMap.moveCamera(cameraUpdateInicial)

        val cameraPosition = CameraPosition.Builder().target(LatLng(lat, lon)).zoom(10.0f).build()
        val cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)

        mMap.animateCamera(cameraUpdate)
    }
}