package com.gaps.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.gaps.myapplication.data.LocalPersistence
import com.gaps.myapplication.ui.theme.Android_trainingTheme

class Activity2 : ComponentActivity() {

    private lateinit var viewModel: ModelViewModel2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewModel = ViewModelProvider(this, ModelViewModelFactory2(LocalPersistence.getModelDao(this)))[ModelViewModel2::class.java]

        setContent {
            Android_trainingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding).fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Activity2")

                        Button(onClick = { Intent(this@Activity2, Activity3::class.java).also { startActivity(it) } }) {
                            Text("Go To Activity 3")
                        }
                        var text by remember { mutableStateOf("") }
                        Spacer(modifier = Modifier.padding(top = 12.dp))
                        TextField(
                            value = text,
                            onValueChange = {
                                text = it
                            }
                        )
                        Spacer(modifier = Modifier.padding(top = 12.dp))
                        Button(onClick = { viewModel.insertModel(text) }) {
                            Text(text = "Save")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Android_trainingTheme {
        Greeting2("Android")
    }
}