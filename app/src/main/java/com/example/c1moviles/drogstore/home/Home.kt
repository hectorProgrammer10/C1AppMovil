package com.example.c1moviles.drogstore.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.c1moviles.R
import com.example.c1moviles.drogstore.home.presentations.FormResource
import com.example.c1moviles.drogstore.home.presentations.ProductosViewModel

@Composable
fun Home(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(30.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Reemplazar el Text con una Image
        Image(
            painter = painterResource(id = R.drawable.siahorro), // Asegúrate de que la imagen esté en res/drawable
            contentDescription = "Logo Si Ahorro", // Descripción accesible
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp) // Ajusta la altura según el tamaño de la imagen
                .padding(bottom = 16.dp), // Espaciado inferior
            contentScale = ContentScale.Fit // Escala la imagen para que quepa dentro del espacio
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    shadowElevation = 9.dp.toPx()
                    shape = CircleShape
                    clip = true
                },
            onClick = {
                navController.navigate("addProducto")
            }
        ) {
            Text("Añadir producto", color = Color.White, fontWeight = FontWeight.Bold)
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    shadowElevation = 9.dp.toPx()
                    shape = CircleShape
                    clip = true
                },
            onClick = { navController.navigate("viewProducto") }
        ) {
            Text("Ver productos", color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}