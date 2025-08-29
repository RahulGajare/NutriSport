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
import org.koin.compose.koinInject
import org.rg.data.domain.CustomerRepository
import org.rg.navigation.SetupNavGraph
import org.rg.shared.Constants
import org.rg.shared.navigation.Screen


@Composable
fun App()
{
    var appReady by remember { mutableStateOf(false) }
    val customerRepository = koinInject<CustomerRepository>()
    val isUserAuthenticated = remember { customerRepository.getCurrentUserId() != null }
    val startDestination = remember {
        if (isUserAuthenticated) Screen.HomeGraph
        else Screen.AuthScreen
    }
    MaterialTheme{
        LaunchedEffect(Unit){
            GoogleAuthProvider.create(credentials = GoogleAuthCredentials(serverId = Constants.WEB_CLIENT_ID))
            appReady = true
        }

        AnimatedVisibility(
            modifier = Modifier.fillMaxSize(),
            visible =  appReady
        ){
            SetupNavGraph(startDestination = startDestination)
        }

    }
}