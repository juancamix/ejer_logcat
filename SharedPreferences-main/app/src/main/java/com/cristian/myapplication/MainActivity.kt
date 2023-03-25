package com.cristian.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var campoUser:EditText?=null
    var campoPass:EditText?=null
    var txtUser:TextView?=null
    var txtPass:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarComponentes()
        cargarDatos()
    }

    private fun iniciarComponentes() {
        var btnGuardar:Button=findViewById(R.id.btnGuardar)
        btnGuardar.setOnClickListener { guardadDatos() }

        var btnCargar:Button=findViewById(R.id.btnCargar)
        btnCargar.setOnClickListener { cargarDatos() }

        campoUser=findViewById(R.id.campoUser)
        campoPass=findViewById(R.id.campoPass)
        txtUser=findViewById(R.id.txtUser)
        txtPass=findViewById(R.id.txtPass)
    }

    private  fun  guardadDatos() {
        var preferences:SharedPreferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE)

        var user= campoUser?.text.toString()
        var pass= campoPass?.text.toString()

        var editor:SharedPreferences.Editor=preferences.edit()
        editor.putString("Usuario",user)
        editor.putString("Contraseña",pass)

        txtUser?.text=user
        txtPass?.text=pass

        editor.commit()
        Toast.makeText(this,"Se ha registrado los datos",Toast.LENGTH_SHORT).show()
    }

    private fun cargarDatos() {
        //var preferences:SharedPreferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE)
        //var user: String? =preferences.getString("user","No existe la información")
        //var pass: String? =preferences.getString("pass","No existe la información")
        //txtUser?.text=user
        //txtPass?.text=pass

        val intent =Intent(this,cargarDatos::class.java)
        val miBundle:Bundle= Bundle()
        miBundle.putString("User",txtUser!!.text.toString())
        miBundle.putString("Pass",txtPass!!.text.toString())

        intent.putExtras(miBundle)
        startActivity(intent)
    }
}