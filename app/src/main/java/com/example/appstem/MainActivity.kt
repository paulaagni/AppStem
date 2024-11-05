package com.example.appstem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.appstem.navigation.AppNavigation
import com.example.appstem.ui.theme.AppStemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppStemTheme {
                    AppNavigation()
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    AppStemTheme {
        AppNavigation()
    }
}