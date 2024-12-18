package com.johny.trekclone.core.presentation.utils

import android.content.Context
import com.johny.trekclone.R
import com.johny.trekclone.core.domain.utils.NetworkError

fun NetworkError.toString(context: Context):String{
     val resId = when(this){
        NetworkError.REQUEST_TIMEOUT -> R.string.error_request_timeout
        NetworkError.TOO_MANY_REQUEST -> R.string.error_too_many_request
        NetworkError.NO_INTERNET_ERROR -> R.string.error_no_internet
        NetworkError.SERVER_ERROR -> R.string.error_unknown
        NetworkError.SERIALIZATION_ERROR -> R.string.error_serialize
        NetworkError.UNKNOWN_ERROR -> R.string.error_unknown
    }
    return context.getString(resId)
}