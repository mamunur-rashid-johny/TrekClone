package com.johny.trekclone.auth.onBoard.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.johny.trekclone.auth.onBoard.data.OnBoardDataSource
import com.johny.trekclone.auth.onBoard.data.OnBoardModel
import com.johny.trekclone.ui.theme.TrekCloneTheme

@Composable
fun OnBoardItem(
    modifier: Modifier = Modifier,
    onBoardModel: OnBoardModel
) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(onBoardModel.animFile))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {
        LottieAnimation(
            composition = composition,
            progress = { progress },
            alignment = Alignment.Center,
            modifier = Modifier.size(400.dp)
        )

        Text(
            text = stringResource(onBoardModel.title),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.headlineMedium.copy(fontSize = 20.sp),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(onBoardModel.description),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
            color = MaterialTheme.colorScheme.secondary
        )

    }


}


@PreviewLightDark
@Composable
private fun OnBoardItemPreview() {
    TrekCloneTheme {
        OnBoardItem(
            modifier = Modifier.fillMaxSize(),
            onBoardModel = onBoard
        )
    }
}

internal val onBoard = OnBoardDataSource.onBoardDataSource[2]