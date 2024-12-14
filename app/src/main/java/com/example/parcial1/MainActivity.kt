package com.example.parcial1

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val sizeArray = 5
    private var currentPosition = 0

    private lateinit var tornillos: Array<Tornillo?>

    // instancias de componentes graficos
    private lateinit var title: TextView
    private lateinit var message: TextView
    private lateinit var sku: EditText
    private lateinit var material: EditText
    private lateinit var length: EditText
    private lateinit var headShape: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tornillos = Array(sizeArray) { Tornillo() }

        initComponents()
        sku.requestFocus()
    }

    private fun initComponents() {
        title = findViewById(R.id.txtTitle)
        message = findViewById(R.id.txtMessage)
        sku = findViewById(R.id.edtSku)
        material = findViewById(R.id.edtMaterial)
        length = findViewById(R.id.edtLength)
        headShape = findViewById(R.id.edtHeadShape)

    }

    fun add(view: View?) {
        if (sku.text.isNotEmpty() && material.text.isNotEmpty() && length.text.isNotEmpty() && headShape.text.isNotEmpty()) { //
            if(currentPosition < 5) {
                tornillos[currentPosition]!!.sku = sku.text.toString().toInt()
                tornillos[currentPosition]!!.material = material.text.toString().orEmpty()
                tornillos[currentPosition]!!.lenght = length.text.toString().orEmpty()
                tornillos[currentPosition]!!.headShape = headShape.text.toString().orEmpty()
                message.setText("El tornillo ${tornillos[currentPosition]!!.sku} fue registrado con éxito! :p")
                Toast.makeText(this, "Tornillo: ${tornillos[currentPosition]!!.sku} registrado", Toast.LENGTH_LONG).show()
                currentPosition++
            } else {
                message.setText("No hay más espacio en el arreglo :c")
                Toast.makeText(this, "No hay más espacio en el arreglo", Toast.LENGTH_LONG).show()
            }
        } else {
            message.setText("Registra todos los datos, por favor :p")
            Toast.makeText(this, "Registra todos los datos, por favor", Toast.LENGTH_LONG).show()
        }
    }

    fun clean(view: View?) {
        sku.setText("")
        material.setText("")
        length.setText("")
        headShape.setText("")

        sku.requestFocus()

        message.setText("La vista fue limpiada :p")
        Toast.makeText(this, "Vista limpia", Toast.LENGTH_LONG).show()
    }

    fun search(view: View?) {
        var counter = 0
        if(sku.text.isNotEmpty()){
            for (i in 0 until sizeArray) {
                if(tornillos[i]!!.sku == sku.text.toString().toInt()) {
                    sku.setText("${getString(R.string.sku)} ${tornillos[i]!!.sku.toString()}")
                    material.setText("${getString(R.string.material)} ${tornillos[i]!!.material}")
                    length.setText("${getString(R.string.length)} ${tornillos[i]!!.lenght}")
                    headShape.setText("${getString(R.string.headShape)} ${tornillos[i]!!.headShape}")

                    message.setText("Un objeto fue encontrado! c:")
                    Toast.makeText(this, "Tornillo mostrado", Toast.LENGTH_LONG).show()
                    counter = 0
                    break
                } else {
                    counter = -1
                    message.setText("No se encontro un tornillo para mostrar :c")
                    Toast.makeText(this, "No se encontraron coincidencias", Toast.LENGTH_LONG).show()
                }
            }
        } else if (counter == -1){
            message.setText("No se encontro un tornillo para mostrar :c")
            Toast.makeText(this, "No se encontraron coincidencias", Toast.LENGTH_LONG).show()
        } else {
            message.setText("Ingresa un código para buscar :p")
            Toast.makeText(this, "Ingresa un código para buscar", Toast.LENGTH_LONG).show()
        }
    }
}