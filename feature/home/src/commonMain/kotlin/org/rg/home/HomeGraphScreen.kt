package org.rg.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.rg.home.component.BottomBar
import org.rg.home.domain.BottomBarDestination

@Composable
fun HomeGraphScreen() {

    Scaffold { padding ->
        Column(modifier = Modifier.padding(top = padding.calculateTopPadding(),
            bottom = padding.calculateBottomPadding())
            .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            BottomBar(
                selectedDestination = BottomBarDestination.ProductsOverview,
                onSelect = {
                    //TODO
                }
            )

        }
    }
}