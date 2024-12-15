package com.johny.trekclone.core.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material.icons.filled.CloudQueue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.johny.trekclone.R
import com.johny.trekclone.ui.theme.ForestGreen
import kotlinx.coroutines.delay


@Composable
fun NetworkStatus(
    modifier: Modifier = Modifier,
    isConnected: Boolean
) {
    var visibility by remember { mutableStateOf(false) }

    AnimatedVisibility(
        visible = visibility,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        ConnectionUi(isConnected = isConnected)
    }

    LaunchedEffect(isConnected) {
        visibility = if (!isConnected) {
            true
        } else {
            delay(3000)
            false
        }
    }

}


@Composable
fun ConnectionUi(isConnected: Boolean) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isConnected) ForestGreen else Color.Red,
        label = "network state color"
    )
    val message = if (isConnected) R.string.internet_available else R.string.internet_unavailable
    Box(
        modifier = Modifier
            .background(backgroundColor)
            .padding(5.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = if (isConnected) Icons.Default.CloudQueue else Icons.Default.CloudOff,
                contentDescription = null,
                tint = Color.White
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = stringResource(id = message),
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}


@PreviewLightDark
@Composable
fun ConnectionUiOnline() {
    ConnectionUi(isConnected = true)
}

@Preview
@Composable
fun ConnectionUiOffline() {
    ConnectionUi(isConnected = false)
}