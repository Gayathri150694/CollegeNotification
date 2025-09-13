package com.andriodmate.collegenotifications

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class EventsViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private var registration: ListenerRegistration? = null

    private val _events = MutableStateFlow<List<Event>>(emptyList())
    val events: StateFlow<List<Event>> = _events.asStateFlow()

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    init { subscribeToEvents() }

    private fun subscribeToEvents() {
        _loading.value = true
        registration = db.collection("event")
            .addSnapshotListener { snapshots, error ->
                if (error != null) {
                    _loading.value = false
                    return@addSnapshotListener
                }
                val list = snapshots?.documents?.mapNotNull { it.toObject(Event::class.java) } ?: emptyList()
                _events.value = list
                _loading.value = false
            }
    }

    override fun onCleared() {
        registration?.remove()
        super.onCleared()
    }
}
