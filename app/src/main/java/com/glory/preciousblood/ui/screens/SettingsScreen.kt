package com.glory.preciousblood.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingsScreen(){
    Column {
        Text(text = "This is Settings Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    SettingsScreen()
}