package com.group8.change

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import com.group8.change.api.DBApi
import com.group8.change.api.viewmodel.MainViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(mainActivity: com.group8.change.MainActivity, navController: NavController, viewModel: MainViewModel) {
    var usernameValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    fun changeLanguage(languageCode: String) {
        setLocale(mainActivity, languageCode)
        navController.navigate("login")
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.TopCenter
        ) {
            val image = painterResource(id = R.drawable.change_logo)
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(350.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .background(Color.White)
                .padding(10.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Spacer(modifier = Modifier.padding(15.dp))
                }
                item {
                    Text(
                        text = stringResource(id = R.string.login_buttontext),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 2.sp,
                            color = Color.DarkGray
                        ),
                        fontSize = 30.sp
                    )
                }

                item {
                    Spacer(modifier = Modifier.padding(10.dp))
                }

                item {
                    OutlinedTextField(
                        value = usernameValue,
                        onValueChange = { usernameValue = it },
                        label = { Text(text = stringResource(id = R.string.login_username)) },
                        placeholder = { Text(text = stringResource(id = R.string.login_username)) },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                }

                item {
                    OutlinedTextField(
                        value = passwordValue,
                        onValueChange = { passwordValue = it },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility.value = !passwordVisibility.value
                            }) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.password_eye),
                                    contentDescription = "password_eye",
                                    tint = if (passwordVisibility.value) Color.DarkGray else Color.Gray
                                )
                            }
                        },
                        label = { Text(text = stringResource(id = R.string.login_password)) },
                        placeholder = { Text(text = stringResource(id = R.string.login_password)) },
                        singleLine = true,
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                }

                item {
                    Button(
                        onClick = {
                            val user = DBApi.login(viewModel, usernameValue, passwordValue)
                            if (user != null) {
                                navController.navigate("main-menu")
                            } else {
                                Toast.makeText(mainActivity, "Invalid username or password.", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .padding(vertical = 16.dp),
                    ) {
                        Text(text = stringResource(id = R.string.login_buttontext))
                    }
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(vertical = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        val image1 = painterResource(id = R.drawable.united_kingdom)
                        val image2 = painterResource(id = R.drawable.sweden)
                        val image3 = painterResource(id = R.drawable.france)

                        Image(
                            painter = image1,
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp)
                                .align(Alignment.CenterVertically)
                                .clickable {
                                    changeLanguage("en")
                                }
                        )

                        Image(
                            painter = image2,
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp)
                                .align(Alignment.CenterVertically)
                                .clickable {
                                    changeLanguage("sv")
                                }
                        )

                        Image(
                            painter = image3,
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp)
                                .align(Alignment.CenterVertically)
                                .clickable {
                                    changeLanguage("fr")
                                }
                        )
                    }
                }
            }
        }
    }
}


