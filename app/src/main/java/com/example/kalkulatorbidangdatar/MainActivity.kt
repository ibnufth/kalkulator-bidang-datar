package com.example.kalkulatorbidangdatar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import java.lang.Math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var hasil_luas : TextView
    lateinit var hasil_keliling :TextView
    lateinit var value_1 : EditText
    lateinit var value_2 : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext,getString(R.string.funct),LENGTH_LONG).show()
        hasil_luas= findViewById(R.id.tv_hasil_luas)
        hasil_keliling=findViewById(R.id.tv_hasil_keliling)
        value_1=findViewById(R.id.value_1)
    }

    fun hitung(view: View) {
        val value1 = value_1.getText().toString().toDouble()
        when(view.getId()){
            R.id.btn_htg_persegi-> {
                value_2=findViewById(R.id.value_2)
                val value2 = value_2.getText().toString().toDouble()
                htg_persegi(value1, value2)
            }
            R.id.btn_htg_segitiga->{
                value_2=findViewById(R.id.value_2)
                val value2 = value_2.getText().toString().toDouble()
                htg_segitiga(value1,value2)
            }
            R.id.btn_htg_lingkaran->htg_lingkaran(value1)
        }
    }

    private fun htg_lingkaran(value1: Double) {
        val PI = 3.14159
        hasil_luas.setText((PI*value1/4).toString())
        hasil_keliling.setText((PI*value1).toString())
    }

    private fun htg_segitiga(value1: Double, value2: Double) {
        hasil_luas.setText((value1*value2/2).toString())
        val value3 = sqrt((value1*value1)+ (value2*value2))
        hasil_keliling.setText((value1+value2+value3).toString())
    }

    private fun htg_persegi(value_1:Double,value_2:Double) {
        hasil_luas.setText((value_1*value_2).toString())
        hasil_keliling.setText(((2*value_1)+(2*value_2)).toString())
    }
}
