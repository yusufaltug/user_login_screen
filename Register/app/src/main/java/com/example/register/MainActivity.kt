package com.example.register

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.register.ui.theme.RegisterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegisterTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Register()
                }
            }
        }
    }
}
@Composable
fun Register(){
    val mail = remember { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        horizontalAlignment =Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(50.dp))
        Image(modifier = Modifier.size(200.dp),painter = painterResource(id = R.drawable.indir) , contentDescription = "kullanici foto")
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Register", fontSize = 50.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.DarkGray)) {
            Row {
                Icon(modifier = Modifier.size(40.dp),imageVector = Icons.Default.AccountCircle, contentDescription ="icon" )
                Spacer(modifier = Modifier.width(18.dp))

                Text(modifier = Modifier.padding(top = 5.dp),text = "Continue With Google", fontSize = 20.sp)
            }
        }
        Spacer(modifier = Modifier.size(30.dp))
        Text(text = "Or", fontSize = 20.sp)
        Spacer(modifier = Modifier.size(40.dp))
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(start = 30.dp),
            shape = RoundedCornerShape(topStart = 50.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally){
                Spacer(modifier = Modifier.height(50.dp))
                OutlinedTextField(
                    leadingIcon = { Icon(imageVector = Icons.Default.MailOutline, contentDescription ="1" ) },
                    modifier = Modifier.fillMaxWidth(),
                    value =mail.value ,
                    onValueChange = {mail.value=it},
                    placeholder = { Text(text = "Enter Mail", color = Color.Gray, fontWeight = FontWeight.Bold) },
                    colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.White, unfocusedBorderColor = Color.LightGray),
                    shape = RoundedCornerShape(15.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Continue", fontSize = 19.sp)
                }
                Spacer(modifier = Modifier.weight(1f))
                Row(modifier = Modifier.padding(bottom = 28.dp)) {
                    Text(text = "Already have an account?", fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Login", color = Color.Blue, fontSize = 18.sp, fontStyle = FontStyle.Italic)
                }
            }
        }
    }

}
@Preview
@Composable
fun PreviewColumnYapisi(){
    Register()
}