package com.glory.preciousblood.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AboutUs(){
    Column {
        Text(text = "This is Prayer List Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun PrayerListPreview() {
    AboutUs()
}