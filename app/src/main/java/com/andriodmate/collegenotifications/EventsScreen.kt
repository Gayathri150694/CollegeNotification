import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.andriodmate.collegenotifications.Event
import com.andriodmate.collegenotifications.EventsViewModel

@Composable
fun EventsScreen(eventsViewModel: EventsViewModel) {
    val events = eventsViewModel.events.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(events.value) { event ->
            EventItem(event)
        }
    }
}

@Composable
fun EventItem(event: Event) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = "${event.title}\n${event.description}\n${event.date} (${event.type})",
            modifier = Modifier.padding(12.dp)
        )
    }
}

