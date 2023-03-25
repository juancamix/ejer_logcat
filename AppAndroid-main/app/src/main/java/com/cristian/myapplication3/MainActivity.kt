package com.cristian.myapplication3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var campoTexto: EditText? = null
    var campoTextoDireccion: EditText? = null
    var campoTextoTelefono: EditText? = null
    var campoTextoEmail: EditText? = null
    var campoTextoDocumento: EditText? = null
    var campoTextoEdad: EditText? = null
    var txtResultado:TextView? =null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val miBoton:Button= findViewById(R.id.btnIngresar)
        miBoton.setOnClickListener { onClick() }

        campoTexto=findViewById(R.id.editTextNombre)
        campoTextoDireccion=findViewById(R.id.editTextDireccion)
        campoTextoTelefono=findViewById(R.id.editTextTelefono)
        campoTextoEmail=findViewById(R.id.editTextEmail)
        campoTextoDocumento=findViewById(R.id.editTextDocumento)
        campoTextoEdad=findViewById(R.id.editTextEdad)
        txtResultado=findViewById(R.id.txtResultado)
    }

    private fun onClick() {
        val nombre:String=campoTexto!!.text.toString()
        val direccion:String=campoTextoDireccion!!.text.toString()
        val telefono:String=campoTextoTelefono!!.text.toString()
        val email:String=campoTextoEmail!!.text.toString()
        val documento:String=campoTextoDocumento!!.text.toString()
        val edad:String=campoTextoEdad!!.text.toString()

        if (edad > "0" && edad <= "15") {
            txtResultado!!.text="Bienvenid@ $nombre, eres Infante"
        } else if (edad > "15" && edad <= "18") {
            txtResultado!!.text="Bienvenid@ $nombre, eres Adolescente"
        } else if (edad > "18" && edad <= "65") {
            txtResultado!!.text="Bienvenid@ $nombre, eres Adulto"
        } else if (edad > "65") {
            txtResultado!!.text="Bienvenid@ $nombre, eres Adulto Mayor"
        }

        Toast.makeText(this,"Bienvenid@ $nombre, \n Direccion $direccion, \n" +
                " Telefono $telefono, \n" +
                " E-mail $email, \n" +
                " Documento $documento, \n" +
                " Edad $edad ",Toast.LENGTH_LONG).show()

        //NoDañarGracias
    }

}