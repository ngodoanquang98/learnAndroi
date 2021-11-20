package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tv = findViewById<TextView>(R.id.view1)
        tv.setText("có cái lol cho")
//        var bt =findViewById<Button>(R.id.button2)
//        bt.setText("ngo doan quang")
//        bt.setOnClickListener{
//            Toast.makeText(this, "hello" ,Toast.LENGTH_LONG).show()
//        }
        tv.setOnClickListener { Toast.makeText(this, "xin chào anh Quang" ,Toast.LENGTH_LONG).show() }
        var s1 = findViewById<EditText>(R.id.ed1)
        var s2 = findViewById<EditText>(R.id.ed2)
        var cong =findViewById<Button>(R.id.cong)
        var tru =findViewById<Button>(R.id.tru)
        var nhan =findViewById<Button>(R.id.nhan)
        var chia =findViewById<Button>(R.id.chia)
        var ketqua =findViewById<TextView>(R.id.ketqua)
        cong.setOnClickListener{
            var a : Int = (s1.text.toString()).toInt()
            var b : Int = (s2.text.toString()).toInt()
            var c = a + b
            ketqua.text = c.toString()
        }
        tru.setOnClickListener{
            var a : Int = (s1.text.toString()).toInt()
            var b : Int = (s2.text.toString()).toInt()
            var c = a - b
            ketqua.text = c.toString()
        }
        nhan.setOnClickListener{
            var a : Int = (s1.text.toString()).toInt()
            var b : Int = (s2.text.toString()).toInt()
            var c = a * b
            ketqua.text = c.toString()
        }
        chia.setOnClickListener{
            var a : Int = (s1.text.toString()).toInt()
            var b : Int = (s2.text.toString()).toInt()
            var c  = a.toFloat() / b
            ketqua.text = c.toString()
        }

    }
}