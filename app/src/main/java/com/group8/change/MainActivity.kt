package com.group8.change

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.group8.change.ui.design.topAppBar
import com.group8.change.api.viewmodel.MainViewModel
import com.group8.change.ui.theme.ChangeTheme
import java.util.Locale

import com.group8.change.api.GetUsers

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /* language code should be taken from the login screen
            *  Can setLocale be called from the login button? */
            val languageCode = "en"
            setLocale(this, languageCode)

            ChangeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    topAppBar {
                        Structure(
                            "short",
                            "loooooooooooooooooooooooooooong",
                            "adeagagda",
                            "wow",
                            "SUUUIII"
                        )
                    }
                    //Greeting("Android")
                    //GetUsers(viewModel)
                }
            }
        }
    }
}

// Composable for the home screen buttons
@Composable
fun CardClickable(text: String, modifier: Modifier = Modifier) {
    Card(
        // Defining how the cards look
        modifier = Modifier
            .padding(20.dp)
            .width(130.dp)
            .height(130.dp),
        border = BorderStroke(2.dp, Color.Green)
    ) {
        Box(
            // Centers the contents
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                // Text look and text alignment
                text = text,
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

// Composable building the home screen
@Composable
fun Structure(
    text1: String,
    text2: String,
    text3: String,
    text4: String,
    text5: String,
    modifier: Modifier = Modifier
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Row(
            Modifier.align(Alignment.Center)
        ) {
            Column {
                CardClickable(
                    text = text1
                )
                CardClickable(
                    text = text3
                    )
            }
            Column {
                CardClickable(
                    text = text2
                    )
                CardClickable(
                    text = text4
                    )
            }
        }
        Row(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 100.dp)
        ) {
            // Add your elements for the new row here
            CardClickable(
                text = text5
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StructurePreview() {
    ChangeTheme {
        topAppBar {
            Structure(
                "short",
                "loooooooooooooooooooooooooooong",
                "adeagagda",
                "wow",
                "SUUUIII"
            )
        }
    }
}


private fun setLocale(context: Context, languageCode: String) {
    val locale = Locale(languageCode)
    Locale.setDefault(locale)

    val config = Configuration()
    config.locale = locale
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
}