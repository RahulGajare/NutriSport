package org.rg.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.mmk.kmpauth.google.GoogleAuthCredentials
import com.mmk.kmpauth.google.GoogleAuthProvider
import org.rg.navigation.SetupNavGraph
import org.rg.shared.Constants


@Composable
fun App()
{
    var appReady by remember { mutableStateOf(false) }
    MaterialTheme{
        LaunchedEffect(Unit){
            GoogleAuthProvider.create(credentials = GoogleAuthCredentials(serverId = Constants.WEB_CLIENT_ID))
            appReady = true
        }

        AnimatedVisibility(
            modifier = Modifier.fillMaxSize(),
            visible =  appReady
        ){
            SetupNavGraph()
        }

    }
}