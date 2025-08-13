package org.rg.auth

import ContentWithMessageBar
import Surface
import TextPrimary
import TextSecondary
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.rg.auth.component.GoogleButton
import org.rg.shared.Alpha
import org.rg.shared.BebasNeueFont
import org.rg.shared.FontSize
import rememberMessageBarState

@Composable
fun AuthScreen()
{
    var messageBarState = rememberMessageBarState()
    Scaffold { padding ->

        ContentWithMessageBar(
            contentBackgroundColor = Surface,
            modifier = Modifier
                .padding(top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding()),

            messageBarState = messageBarState,
            errorMaxLines = 2

        ){
            Column(modifier = Modifier.fillMaxSize()
                .padding(all = 24.dp)) {
                Column(modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "NUTRISPORT",
                        textAlign = TextAlign.Center,
                        fontFamily = BebasNeueFont(),
                        fontSize = FontSize.EXTRA_LARGE,
                        color = TextSecondary
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth()
                            .alpha(Alpha.HALF),
                        text = "Sign in to Continue",
                        textAlign = TextAlign.Center,
                        fontSize = FontSize.EXTRA_REGULAR,
                        color = TextPrimary
                    )

                }

                GoogleButton(loading = true, onClick = {}
                )

            }

        }
    }
}