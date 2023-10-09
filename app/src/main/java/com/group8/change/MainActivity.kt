package com.group8.change

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
<<<<<<< Updated upstream
=======
import android.util.Log
>>>>>>> Stashed changes
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
<<<<<<< Updated upstream
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
=======
import androidx.compose.ui.tooling.preview.Preview
import com.group8.change.api.GetUsers
import com.group8.change.api.viewmodel.MainViewModel
import com.group8.change.ui.design.TopAppBar
>>>>>>> Stashed changes
import com.group8.change.ui.theme.ChangeTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
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
                    Greeting("Android")
                }
<<<<<<< Updated upstream
=======
                //Greeting("Android")
                //GetUsers(viewModel)
                //LoginScreen(this)
>>>>>>> Stashed changes
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.card_title_reflections),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChangeTheme {
        Greeting("Android")
    }
}


fun setLocale(context: Context, languageCode: String) {
    Log.d("langCode", languageCode)
    val locale = Locale(languageCode)
    Locale.setDefault(locale)

    val config = Configuration()
    config.locale = locale
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
}