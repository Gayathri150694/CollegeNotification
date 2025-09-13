package com.andriodmate.collegenotifications

import EventsScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.andriodmate.collegenotifications.ui.theme.CollegeNotificationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CollegeNotificationsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 👇 Creates or retrieves ViewModel
                    val eventsViewModel: EventsViewModel = viewModel()

                    // 👇 Show EventsScreen
                    EventsScreen(eventsViewModel = eventsViewModel)
                }
            }
        }
    }
}
