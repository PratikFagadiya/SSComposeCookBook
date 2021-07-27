package com.jetpack.compose.learning.navigationdrawer

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class NavigationDrawerTypesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerTypes()
        }
    }

    @Preview
    @Composable
    @OptIn(ExperimentalMaterialApi::class)
    fun NavigationDrawerTypes(){
        val spaceHeight = 24.dp
        Column {
            TopAppBar(
                title = { Text("Navigation Drawer") },
                navigationIcon = {
                    IconButton(onClick = { onBackPressed() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
            Column(Modifier.padding(20.dp)) {
                Text(text = "Navigation Drawer Types : ", style = MaterialTheme.typography.h6)
                Spacer(Modifier.requiredHeight(spaceHeight))
                NavigationItems(
                    navigationType = "Modal Drawer Sample",
                    intent = Intent(applicationContext, ModalDrawerActivity::class.java)
                )
                Spacer(Modifier.requiredHeight(spaceHeight))
                NavigationItems(
                    navigationType = "Bottom Drawer Sample",
                    intent = Intent(applicationContext, BottomDrawerActivity::class.java)
                )
            }
        }
    }

    @Composable
    @OptIn(ExperimentalMaterialApi::class)
    fun NavigationItems(navigationType : String, intent: Intent){
        val context= LocalContext.current
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, Color.LightGray),
            elevation = 5.dp,
            onClick = {
                context.startActivity(intent)
            },
            indication = rememberRipple()
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(navigationType, Modifier.weight(1f), fontSize = 16.sp)
                Icon(Icons.Default.KeyboardArrowRight, "", Modifier.size(24.dp))
            }
        }
    }

}