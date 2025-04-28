package com.gaps.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.gaps.myapplication.data.LocalPersistence
import com.gaps.myapplication.ui.theme.Android_trainingTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: ModelViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, ModelViewModelFactory(LocalPersistence.getModelDao(this)))[ModelViewModel::class.java]

        setContent {
            Android_trainingTheme {
                // A surface container using the 'background' color from the theme
                val models = viewModel.models.collectAsState().value
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { it ->
                    it
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
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
                            Text(text = "Guardar")
                        }
                        models.map { model ->
                            Text(text = model.data)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun WeirdIconButton() {
    Button(onClick = {  }) {
        Image(
            painter = painterResource(R.drawable.icon_pixeled_svg),
            "",
            modifier = Modifier.padding(12.dp).size(254.dp)
        )
        Text(text = "Guardar")
    }
}

@Preview(showBackground = true)
@Composable
fun WeirdIconButtonPreview() {
    Android_trainingTheme {
        WeirdIconButton()
    }
}