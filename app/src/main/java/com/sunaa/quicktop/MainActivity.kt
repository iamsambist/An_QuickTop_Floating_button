package com.sunaa.quicktop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.sunaa.quicktop.ui.theme.QuickTopTheme
import com.sunaa.quicktop.ui.view.ScreenMain
import com.sunaa.quicktop.ui.view.ShowNiceListBehavior

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuickTopTheme {
                ScreenMain()
            }
        }
    }
}



