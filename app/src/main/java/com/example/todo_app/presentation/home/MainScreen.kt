package com.example.todo_app.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.layout.*

import androidx.compose.material.*

import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Dialog

@Composable
fun MainScreen() {
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(modifier: Modifier = Modifier) {
    TopAppBar(title = { Text("My App") })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoAppScreen() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("TODO APP") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO: Add action */ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Todo")
            }
        },
        bottomBar = { BottomNavigationBar() }
    ) {
        TodoList()
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        backgroundColor = MaterialTheme.colors.background,
        elevation = 8.dp
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.List, contentDescription = "All") },
            label = { Text("All") },
            selected = true,
            onClick = { /* TODO: Add action */ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Check, contentDescription = "Completed") },
            label = { Text("Completed") },
            selected = false,
            onClick = { /* TODO: Add action */ }
        )
    }
}

@Composable
fun TodoList() {
    val todoItems = listOf(
        TodoItem("TODO TITLE", "TODO SUB TITLE"),
        TodoItem("TODO TITLE", "TODO SUB TITLE"),
        TodoItem("TODO TITLE", "TODO SUB TITLE"),
        TodoItem("TODO TITLE", "TODO SUB TITLE")
    )

    Column(modifier = Modifier.padding(16.dp)) {
        todoItems.forEach { todoItem ->
            TodoCard(todoItem)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

data class TodoItem(val title: String, val subtitle: String)

@Composable
fun TodoCard(todoItem: TodoItem) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(todoItem.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(todoItem.subtitle, fontSize = 14.sp, color = Color.Gray)
            }
            IconButton(onClick = { /* TODO: Add edit action */ }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
            }
            IconButton(onClick = { /* TODO: Add delete action */ }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
            }
            IconButton(onClick = { /* TODO: Add complete action */ }) {
                Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "Complete")
            }
        }
    }
}

@Composable
fun AddTodoDialog(onDismiss: () -> Unit, onAdd: (String, String) -> Unit) {
    var title by remember { mutableStateOf("") }
    var subtitle by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = MaterialTheme.colors.background
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Add Todo", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                BasicTextField(
                    value = title,
                    onValueChange = { title = it },
                    decorationBox = { innerTextField ->
                        if (title.isEmpty()) {
                            Text("Title", color = Color.Gray)
                        }
                        innerTextField()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color.LightGray, RoundedCornerShape(4.dp))
                )
                Spacer(modifier = Modifier.height(8.dp))
                BasicTextField(
                    value = subtitle,
                    onValueChange = { subtitle = it },
                    decorationBox = { innerTextField ->
                        if (subtitle.isEmpty()) {
                            Text("Subtitle", color = Color.Gray)
                        }
                        innerTextField()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color.LightGray, RoundedCornerShape(4.dp))
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    TextButton(onClick = {
                        onAdd(title, subtitle)
                        onDismiss()
                    }) {
                        Text("Add")
                    }
                }
            }
        }
    }
}
@Preview
@Composable
fun MainScreenPreview(modifier: Modifier = Modifier) {
    MainScreen()
}
