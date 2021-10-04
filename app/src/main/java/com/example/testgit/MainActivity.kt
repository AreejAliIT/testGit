package com.example.testgit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
    var result = 0f
    var operator = ' '
    var num1 = ""
    var num2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        display = findViewById(R.id.display)

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
        //set Numbers Buttons
        btn0.setOnClickListener{setNumber('0')}
        btn1.setOnClickListener{setNumber('1')}
        btn2.setOnClickListener{setNumber('2')}
        btn3.setOnClickListener{setNumber('3')}
        btn4.setOnClickListener{setNumber('4')}
        btn5.setOnClickListener{setNumber('5')}
        btn6.setOnClickListener{setNumber('6')}
        btn7.setOnClickListener{setNumber('7')}
        btn8.setOnClickListener{setNumber('8')}
        btn9.setOnClickListener{setNumber('9')}
        //Operators
        btnadd.setOnClickListener{setOperator('+')}
        btnsubtract.setOnClickListener{setOperator('-')}
        btnmultiply.setOnClickListener{setOperator('*')}
        btndivide.setOnClickListener{setOperator('/')}
        // Decimal , +/- , DEL , =
        btndecimal.setOnClickListener {setDecimal()}
        btnPlusandMinus.setOnClickListener {plusandMinus()}
        btnclear.setOnClickListener{clearAll() }
        btnresult.setOnClickListener{calculate()}
        btndel.setOnClickListener{deleteLast()}

    }
     fun setNumber(num : Char) {
        if(operator==' '){
            num1 += num
            display.text = num1
        }else{
            num2 += num
            val text = num1 + operator + num2
            display.text = text
        }
    }
    @JvmName("setOperator1")
     fun setOperator(op: Char){
        operator = op
        val text = num1 + operator
        display.text = text
    }
     fun calculate(){
        when (operator) {
            '+' -> result = num1.toFloat() + num2.toFloat()
            '-' -> result = num1.toFloat() - num2.toFloat()
            '*' -> result = num1.toFloat() * num2.toFloat()
            '/' -> if(num1.toFloat()!=0f&&num2.toFloat()!=0f){
                result = num1.toFloat() / num2.toFloat()
            }else{
                Toast.makeText(this, "can't divide by 0 !", Toast.LENGTH_SHORT).show()
            }
        }
        num1 = result.toString()
        num2 = ""
        display.text = result.toString()
    }
     fun clearAll(){
        result = 0f
        operator = ' '
        num1 = ""
        num2 = ""
        display.text = "0"
    }
     fun deleteLast(){
        if(operator==' '){
            if(num1.isNotEmpty()){
                num1 = num1.substring(0, num1.length - 1)
                if(num1.isEmpty()) {display.text = "0"} else{display.text = num1}
            }
        }else{
            if(num2.isNotEmpty()){
                num2 = num2.substring(0, num2.length - 1)
                val text = num1 + operator + num2
                display.text = text
            }else{
                operator=' '
                display.text = num1
            }
        }
    }
    fun setDecimal(){
        if(operator==' '&&!num1.contains(".")){setNumber('.')}
        if(operator!=' '&&!num2.contains(".")){setNumber('.')}
    }
    fun plusandMinus(){
        if(operator==' '){
            num1 = if(num1.startsWith("-")){
                num1.substring(1, num1.length)
            } else{
                "-$num1"
            }
            display.text = num1
        }else{
            num2 = if(num2.startsWith("-")){
                num2.substring(1, num2.length)
            } else{
                "-$num2"
            }
            val text = num1 + operator + num2
            display.text = text
        }
    }
}