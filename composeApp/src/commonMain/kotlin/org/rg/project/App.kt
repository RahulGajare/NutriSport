package org.rg.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.rg.navigation.SetupNavGraph


@Composable
fun App()
{
    MaterialTheme{
        SetupNavGraph()
    }
}