package com.example.a5046.presentation.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a5046.ui.theme._5046Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp() {
    var emailAddress: String = ""
    var password: String = ""


    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center)
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Welcome!\uD83C\uDF19",
                style = MaterialTheme.typography.headlineSmall)
            Text(text = "Start your journey",
                style = MaterialTheme.typography.headlineSmall)
            Text(text = "To Understand your body and mind",
                style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.size(40.dp))

            OutlinedTextField(
                value = "",
                onValueChange = { emailAddress = it
                },
                label = { Text("Email Address") }
            )

            OutlinedTextField(
                value = "",
                onValueChange = { password = it
                },
                label = { Text("Password") }
            )
            Spacer(modifier = Modifier.size(20.dp))

            Row {
                FilledTonalButton(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF2BB83))) {
                    Text("Sign up", style =
                    MaterialTheme.typography.bodyLarge)
                }
                Spacer(modifier = Modifier.size(20.dp))
                FilledTonalButton(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFECB4FA))) {
                    Text("Log in", style =
                    MaterialTheme.typography.bodyLarge)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    _5046Theme {
        SignUp()
    }
}