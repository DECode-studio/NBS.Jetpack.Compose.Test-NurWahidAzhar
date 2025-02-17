import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StopwatchScreen() {
    var time by remember { mutableStateOf("00:00:00") }
    val laps = remember { mutableStateListOf("Lap 1 : 00:00:45", "Lap 2 : 00:01:45", "Lap 3 : 00:02:45") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TimerDisplay(time)
        StopwatchButtons(
            onStart = { /* Start timer */ },
            onReset = { /* Reset timer */ },
            onLap = { /* Add lap */ }
        )
        LapsContainer(laps)
    }
}

@Composable
fun TimerDisplay(time: String) {
    Text(
        text = time,
        fontSize = 48.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 32.dp)
    )
}

@Composable
fun StopwatchButtons(onStart: () -> Unit, onReset: () -> Unit, onLap: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = onStart,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A0DAD)),
            shape = RoundedCornerShape(50),
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Start", color = Color.White)
        }

        Button(
            onClick = onReset,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A0DAD)),
            shape = RoundedCornerShape(50),
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Reset", color = Color.White)
        }
    }

    Button(
        onClick = onLap,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A0DAD)),
        shape = RoundedCornerShape(50),
        modifier = Modifier.padding(bottom = 16.dp).fillMaxWidth()
    ) {
        Text(text = "Lap", color = Color.White)
    }
}

@Composable
fun LapsContainer(laps: List<String>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) // Fixed height for the laps container
            .border(1.dp, Color(0xFF6A0DAD), RoundedCornerShape(8.dp))
            .background(Color(0xFFF3E8FF))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Laps",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            laps.forEach { lap ->
                Text(text = lap)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StopwatchScreenPreview() {
    StopwatchScreen()
}
