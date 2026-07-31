package com.example.attendancetracker


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.attendancetracker.ui.theme.AttendanceTrackerTheme


//private val BlendMode.White: Color
//private val BlendMode.Green: Color

//private val BlendMode.Red: Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AttendanceTrackerTheme {

                    AttendanceApp()
                }
            }
        }
    }

enum class WeekDay {
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
}

data class SubjectClass(
    val subjectName: String,
    var isPresent: Boolean = false,

)

data class DaySchedule(
    val day: WeekDay,
    val classes: MutableList<SubjectClass>
)

@Composable
fun AttendanceApp() {

    val weeklySchedule = remember {
        mutableStateListOf(
            DaySchedule(
                WeekDay.Monday,
                mutableListOf(
                    SubjectClass("Maths"),
                    SubjectClass("Physics")
                )
            ),
            DaySchedule(
                WeekDay.Tuesday,
                mutableListOf(
                    SubjectClass("DSA"),
                    SubjectClass("Chemistry")
                )
            ),
            DaySchedule(
                WeekDay.Wednesday,
                mutableListOf(
                    SubjectClass("Maths"),
                    SubjectClass("Physics")
                )
            ),
            DaySchedule(
                WeekDay.Thursday,
                mutableListOf(
                    SubjectClass("Maths"),
                    SubjectClass("Physics")
                )
            ),
            DaySchedule(
                WeekDay.Friday,
                mutableListOf(
                    SubjectClass("Maths"),
                    SubjectClass("Physics")
                )
            ),
            DaySchedule(
                WeekDay.Saturday,
                mutableListOf(
                    SubjectClass("Maths"),
                    SubjectClass("Physics")
                )
            )

        )
    }

    var selectedTab by remember { mutableStateOf(0)  }

    Column(modifier = Modifier.fillMaxSize()) {

        TabRow(selectedTabIndex = selectedTab) {
            Tab(
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                text = { Text("Today's Classes") }
            )
            Tab(
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                text = { Text("Edit Schedule") }
            )
        }

        if (selectedTab == 0) {
            TodayAttendanceScreen(weeklySchedule)
        } else {
            WeeklyScheduleEditor(weeklySchedule)
        }
    }
}





@Composable
fun TodayAttendanceScreen(weeklySchedule: List<DaySchedule>) {

    val today = WeekDay.Monday // later we can auto-detect

    val todayClasses = weeklySchedule.find { it.day == today }?.classes ?: emptyList()

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Classes for $today",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.height(12.dp))

        LazyColumn {
            items(todayClasses) { subject ->
                SubjectAttendanceItem(subject)
            }
        }
    }
}

@Composable
fun SubjectAttendanceItem(subject: SubjectClass) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(subject.subjectName)



            Button(
                onClick = { subject.isPresent = !subject.isPresent },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (subject.isPresent)
                        Color(0xFF4CAF50)
                    else
                        Color(0xFFF44336)
                )
            ) {
                Text(
                    if (subject.isPresent) "Present" else "Absent",
                    color = Color(0xFF030303)
                )
            }
        }
    }
}

@Composable
fun WeeklyScheduleEditor(weeklySchedule: MutableList<DaySchedule>) {

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(weeklySchedule) { daySchedule ->
            DayEditor(daySchedule)
        }
    }
}
@Composable
fun DayEditor(daySchedule: DaySchedule) {

    var newSubject by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            // Day title
            Text(
                text = daySchedule.day.name,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(8.dp))

            // Existing subjects with DELETE icon
            daySchedule.classes.forEach { subject ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(text = subject.subjectName)

                    IconButton(
                        onClick = {
                            daySchedule.classes.remove(subject)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Delete Class",
                            tint = Color(0xFFF44336)
                        )
                    }
                }




            }
            Divider(Modifier.padding(vertical = 8.dp))
            // Add new subject
            OutlinedTextField(
                value = newSubject,
                onValueChange = { newSubject = it },
                label = { Text("Add Subject") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    if (newSubject.isNotBlank()) {
                        daySchedule.classes.add(SubjectClass(newSubject))
                        newSubject = ""
                    }
                },
                modifier = Modifier.padding(top = 6.dp)
            ) {
                Text("Add Class")
            }
        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun Pre(){

    AttendanceApp()
}



