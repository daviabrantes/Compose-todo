package com.example.composetodo.data.models

import androidx.compose.ui.graphics.Color
import com.example.composetodo.ui.theme.HighPriorityColor
import com.example.composetodo.ui.theme.LowPriorityColor
import com.example.composetodo.ui.theme.MediumPriorityColor
import com.example.composetodo.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}