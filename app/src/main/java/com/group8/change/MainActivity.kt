package com.group8.change

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.group8.change.api.viewmodel.MainViewModel
import com.group8.change.ui.design.TopAppBar
import com.group8.change.ui.design.TopAppBarPlus
import com.group8.change.ui.theme.ChangeTheme
import java.util.Locale

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
                    // TopAppBar syntax
                    TopAppBar(
                        content = {
                            Structure(
                                stringResource(id = R.string.card_title_reflections),
                                stringResource(id = R.string.card_title_expectations),
                                stringResource(id = R.string.card_title_morning_evaluation),
                                stringResource(id = R.string.card_title_evening_evaluation),
                                stringResource(id = R.string.card_title_monthly_evaluation)
                            )
                        },
                        title = "Main Screen"
                    )

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


@Preview(showBackground = true)
@Composable
fun MainPreview() {
    ChangeTheme {
        TopAppBar(
            content = {
                Structure(
                    stringResource(id = R.string.card_title_expectations),
                    stringResource(id = R.string.card_title_expectations),
                    stringResource(id = R.string.card_title_morning_evaluation),
                    stringResource(id = R.string.card_title_evening_evaluation),
                    stringResource(id = R.string.card_title_monthly_evaluation)
                )
            },
            title = "Main Screen"
        )
    }
}


private fun setLocale(context: Context, languageCode: String) {
    val locale = Locale(languageCode)
    Locale.setDefault(locale)

    val config = Configuration()
    config.locale = locale
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
}