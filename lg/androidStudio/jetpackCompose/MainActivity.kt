package com.example.jetcom1

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetcom1.ui.theme.Jetcom1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetcom1Theme() {
                saludo()
            }
        }
    }
}

@Composable
fun contador(text: String){
    Text(text)
}
@Composable
fun saludo(){
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.padding(8.dp)) {
            imagen()
            Column(
                //modifier = Modifier.background(Color.White)
            ) {
                contador("Hola mundo")
                Spacer(modifier = Modifier.height(16.dp))
                contador("Esta es una prueba")
            }
        }
        btn_accion()
    }
}
@Composable
fun imagen(){
    Image(painterResource(R.drawable.ic_launcher_foreground),
        "Icono launcher",
        modifier = Modifier
            .padding(end = 5.dp)
            .size(80.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary))
}
@Composable
fun btn_accion(){
    Button(onClick = {}
        , colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
        , modifier = Modifier
            .clip(CircleShape)
    ) {
        Text("Presióname")
    }
}
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun previsualizar2(){
    Jetcom1Theme() {
        saludo()
    }
}