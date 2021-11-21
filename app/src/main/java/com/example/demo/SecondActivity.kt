package com.example.demo

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import com.squareup

class SecondActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var bt =findViewById<Button>(R.id.bback)
        bt.setOnClickListener{
            val intent :Intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        var tv = findViewById<TextView>(R.id.textView1)
        var hs :HocSinh =intent.getSerializableExtra("data") as HocSinh
        tv.text = hs.hoten +"-"+hs.diachi
        var i = findViewById<ImageView>(R.id.textView1)

        ReadUrl().execute("https://www.facebook.com/")
        LoadImage().execute("https://gamek.mediacdn.vn/133514250583805952/2021/5/14/photo-1-1620992792318954171812.png")

        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(i);
    }
    inner class ReadUrl : AsyncTask<String, Void, String>(){
        override fun doInBackground(vararg params: String?): String {
            var content : StringBuilder = StringBuilder()
            var url : URL = URL(params[0])
            var urlConnection : HttpURLConnection = url.openConnection() as HttpURLConnection
            var inputStream : InputStream = urlConnection.inputStream
            val inputStreamRender : InputStreamReader = InputStreamReader(inputStream)
            val bufferedReader : BufferedReader = BufferedReader(inputStreamRender) as BufferedReader
            var line :String = ""
            try{
                do{
                    line = bufferedReader.readLine()
                    if( line != null){
                        content.append(line)
                    }

                }while (line != null)
                bufferedReader.close()

            }catch (e : Exception){
                Log.d("aaa",e.toString())
            }
            return content.toString()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Toast.makeText(applicationContext ,result , Toast.LENGTH_LONG).show()
        }

    }

    inner class LoadImage : AsyncTask<String, Void, Bitmap>(){
        override fun doInBackground(vararg params: String?): Bitmap {
            var url = URL(params[0])
            var inputStream = url.openConnection().getInputStream()
            var bitMap =BitmapFactory.decodeStream(inputStream)
            return  bitMap
        }
        var ha = findViewById<ImageView>(R.id.imageView)
        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            ha.setImageBitmap(result)
        }
    }
}