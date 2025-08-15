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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mmk.kmpauth.firebase.google.GoogleButtonUiContainerFirebase
import org.rg.auth.component.GoogleButton
import org.rg.shared.Alpha
import org.rg.shared.BebasNeueFont
import org.rg.shared.FontSize
import rememberMessageBarState

@Composable
fun AuthScreen()
{
    var messageBarState = rememberMessageBarState()
    var loadingState by remember { mutableStateOf(false) }

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
                GoogleButtonUiContainerFirebase(
                    linkAccount = false,
                    onResult = {result ->

                        loadingState = false
                        result.onSuccess { user ->

                            messageBarState.addSuccess("Authentecation Successful")


                        }.onFailure {error->

                            if(error.message?.contains("A network error") == true){
                                messageBarState.addSuccess("A network error")
                            }
                            else if(error.message?.contains("Idtoken is null") ==  true){
                                messageBarState.addSuccess("Idtoken is null")
                            }
                            else{
                                messageBarState.addError(error.message ?: "Unknown")
                            }
                            loadingState = false



                        }

                    }
                ){
                    GoogleButton(loading = loadingState, onClick = {
                        loadingState = true
                        this@GoogleButtonUiContainerFirebase.onClick()

                    }
                    )
                }



            }

        }
    }
}