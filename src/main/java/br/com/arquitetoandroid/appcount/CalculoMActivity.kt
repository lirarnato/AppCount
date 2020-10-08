package br.com.arquitetoandroid.appcount

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar




class CalculoMActivity : AppCompatActivity() {
    
    lateinit var ednumero1: EditText
    lateinit var ednumero2: EditText
    lateinit var bt_calcular: Button

    lateinit var toolbar: Toolbar
    lateinit var textTitle: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo_m)

        ednumero1 = findViewById(R.id.ednumero1)
        ednumero2 = findViewById(R.id.ednumero2)

        bt_calcular = findViewById(R.id.bt_calcular)

        bt_calcular.setOnClickListener { calcular(it) }



        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = "AppCount"

    }

    fun calcular(view: View){
        var a: Int = ednumero1.text.toString().toInt()
        var b: Int = ednumero2.text.toString().toInt()

        var calculo: Int = b - a

       val builder = AlertDialog.Builder(this)

        with(builder)
        {
            setTitle("O resultado da operação é:")
            setMessage("R$ ${calculo},00")
           // setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
            //setNegativeButton(android.R.string.no, negativeButtonClick)
            setNeutralButton("ok", null)
            show()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



}
