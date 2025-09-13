package com.andriodmate.collegenotifications

// This matches the fields in your Firestore documents
data class Event(
    val title: String = "",
    val description: String = "",
    val date: String = "",
    val type: String = ""
)
