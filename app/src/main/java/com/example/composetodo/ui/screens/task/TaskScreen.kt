package com.example.composetodo.ui.screens.task

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.example.composetodo.data.models.Priority
import com.example.composetodo.data.models.ToDoTask
import com.example.composetodo.ui.viewmodels.SharedViewModel
import com.example.composetodo.util.Action
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {

    val title: String = sharedViewModel.title
    val description: String = sharedViewModel.description
    val priority: Priority = sharedViewModel.priority

    val context = LocalContext.current

    BackHandler {
        navigateToListScreen(Action.NO_ACTION)
    }

    Scaffold(
        topBar = {
            TaskAppBar(
                navigateToListScreen = { action ->
                    if (action == Action.NO_ACTION) {
                        navigateToListScreen(action)
                    } else {
                        if(sharedViewModel.validateFields()) {
                            navigateToListScreen
                        } else {
                            displayToast(context = context)
                        }
                    }},
                selectedTask = selectedTask
            )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = { sharedViewModel.updateTitle(it)},
                description = description,
                onDescriptionChange = { sharedViewModel.updateDescription(it) },
                priority = priority,
                onPrioritySelected = { sharedViewModel.updatePriority(it) }
            )
        }
    )
}

fun displayToast(context: Context) {
    Toast.makeText(
        context,
        "Field empty",
        Toast.LENGTH_SHORT
    ).show()
}