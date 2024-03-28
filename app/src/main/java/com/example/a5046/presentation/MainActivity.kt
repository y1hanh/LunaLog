package com.example.a5046.presentation
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a5046.ui.theme._5046Theme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.a5046.R
import com.example.a5046.presentation.BottomNavigationBar.BottomNavigationBar
import com.example.a5046.presentation.diary.DiaryScreen
import com.example.a5046.presentation.settings.SettingsScreen
import com.example.a5046.ui.theme.ForestGreen
import com.example.a5046.ui.theme.LightGreen
import com.example.a5046.ui.theme.SoftGreen



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _5046Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    SettingsScreen()
//                    SignInScreen()
//                    DiaryScreen()
//                    ReportScreen()
//                    MainPageScreen()
                    BottomNavigationBar()
//                    SignUpScreen()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen() {
    val emailAddress = remember {mutableStateOf("")}
    val password = remember {
        mutableStateOf("")
    }
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Luna Log",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    color = ForestGreen,
                    fontSize = 20.sp, // Set the font size
                    fontWeight = FontWeight.Bold )// Set the text bold)
                        },
            )
        }
    ) { paddingValues ->
//         padding of the scaffold is enforced to be used
    Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center)
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Welcome!\uD83C\uDF19",
                    style = MaterialTheme.typography.headlineSmall,
                    color = LightGreen)
                Text(text = "Start your journey",
                    style = MaterialTheme.typography.headlineSmall,
                    color = SoftGreen)
                Text(text = "To Understand your body and mind",
                    style = MaterialTheme.typography.headlineSmall,
                    color = ForestGreen)

                Spacer(modifier = Modifier.size(40.dp))

                OutlinedTextField(
                    value = emailAddress.value,
                    onValueChange = { emailAddress.value = it
                    },
                    label = { Text("Email Address",
                        style = TextStyle(
                        color = ForestGreen,
                    )) },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = SoftGreen,
                        unfocusedBorderColor = ForestGreen
                    )
                )

                OutlinedTextField(
                    value = password.value,
                    onValueChange = { password.value = it
                    },
                    label = { Text("Password",
                        style = TextStyle(
                            color = ForestGreen,
                        )) },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = SoftGreen,
                        unfocusedBorderColor = ForestGreen
                    )
                )
                Spacer(modifier = Modifier.size(20.dp))

                Row {
                    FilledTonalButton(onClick = { }, colors = ButtonDefaults.buttonColors(containerColor = SoftGreen)) {
                        Text("Sign up", style =
                        MaterialTheme.typography.bodyLarge)
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    FilledTonalButton(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = ForestGreen)) {
                        Text("Log in", style =
                        MaterialTheme.typography.bodyLarge)
                    }
                }
                Row{
                    Image(
                        painter = painterResource(id = R.drawable.google_login),
                        contentDescription = "Google")
                }
                Spacer(modifier = Modifier.size(20.dp))
                Row{
                    Text(text = "Forget password?", color = SoftGreen)
                }

            }
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//
//    _5046Theme {
//        SignInScreen()
//    }
//}