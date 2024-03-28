package com.example.a5046.presentation.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a5046.presentation.util.Screen
import com.example.a5046.ui.theme.ForestGreen
import com.example.a5046.ui.theme.SoftGreen
import com.example.a5046.ui.theme.WarmGreen
import com.example.a5046.ui.theme._5046Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen() {
    val emailAddress = remember { mutableStateOf("") }
    val password = remember {
        mutableStateOf("")
    }
    val datePickerState = rememberDatePickerState()
    var age: Int = 0
    var checkedSignUp = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Sign Up  \uD83C\uDF19",
                    modifier =
                    Modifier.padding(start = 16.dp),
                    color = ForestGreen,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )}
            )
        }
    ) { paddingValues ->
//    Box(modifier = Modifier
//        .fillMaxSize(),
//        contentAlignment = Alignment.Center)
//    {
        LazyColumn(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            item{
                Spacer(modifier = Modifier.size(20.dp))
            }
            item{
                Text(text = "Ready to join the fun? \nLet's get started! ",
                    fontSize = 15.sp, // Set the font size
                fontWeight = FontWeight.Bold,
                    color = ForestGreen)
            }
            item{
                Spacer(modifier = Modifier.size(20.dp))
            }
            item {
                Row(verticalAlignment = Alignment.CenterVertically){
                    Text(text = "User Name*      ",                    color = ForestGreen,
                        fontSize = 13.sp, // Set the font size
                        fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = emailAddress.value,
                        onValueChange = { emailAddress.value = it
                        },
                        label = { Text("User Name",
                            style = TextStyle(
                                color = ForestGreen,
                            )
                        ) },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = SoftGreen,
                            unfocusedBorderColor = ForestGreen
                        )
                    )
                }
            }
            item{
                Spacer(modifier = Modifier.size(10.dp))
            }
            item {
                Row(verticalAlignment = Alignment.CenterVertically){
                    Text(text = "Email Address* ",                    color = ForestGreen,
                        fontSize = 13.sp, // Set the font size
                        fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = emailAddress.value,
                        onValueChange = { emailAddress.value = it
                        },
                        label = { Text("Email Address",
                            style = TextStyle(
                                color = ForestGreen,
                            )
                        ) },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = SoftGreen,
                            unfocusedBorderColor = ForestGreen
                        )
                    )
                }
            }
            item{
                Spacer(modifier = Modifier.size(10.dp))
            }
            item{
                Row(verticalAlignment = Alignment.CenterVertically){
                    Text(text = "Password*        ",                    color = ForestGreen,
                        fontSize = 13.sp, // Set the font size
                        fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = password.value,
                        onValueChange = { password.value = it
                        },
                        label = { Text("Password",
                            style = TextStyle(
                                color = ForestGreen,
                            )
                        ) },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = SoftGreen,
                            unfocusedBorderColor = ForestGreen
                        )
                    )
                }
            }
            item{
                Spacer(modifier = Modifier.size(10.dp))
            }
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Date of Birth    ", color = ForestGreen,
                        fontSize = 13.sp, // Set the font size
                        fontWeight = FontWeight.Bold
                    )
                    OutlinedTextField(
                        value = password.value,
                        onValueChange = { password.value = it
                        },
                        label = { Text("01-01-1980",
                            style = TextStyle(
                                color = ForestGreen,
                            )
                        ) },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = SoftGreen,
                            unfocusedBorderColor = ForestGreen
                        )
                    )
//                DatePicker(state = datePickerState)
                }
            }
            item{
                Spacer(modifier = Modifier.size(10.dp))
            }
            item{
                Row(verticalAlignment = Alignment.CenterVertically){
                    Checkbox(
                        checked = checkedSignUp.value,
                        onCheckedChange = { isChecked -> checkedSignUp.value = isChecked }
                    )
                    Text("I agree with the terms and conditions.", style =
                    MaterialTheme.typography.bodyLarge, fontSize = 12.sp)
                }

            }
            item {
                FilledTonalButton(onClick = { }, colors = ButtonDefaults.buttonColors(containerColor = SoftGreen)) {
                    Text("Sign up", style =
                    MaterialTheme.typography.bodyLarge)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
//    _5046Theme {
        SignUpScreen()
//    }
}