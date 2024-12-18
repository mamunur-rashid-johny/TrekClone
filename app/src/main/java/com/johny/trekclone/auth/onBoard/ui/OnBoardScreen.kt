package com.johny.trekclone.auth.onBoard.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.johny.trekclone.auth.onBoard.data.OnBoardDataSource
import com.johny.trekclone.ui.theme.TrekCloneTheme

@Composable
fun OnBoardScreen(modifier: Modifier = Modifier) {

    val onBoardItems = OnBoardDataSource.onBoardDataSource
    val pagerState = rememberPagerState(pageCount = { onBoardItems.size })

    val constrainSet = ConstraintSet {

        val pagerRef = createRefFor("pagerRef")
        val indicatorRef = createRefFor("indicatorRef")
        val buttonRef = createRefFor("buttonRef")

        constrain(pagerRef) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(indicatorRef.top)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }


        constrain(indicatorRef) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(buttonRef.top)
            width = Dimension.fillToConstraints
            height = Dimension.value(60.dp)
        }

        constrain(buttonRef) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }
    }

    ConstraintLayout(constrainSet, modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .layoutId("pagerRef")
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                OnBoardItem(
                    onBoardModel = onBoardItems[page]
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .layoutId("indicatorRef")
        ) {

            Indicator(
                modifier = Modifier.fillMaxSize(),
                pagerState = pagerState
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .layoutId("buttonRef")
        ) {
            AuthButton(
                modifier = Modifier.fillMaxSize(),
                onLogin = {},
                onSignup = {}
            )
        }


    }
}


@Preview
@Composable
private fun OnBoardScreenPreview() {
    TrekCloneTheme {
        OnBoardScreen()
    }
}