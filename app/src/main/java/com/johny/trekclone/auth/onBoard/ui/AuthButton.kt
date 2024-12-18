package com.johny.trekclone.auth.onBoard.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.johny.trekclone.R
import com.johny.trekclone.ui.theme.SpaceMono
import com.johny.trekclone.ui.theme.TrekCloneTheme
import com.johny.trekclone.ui.theme.colorPrimary

@Composable
fun AuthButton(
    modifier: Modifier = Modifier,
    onLogin: () -> Unit,
    onSignup: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = colorPrimary),
            shape = RoundedCornerShape(40.dp),
            onClick = {
                onSignup()
            }) {
            Text(
                text = stringResource(R.string.sign_up),
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = SpaceMono,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            )
        }

        Spacer(modifier = Modifier.size(20.dp))

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(40.dp),
            border = BorderStroke(width = 1.dp, color = colorPrimary),
            onClick = {
                onLogin()
            }) {
            Text(
                text = stringResource(R.string.login),
                color = colorPrimary,
                fontSize = 16.sp,
                fontFamily = SpaceMono,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            )
        }

    }
}


@PreviewLightDark
@Composable
private fun AuthButtonPreview() {
    TrekCloneTheme {
        AuthButton(
            onSignup = {},
            onLogin = {}
        )
    }

}