package com.example.settingsscreen

import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.podcastssetting.R
import java.util.Calendar


@Composable
fun WeatherScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorAccent))

    ) {
        Text(
            text = " ",
        )
    }
}
@Preview
@Composable
fun WeatherScreenPreview() {
    WeatherScreen()
}

@Composable
fun RadioScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorAccent))

    ) {
        Text(
            text = "",
        )
    }
}
@Preview
@Composable
fun RadioScreenPreview() {
    RadioScreen()
}

@Composable
fun RosaryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorAccent))

    ) {
        Text(
            text = "",
        )
    }
}
@Preview
@Composable
fun RosaryScreenPreview() {
    RosaryScreen()
}


@Composable
fun PodCastsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorAccent))
    ) {
        Text(
            text = "",
        )
    }
}
@Preview
@Composable
fun PodCastsScreenPreview() {
    PodCastsScreen()
}

@Composable
fun SettingsScreen() {
    var isSwitchChecked1 by remember { mutableStateOf(true) }
    var isSwitchChecked2 by remember { mutableStateOf(true) }
    var isSwitchChecked3 by remember { mutableStateOf(false) }
    val mContext = LocalContext.current
    val mCalendar = Calendar.getInstance()
    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
    val mMinute = mCalendar[Calendar.MINUTE]
    val mTime = remember { mutableStateOf("") }
    val mTimePickerDialog = TimePickerDialog(
        mContext,
        {_, mHour : Int, mMinute: Int ->
            mTime.value = "$mHour:$mMinute"
        }, mHour, mMinute, false
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorAccent))
    ) {
        Text(
            "SETTINGS", fontSize = 30.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp,
            modifier = Modifier
                .padding(start = 10.dp, top = 50.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp,end=15.dp,bottom=350.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Cyan)
        ) {

            Row(
                modifier = Modifier
                    .padding(top=10.dp,start = 10.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Play stream when app starts", fontSize = 16.sp,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.width(80.dp))
                Switch(
                    checked = isSwitchChecked1,
                    onCheckedChange = { isChecked ->
                        isSwitchChecked1 = isChecked
                    }
                )
            }
            Row(
                modifier = Modifier
                    .padding(top=65.dp,start = 10.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Reconnect if connection lost", fontSize = 16.sp,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.width(80.dp))
                Switch(
                    checked = isSwitchChecked2,
                    onCheckedChange = { isChecked ->
                        isSwitchChecked2 = isChecked
                    }
                )
            }
            Text(
                "Alarm Clock", fontSize = 20.sp,
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp,top=150.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top=170.dp,start = 10.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Wakeup to convenient Radio", fontSize = 16.sp,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.width(80.dp))
                Switch(
                    checked = isSwitchChecked3,
                    onCheckedChange = { isChecked ->
                        isSwitchChecked3 = isChecked
                    }
                )
            }
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .padding(top=210.dp,start = 170.dp,end=15.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "6:00  am", fontSize = 20.sp,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.width(22.dp))
                Button(
                    onClick = {
                        mTimePickerDialog.show()
                    }, modifier = Modifier
                        .height(30.dp)
                        .width(55.dp)
                ) {
                    Text("Edit", fontSize = 10.sp)
                }
                //Text(text = "Selected Time: ${mTime.value}", fontSize = 16.sp)
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}
