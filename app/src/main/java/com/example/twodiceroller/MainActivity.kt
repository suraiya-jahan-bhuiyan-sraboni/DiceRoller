package com.example.twodiceroller
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val a : Button =findViewById(R.id.button)
        a.setOnClickListener{
            roll()
        }
    }
    private fun roll() {
        val d = Dice(6)
        val x = d.roll()
        val y = d.roll()
        val sRs : ImageView = findViewById(R.id.imageView)
        val sRS : ImageView = findViewById(R.id.imageView2)
        val sts :TextView = findViewById(R.id.textView)
        val sTs :TextView = findViewById(R.id.textView2)
        val txt1 : TextView = findViewById(R.id.textView3)
        sts.text = x.toString()
        sTs.text = y.toString()
        if(x==y){
           val txt = Toast.makeText(this,"Yoo! It's a Match!",Toast.LENGTH_LONG)
          txt.show()
            txt1.setText(R.string.yoo_it_s_match)
        }
        else{
            txt1.text = " "
        }
        val da = when(x){
            1-> (R.drawable.dice_1)
            2-> (R.drawable.dice_2)git
            4 -> (R.drawable.dice_4)
            5->( R.drawable.dice_5)
            else-> (R.drawable.dice_6)
        }
        sRs.setImageResource(da)
        val db = when(y){
            1-> (R.drawable.dice_1)
            2-> (R.drawable.dice_2)
            3-> (R.drawable.dice_3)
            4 -> (R.drawable.dice_4)
            5->( R.drawable.dice_5)
            else-> (R.drawable.dice_6)
        }
        sRS.setImageResource(db)
    }
}
class Dice(private val sides:Int){
    fun roll():Int{
        return (1..sides).random()
    }
}