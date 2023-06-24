package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperar UI component no Kotlin
        // ID do componente
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.edtPeso)
        val edtAltura: EditText = findViewById(R.id.edtAltura)
        // Colocar acao no botao

        btnCalcular.setOnClickListener {


            val alturaStr: String = edtAltura.text.toString()
            val pesoStr: String = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()
                val result: Float = peso / (altura * altura)

                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("EXTRA_RESULT", result)
                }
                startActivity(intent)
            }else{
                Toast.makeText(this,"Preencher todos os campos", Toast.LENGTH_LONG).show()
            }


        }


    }
}