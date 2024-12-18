package com.johny.trekclone.auth.onBoard.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.johny.trekclone.ui.theme.TrekCloneTheme
import com.johny.trekclone.ui.theme.colorPrimary

@Composable
fun Indicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {

    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { it ->
            val color by animateColorAsState(
                targetValue = if (it == pagerState.currentPage) colorPrimary else MaterialTheme.colorScheme.primary,
                label = "color animation"
            )
            val size by animateDpAsState(
                targetValue = if (it == pagerState.currentPage) 15.dp else 10.dp,
                label = "dimension animation"
            )


            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(size)
            )

        }

    }
}

@PreviewLightDark
@Composable
private fun IndicatorPreview() {
    TrekCloneTheme {
        val pagerState = rememberPagerState(pageCount = { 10 })
        Indicator(
            pagerState = pagerState
        )
    }
}