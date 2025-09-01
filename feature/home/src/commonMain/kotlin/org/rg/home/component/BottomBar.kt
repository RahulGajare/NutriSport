package org.rg.home.component

import Resources
import SurfaceLighter
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.rg.home.domain.BottomBarDestination

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    selectedDestination : BottomBarDestination,
    onSelect : (BottomBarDestination) -> Unit
)
{
    Row(modifier = modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(size = 12.dp)).
        background(SurfaceLighter),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
        )
    {
        BottomBarDestination.entries.forEach { destination ->
            Box(){
                Icon(modifier = Modifier.
                    clickable{
                        onSelect(destination)
                    },
                    painter = painterResource(destination.icon),
                    contentDescription = "Destination Icon"
                )


            }
        }
    }

}