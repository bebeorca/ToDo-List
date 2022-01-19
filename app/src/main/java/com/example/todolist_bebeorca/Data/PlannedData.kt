package com.example.todolist_bebeorca.Data

import android.widget.TextView
import java.sql.Time
import java.util.*

data class PlannedData(
    var title: TextView,
    var date: Date,
    var task: MutableList<String>,
    var taskTime: Time
)
