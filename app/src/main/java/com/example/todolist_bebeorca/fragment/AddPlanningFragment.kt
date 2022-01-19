package com.example.todolist_bebeorca.fragment

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.todolist_bebeorca.Data.PlannedData
import com.example.todolist_bebeorca.MainActivity
import com.example.todolist_bebeorca.R
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddPlanningFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddPlanningFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var mainActivity: MainActivity
    lateinit var plannedData: PlannedData

    private lateinit var add_task_button: Button
    private lateinit var plan_title: EditText
    private lateinit var date_title: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_planning, container, false)

        plan_title = view.findViewById(R.id.planning_title)
        date_title = view.findViewById(R.id.planning_date)
        add_task_button = view.findViewById(R.id.add_task_button)


        date_title.setOnClickListener {

            val datePickerFragment = DatePickerFragment()
            val supportFragmentManager = requireActivity().supportFragmentManager

            supportFragmentManager.setFragmentResultListener(
                "REQUEST_KEY",
            viewLifecycleOwner
            ){
                resultKey, bundle -> if (resultKey=="REQUEST_KEY"){
                    val date = bundle.getString("SELECTED_DATE")
                    date_title.setText(date)
                }
            }

            datePickerFragment.show(supportFragmentManager, "DatePickerFragment")

        }




        return view
    }

//    fun openCalendar(){
//
//    }

}