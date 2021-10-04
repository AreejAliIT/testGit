package com.example.testgit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var display: TextView
    private lateinit var btn0: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnPlusandMinus: Button
    private lateinit var btndecimal: Button
    private lateinit var btnmultiply: Button
    private lateinit var btndivide: Button
    private lateinit var btnadd: Button
    private lateinit var btnsubtract: Button
    private lateinit var btnclear: Button
    private lateinit var btnresult: Button
    private lateinit var btndel: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        display = findViewById(R.id.display)
        display.text = viewModel.displayText

        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnPlusandMinus = findViewById(R.id.btnPandM)
        btnsubtract = findViewById(R.id.btnMinus)
        btnmultiply = findViewById(R.id.btnMult)
        btndivide = findViewById(R.id.btnDev)
        btndecimal = findViewById(R.id.btnDec)
        btnadd = findViewById(R.id.btnPlus)
        btnclear = findViewById(R.id.btnClear)
        btnresult = findViewById(R.id.btnEqu)
        btndel = findViewById(R.id.btnDelete)
        //set the setOnClickListener for Numbers Buttons
        btn0.setOnClickListener{viewModel.setNumber('0'); display.text = viewModel.displayText}
        btn1.setOnClickListener{viewModel.setNumber('1'); display.text = viewModel.displayText}
        btn2.setOnClickListener{viewModel.setNumber('2'); display.text = viewModel.displayText}
        btn3.setOnClickListener{viewModel.setNumber('3'); display.text = viewModel.displayText}
        btn4.setOnClickListener{viewModel.setNumber('4'); display.text = viewModel.displayText}
        btn5.setOnClickListener{viewModel.setNumber('5'); display.text = viewModel.displayText}
        btn6.setOnClickListener{viewModel.setNumber('6'); display.text = viewModel.displayText}
        btn7.setOnClickListener{viewModel.setNumber('7'); display.text = viewModel.displayText}
        btn8.setOnClickListener{viewModel.setNumber('8'); display.text = viewModel.displayText}
        btn9.setOnClickListener{viewModel.setNumber('9'); display.text = viewModel.displayText}
        //Operators
        btnadd.setOnClickListener{ viewModel.handleOperator('+'); display.text = viewModel.displayText }
        btnsubtract.setOnClickListener{ viewModel.handleOperator('-'); display.text = viewModel.displayText }
        btnmultiply.setOnClickListener{ viewModel.handleOperator('*'); display.text = viewModel.displayText }
        btndivide.setOnClickListener{ viewModel.handleOperator('/'); display.text = viewModel.displayText }
        // Decimal , +/- , DEL , =
        btndecimal.setOnClickListener { viewModel.onClickDecimal(); display.text = viewModel.displayText }
        btnPlusandMinus.setOnClickListener { viewModel.onClickPlusMinus(); display.text = viewModel.displayText }
        btnclear.setOnClickListener { viewModel.clearAll(); display.text = viewModel.displayText }
        btnresult.setOnClickListener { viewModel.calculate(); display.text = viewModel.displayText }
        btndel.setOnClickListener { viewModel.deleteLast(); display.text = viewModel.displayText }

    }
    private fun calculator() {

    }


}