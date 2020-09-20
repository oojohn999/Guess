package com.oojohn.guss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val secretNumber=SecretNumber() //kotlin用括號創物件
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "secret:"+secretNumber.secret)//設定main方法執行時，先產出secretNumber，為val值
    }
    fun check(view:View){
       val n = ed_number.text.toString().toInt() //取得 n
        println("number:$n")
        Log.d("MainActivity","number"+n) //Log.d(標籤"出處",訊息"n")，Verbose的位置可以選擇是否顯示除錯Debug訊息
        val diff:Int=secretNumber.validate(n)
        var message="Yes,you got it"
        if(diff<0){ // n帶入validate方法
            message="Bigger"
        }else if(diff>0){
            message="Smaller"
        }
//        Toast.makeText(this,message,Toast.LENGTH_LONG).show()//物件導向繼承中MainActivity為Context的一員，故用this
        AlertDialog.Builder(this)
            .setTitle("Message")
            .setMessage(message)
            .setPositiveButton("ok",null)
            .show()
    }
}