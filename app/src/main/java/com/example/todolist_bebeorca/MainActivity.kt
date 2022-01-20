package com.example.todolist_bebeorca

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.todolist_bebeorca.fragment.AddPlanningFragment

class MainActivity : AppCompatActivity() {

    lateinit var add_planning_framelayout: FrameLayout
    private lateinit var leftArrow: ImageView
    private lateinit var addplanningimg: ImageView
    private lateinit var addplanningtxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setStatusBarColor()

        add_planning_framelayout = findViewById(R.id.add_planning_framelayout)
        leftArrow = findViewById(R.id.leftArrow)
        addplanningimg = findViewById(R.id.addplanningbtn)
        addplanningtxt = findViewById(R.id.addplanningtxt)

        addplanningimg.setOnClickListener {
            addplanningbtnclicked()
        }
        addplanningtxt.setOnClickListener {
            addplanningbtnclicked()
        }

        leftArrow.setOnClickListener {
            onBackPressed()
        }

    }

    override fun onBackPressed() {
        if(add_planning_framelayout.visibility == View.VISIBLE){
            add_planning_framelayout.visibility = View.GONE
            leftArrow.visibility = View.GONE
            addplanningimg.visibility = View.VISIBLE
            addplanningtxt.visibility = View.VISIBLE
        }
        else finish()
    }

    fun replaceFragment(frg: Fragment) = supportFragmentManager.beginTransaction()
        .replace(R.id.add_planning_framelayout, frg).commit()

    fun addplanningbtnclicked(){
        if (add_planning_framelayout.visibility == View.GONE){
            replaceFragment(AddPlanningFragment())
            add_planning_framelayout.visibility = View.VISIBLE
            leftArrow.visibility = View.VISIBLE
            addplanningtxt.visibility = View.GONE
            addplanningimg.visibility = View.GONE
        }
    }

    private fun setStatusBarColor(){
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.main_background)
    }

}