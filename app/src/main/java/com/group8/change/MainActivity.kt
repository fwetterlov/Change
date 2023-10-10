package com.group8.change

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
//import com.group8.change.api.GetUsers
import com.group8.change.ui.design.TopAppBar
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.group8.change.api.DBApi.MyScreen
import com.group8.change.api.viewmodel.MainViewModel
import com.group8.change.components.QuestionWithTextField
import com.group8.change.expectations.ExpectationsScreen
import com.group8.change.expectations.viewmodel.ExpectationsViewModel
import com.group8.change.ui.design.TopAppBar
import com.group8.change.ui.design.TopAppBarPlus
import com.group8.change.ui.theme.ChangeTheme
import java.util.Locale

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    val expectationsViewModel: ExpectationsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /* language code should be taken from the login screen
            *  Can setLocale be called from the login button? */
            val languageCode = "en"
            setLocale(this, languageCode)
            val navController = rememberNavController()



            ChangeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "login") {
                        composable("login"){ LoginScreen(this@MainActivity, navController) }
                        composable("main-menu"){ MainScreen(modifier = Modifier, navController) }
                    }
//MyScreen(viewModel)

                    // TopAppBarPlus syntax
//                    TopAppBarPlus(
//                        content = {
//                            Structure(
//                                "short",
//                                "loooooooooooooooooooooooooooong",
//                                "adeagagda",
//                                "wow",
//                                "SUUUIII"
//                            )
//                        },
//                        title = "Main Screen",
//                        secondButton = {buttonComposable()}
//                    )
                }
                //Greeting("Android")
                //GetUsers(viewModel)
            }
        }
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