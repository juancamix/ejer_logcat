package com.cristian.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class cargarDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cargar_datos)

        val campoUser=findViewById<TextView>(R.id.txtUser)
        val campoPass=findViewById<TextView>(R.id.txtPass)

        var miBundle: Bundle? =this.intent.extras

        if (miBundle != null) {
            campoUser.text="User ${miBundle.getString("User")} registrado"
            campoPass.text="Pass ${miBundle.getString("Pass")} registrada"
        }

        val btnVolver:Button =findViewById(R.id.btnVolver)
        btnVolver.setOnClickListener { onClick() }
    }

    private  fun onClick() {
        finish()
    }
}