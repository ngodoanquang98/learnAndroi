package com.example.demo

import android.content.Intent
import android.graphics.Color
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

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
        var layout = findViewById<LinearLayout>(R.id.layout)
        var img = findViewById<ImageView>(R.id.img)
        layout.setBackgroundColor(Color.WHITE)
        img.setImageResource(R.drawable.cmt)

        //list view
        var lv = findViewById<ListView>(R.id.listview)
//        var monhoc : List<String> = listOf("C++","C#","python","ruby","kotlin")
//        lv.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,monhoc)
//
        var arraymonan : ArrayList<MonAn> = ArrayList()

        arraymonan.add(MonAn("Bánh mỳ pate",R.drawable.cmt))
        arraymonan.add(MonAn("cứt chó",R.drawable.cmt))
        arraymonan.add(MonAn("cứt mèo",R.drawable.cmt))
        arraymonan.add(MonAn("cứt lơn",R.drawable.cmt))
        arraymonan.add(MonAn("xoi",R.drawable.cmt))
        arraymonan.add(MonAn("trà sữa",R.drawable.cmt))
        lv.adapter =CustomAdapter(this@MainActivity,arraymonan)

       img.setOnClickListener{
            val intent :Intent = Intent(this,SecondActivity::class.java)
      //     val arrayNumber :IntArray = intArrayOf(231,23,4,1,23,231332,4,42,2)
           var hocsinh = HocSinh("Ngo Doan Quang",1998,"Nam Dinh")
           intent.putExtra("data",hocsinh)
            startActivity(intent)
        }
    }
}