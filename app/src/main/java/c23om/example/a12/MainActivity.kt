package c23om.example.a12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.time.LocalTime
import java.util.TimeZone
import  java.util.Calendar

class MainActivity : AppCompatActivity()
{
    private var txW: TextView? = null
    private var time1: Calendar? = null
    private var timeZone1: TimeZone? = null
    private var start:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txW = findViewById(R.id.tvView)
        timeZone1 = TimeZone.getTimeZone("Europe/Moscow")
        Thread.sleep(1000)
        time1 = Calendar.getInstance(timeZone1)
        var tHour = time1?.get(Calendar.HOUR)
        var tMinute = time1?.get(Calendar.MINUTE)
        var tSecond = time1?.get(Calendar.SECOND)
        txW?.setText((tHour).toString() + ":" + tMinute.toString() + ":" + tSecond.toString())
        Thread{
            start = true
            while(start){
                Thread.sleep(1000)
                runOnUiThread(){
                    time1 = Calendar.getInstance(timeZone1)
                    var tHour = time1?.get(Calendar.HOUR)
                    var tMinute = time1?.get(Calendar.MINUTE)
                    var tSecond = time1?.get(Calendar.SECOND)
                    txW?.setText((tHour).toString() + ":" + tMinute.toString() + ":" + tSecond.toString())
                }
           }
        }.start()
    }

    override fun onDestroy(){
        super.onDestroy()
        start = false
    }
}