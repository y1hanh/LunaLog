package com.example.a5046.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.tooling.preview.Preview


//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            FormEntry()
//        }
//    }
//}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormEntry() {
    val states =
        listOf("22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35")
    var isExpanded by remember { mutableStateOf(false) }
    var selectedState by remember { mutableStateOf(states[0]) }

    Box(
        modifier = Modifier
            .padding(80.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .fillMaxWidth()
        ) {
            Text(
                text = "How long is your average cycle length?",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "This information will help us make more accurate predictions.",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(35.dp)) // Add space between text and dropdown menu

            Row(verticalAlignment = Alignment.CenterVertically) {
                ExposedDropdownMenuBox(
                    expanded = isExpanded,
                    onExpandedChange = { isExpanded = it },
                    modifier = Modifier.weight(1f)
                ) {
                    TextField(
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth()
                            .focusProperties {
                                canFocus = false
                            }
                            .padding(bottom = 8.dp),
                        readOnly = true,
                        value = selectedState,
                        onValueChange = {},
                        //manages the arrow icon up and down
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                        },
                    )
                    ExposedDropdownMenu(
                        expanded = isExpanded,
                        onDismissRequest = { isExpanded = false }
                    )
                    {
                        states.forEach { selectionOption ->
                            DropdownMenuItem(
                                text = { Text(selectionOption) },
                                onClick = {
                                    selectedState = selectionOption
                                    isExpanded = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                            )
                        }
                    }
                }

                Text(
                    text = "days",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(18.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Skip",
                modifier = Modifier.weight(1f),
            )

            Button(
                onClick = { /* Handle Next button click */ },
                modifier = Modifier
                    .padding(16.dp)
                    .height(48.dp)
                    .width(120.dp),
                contentPadding = PaddingValues(12.dp)
            ) {
                Text(
                    text = "Next"
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewFormEntry() {
    FormEntry()
}
