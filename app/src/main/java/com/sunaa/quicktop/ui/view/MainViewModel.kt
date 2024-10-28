package com.sunaa.quicktop.ui.view

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val numbers = (1 .. 100 ).toList()

    val items = mutableStateOf(numbers)
}