package com.example.myfirstapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstapplication.ui.theme.MyFirstApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstApplicationTheme {
                MyFirstApplication()
            }
        }
    }
}

@Composable
fun MyFirstApplication() {
    var taskText by remember { mutableStateOf("") }
    var tasks by remember { mutableStateOf(listOf<String>()) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = taskText,
            onValueChange = { taskText = it },
            label = { Text("New task") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if (taskText.isNotEmpty()) {
                    tasks = tasks + taskText
                    taskText = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add new task")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(tasks) { task ->
                Text(text = task)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstApplicationTheme {
        MyFirstApplication()
    }
}
