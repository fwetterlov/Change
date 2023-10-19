package com.group8.change

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.group8.change.api.viewmodel.MainViewModel
import com.group8.change.evaluations.EveningEvaluationScreen
import com.group8.change.evaluations.MonthlyEvaluationScreen
import com.group8.change.evaluations.MorningEvaluationScreen
import com.group8.change.evaluations.eveningEvaluation
import com.group8.change.evaluations.eveningEvaluationTherapist
import com.group8.change.evaluations.monthEvaluation
import com.group8.change.evaluations.monthlyEvaluationTherapist
import com.group8.change.evaluations.morningEvaluation
import com.group8.change.evaluations.morningEvaluationTherapist
import com.group8.change.expectations.ExpectationsScreen
import com.group8.change.expectations.ExpectationsTherapist
import com.group8.change.expectations.viewmodel.ExpectationsViewModel
import com.group8.change.reflections.ReflectionScreen
import com.group8.change.reflections.ReflectionScreenTherapist
import com.group8.change.selfassessment.SelfAssessmentScreen
import com.group8.change.ui.design.LinearGradient
import com.group8.change.ui.design.TopAppBar
import java.util.Locale

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchUserData()
        setContent {
            val expectationsViewModel = ExpectationsViewModel(this@MainActivity)
            
            /* language code should be taken from the login screen
            *  Can setLocale be called from the login button? */
            val languageCode = "en"
            setLocale(this, languageCode)
            val navController = rememberNavController()



            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LinearGradient()
                    NavHost(navController = navController, startDestination = "login") {
                        composable("login"){ LoginScreen(this@MainActivity, navController, viewModel) }
                        composable("main-menu"){
                            expectationsViewModel.createExpectationsQuestions()
                            MainScreen(modifier = Modifier, navController, viewModel)
                        }
                        composable("reflections"){
                            ReflectionScreen(navController)
                        }
                        composable("expectations"){
                            ExpectationsScreen(navController, expectationsViewModel)
                        }
                        composable("morning"){
                            MorningEvaluationScreen(navController)
                        }
                        composable("evening"){
                            EveningEvaluationScreen(navController)
                        }
                        composable("monthly"){
                            MonthlyEvaluationScreen(navController)
                        }
                        composable("self-assessment"){
                            SelfAssessmentScreen(navController)
                        }
                        composable("reflections-th"){
                            ReflectionScreenTherapist(navController)
                        }
                        composable("morning-th"){
                            morningEvaluationTherapist(navController)
                        }
                        composable("evening-th"){
                            eveningEvaluationTherapist(navController)
                        }
                        composable("monthly-th"){
                            monthlyEvaluationTherapist(navController)
                        }
                        composable("self-assessment-th"){
                            ReflectionScreenTherapist(navController)
                        }

                    }
                }
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