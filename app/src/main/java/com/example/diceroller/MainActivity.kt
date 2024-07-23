package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            DiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    DiceRollerTheme {
        DiceWithButtonAndImage(
            Modifier
                .fillMaxSize()
                .wrapContentSize()
        )
    }
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
   var result by remember { mutableStateOf(1) }
    val image = when(result){
        1-> R.drawable.dice_1
        2-> R.drawable.dice_2
        3-> R.drawable.dice_3
        4-> R.drawable.dice_4
        5-> R.drawable.dice_5
        else-> R.drawable.dice_6
    }
    Column(
        modifier = modifier
        .padding(0.dp,40.dp,0.dp,0.dp),
       horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
          text = "DICE ROLLER",
            textDecoration = TextDecoration.Underline,
            fontSize = 32.sp,
            color = Color.LightGray,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)

        )
        Spacer(modifier = Modifier.height(200.dp))
            Image(
                painter = painterResource(image),
                contentDescription = result.toString()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { result = (1..6).random()},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2F2C85),
                )
            )
            {
                  Text(stringResource(R.string.roll), fontSize = 20.sp, color = Color(0xFFF305B0), fontFamily = FontFamily.SansSerif)
            }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text ="\"Click on the roll button to roll the dice\"",
            fontSize = 20.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Cyan
        )
    }

}



