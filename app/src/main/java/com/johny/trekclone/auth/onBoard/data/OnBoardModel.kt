package com.johny.trekclone.auth.onBoard.data

import androidx.annotation.RawRes
import androidx.annotation.StringRes

data class OnBoardModel(
    @StringRes val title:Int,
    @StringRes val description:Int,
    @RawRes val animFile:Int
)
