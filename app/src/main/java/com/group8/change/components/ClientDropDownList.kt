package com.group8.change.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


/*
    More functions to be created once backend is in place.
    1. Function that returns all Clients that a therapist has
    2. Function that runs method in step 1 and then calls CreateDropDownList

 */

@Composable
fun CreateDropDownList(clients: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedClient by remember { mutableStateOf("Select a client") }

    Box ( modifier = Modifier.padding(12.dp),
          ){
        Text(text = selectedClient,
            modifier = Modifier.clickable { expanded = true })
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            clients.forEach { client ->
                DropdownMenuItem(
                    text = { Text(text = client) },
                    onClick = {
                        selectedClient = client
                        expanded = false
                    })
            }
        }
    }
}