package com.group8.change.components


import android.util.Log
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
import com.group8.change.api.DBApi
import com.group8.change.api.models.CurrentAppData
import com.group8.change.api.models.CurrentUser
import com.group8.change.api.viewmodel.MainViewModel


/*
    More functions to be created once backend is in place.
    1. Function that returns all Clients that a therapist has
    2. Function that runs method in step 1 and then calls CreateDropDownList

 */

@Composable
fun CreateDropDownList(viewModel: MainViewModel) {
    var expanded by remember { mutableStateOf(false) }
    var selectedClient by remember { mutableStateOf("Select a client") }
    if(CurrentAppData.data.client.username != "cli1"){
        selectedClient = CurrentAppData.data.client.username
    }

    var currentUser = CurrentUser.data.username.toString()

    val clientList = getClientList(currentUser)

    Box ( modifier = Modifier.padding(12.dp),
          ){
        Text(text = selectedClient,
            modifier = Modifier.clickable { expanded = true })
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            clientList.forEach { client ->
                DropdownMenuItem(
                    text = { Text(text = client) },
                    onClick = {
                        Log.d("allData","${CurrentAppData.allData}")
                        selectedClient = client
                        DBApi.setCurrentAppData(viewModel, selectedClient)
                        Log.d("clientData","${CurrentAppData.data}")
                        expanded = false
                    })
            }
        }
    }
}


fun getClientList(therapist: String): List<String> {
    val currentAppData = CurrentAppData.allData
    val clientList = mutableListOf<String>()

    for (data in currentAppData) {
        if(data.therapist.username == therapist){
            clientList.add(data.client.username)
        }
    }

    return clientList;
}