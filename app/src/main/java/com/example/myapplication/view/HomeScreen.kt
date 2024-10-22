package com.example.myapplication.view

import android.annotation.SuppressLint
import android.service.carrier.MessagePdu
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.Pink40
import com.example.myapplication.ui.theme.Purple40


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { TopAppBar({Text("")}) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {

            Row{
                Text("Sweety's Picks")
            }
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                items(5){ item ->
                    CustomItemButton()
                }
            }


        }
    }

}

@Composable
fun CustomItemButton(
    modifier: Modifier = Modifier,
    arrangement: Arrangement.HorizontalOrVertical = Arrangement.SpaceEvenly
){

    val brush = Brush.horizontalGradient(listOf(Purple40, Pink40))
    val image = painterResource(R.drawable.donuts)

    Box(modifier = Modifier
        .size(175.dp)
        .clip(shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
        .shadow(elevation = 1.dp, shape = RoundedCornerShape(15.dp))
    ){
        Column() {
            Row {
                Canvas(
                    modifier = Modifier.fillMaxWidth().size(90.dp),
                    onDraw = {
                        drawRect(brush)
                    }
                )
            }
            Column(
                Modifier.fillMaxHeight().padding(10.dp),
                Arrangement.Bottom
            ) {
                Text("Donut", color = Color.Black)
                Text("A tag line", color = Color.Gray)
            }
        }

        Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CustomImage(image, modifier.fillMaxSize().align(Alignment.Center))
        }

    }



}

@Composable
fun CustomImage(
    itemImage: Painter,
    modifier: Modifier = Modifier
){
    Image(
        painter = itemImage,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Gray, CircleShape)
    )
}




@Composable
@Preview(showSystemUi = true)
fun HomeScreenPreview(){
    HomeScreen()
}