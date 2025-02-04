package com.example.c1moviles.drogstore.home.presentations

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddComment
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Preview
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.c1moviles.drogstore.home.HomeViewModel
import kotlin.reflect.typeOf

@Composable
fun FormResource(productosViewModel: ProductosViewModel, navController: NavController){
    val nombre:String by productosViewModel.nombre.observeAsState("")
    val precio:Float by productosViewModel.precio.observeAsState(0f)
    val cantidad:Int by productosViewModel.cantidad.observeAsState(0)
    val receta:String by productosViewModel.receta.observeAsState("")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(30.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {navController.navigate("home")}
        ) {
            Text("X")
        }
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "Publicar un producto",
            fontSize = 30.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = nombre,
            onValueChange = { productosViewModel.onChangeNombre(it)},
            label = { Text("Nombre del producto") },
            shape = RoundedCornerShape(10.dp),
            placeholder = { Text("") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Person Icon") },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 10.dp)
                .border(0.6.dp, color = Color.Black)
        )

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = precio.toString(),
            onValueChange = { newValue ->
                // Validar que sea un número decimal válido
                if (newValue.matches(Regex("^\\d*\\.?\\d*$"))) {
                    productosViewModel.onChangePrecio(
                        newValue.toFloatOrNull() ?: 0f
                    )
                }
            },
            label = { Text("Precio del producto") },
            shape = RoundedCornerShape(10.dp),
            placeholder = { Text("Ej: 9.99") },
            leadingIcon = { Icon(Icons.Default.AttachMoney, contentDescription = "precioIcon") },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 10.dp)
                .border(0.6.dp, color = Color.Black),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Done
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = cantidad.toString(),
            onValueChange = { newValue ->
                // Filtrar solo dígitos y actualizar el ViewModel
                if (newValue.matches(Regex("^\\d*$"))) {
                    productosViewModel.onChangeCantidad(newValue.toIntOrNull() ?: 0)
                }
            },
            label = { Text("Cantidad") },
            shape = RoundedCornerShape(10.dp),
            placeholder = { Text("1 ...") },
            leadingIcon = { Icon(Icons.Default.Numbers, contentDescription = "cantidad") },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 10.dp)
                .border(0.6.dp, color = Color.Black),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number // Teclado numérico
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = receta,
            onValueChange = {productosViewModel.onChangeReceta(it)},
            label = { Text("Receta") },
            shape = RoundedCornerShape(10.dp),
            placeholder = { Text("Si necesita receta / No") },
            leadingIcon = { Icon(Icons.Default.Comment, contentDescription = "receta") },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 10.dp)
                .border(0.6.dp, color = Color.Black)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 10.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(text = "Agregar +",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ViewProductos(){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(30.dp)
            .padding(vertical = 30.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center
    ) {
        repeat(3) {
            Producto(nombre = "Alprazolam 0.25mg 30 tabletas", precio = 19.99f, cantidad = 3, receta = "Si, por supuesto")
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}
@Composable
fun Producto(nombre: String, precio: Float, cantidad: Int, receta: String) {
    Row(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .border(2.dp, Color.Gray)
            .padding(3.dp)
            .graphicsLayer {
                shadowElevation = 19.dp.toPx()
                shape = RectangleShape
                clip = true
            }
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(text = "$nombre", color = Color.Blue, fontWeight = FontWeight.Bold)
            Text(text = "$"+precio, color = Color.Gray)
            Text(text = "Cantidad: $cantidad", color = Color.Gray)
            Text(text = "Receta: $receta", color = Color.Gray)
        }

        Icon(
            imageVector = Icons.Default.Preview,
            contentDescription = "Producto",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .height(50.dp)
                .width(50.dp)
        )
    }
}