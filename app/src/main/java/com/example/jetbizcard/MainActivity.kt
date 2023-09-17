package com.example.jetbizcard

import android.graphics.Paint.Style
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateBizCard()

            }
        }
    }

@Composable
fun CreateBizCard() {
    val buttonClikedState=remember{

        mutableStateOf(false)

    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()){(
            Card(
            modifier = Modifier
                .padding(12.dp)
                .width(200.dp)
                .height(390.dp),
            backgroundColor = Color.White,
            elevation =4.dp,//ظل
            shape = RoundedCornerShape(corner = CornerSize(15.dp))) {
                Column(
                    modifier = Modifier.height(300.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CreateImageProfile()
                    Divider(color = Color.Black, thickness = 1.dp)
                    CreateInfo()
                    Button(onClick = { /*Log.d("Clicked","Clicked!!") */
                             buttonClikedState.value=!buttonClikedState.value
                        }) {
                        Text(text = "Protfolio", style =MaterialTheme.typography.button )
                    }
                    if(buttonClikedState.value){
                        Content()
                    }else{
                        Box(){

                        }
                    }

                }
            }
      )}}

@Preview
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)){
         Surface(modifier = Modifier
             .padding(3.dp)
             .fillMaxHeight()
             .fillMaxWidth(),
             shape = RoundedCornerShape(corner = CornerSize(6.dp)),
             border = BorderStroke(width = 2.dp, color = Color.LightGray)){
                 Protfolio(data= listOf("Project 1","Project 2","Project 3","Project 4","Project 5"))
         }
    }

}

@Composable
fun Protfolio(data:List<String>) {
   LazyColumn {
       items(data){
           item ->
           Card(
               Modifier
                   .padding(13.dp)
                   .fillMaxWidth(), shape = RectangleShape, elevation = 4.dp) {
               Row(
                   Modifier
                       .padding(8.dp)
                       .background(MaterialTheme.colors.surface)
                       .padding(7.dp)) {
                       CreateImageProfile(modifier =Modifier.size(50.dp) )
                       Column(modifier = Modifier
                           .padding(7.dp)
                           .align(Alignment.CenterVertically)) {
                           Text(text = item, fontWeight = FontWeight.Bold)
                           Text("A greate Project", style = MaterialTheme.typography.body2)
                       }
               }
           }
       }
   }

}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(6.dp)) {
        Text(
            text = "Miles.P", style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "Android Compose Programmer",
            Modifier.padding(3.dp), style = MaterialTheme.typography.subtitle1
        )
        Text(text = "@themilesCompose")

    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier=Modifier) {
    Surface(
        Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.Black),
        elevation = 4.dp,
        color = Color.White
    )
    {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "m",
            Modifier.size(170.dp),
            contentScale = ContentScale.Crop
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
        CreateBizCard()

}






