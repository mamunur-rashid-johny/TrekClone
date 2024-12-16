package com.johny.trekclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.johny.trekclone.core.presentation.components.NetworkStatus
import com.johny.trekclone.ui.theme.TrekCloneTheme
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    private var isSplashScreenShown = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                isSplashScreenShown
            }
        }
        enableEdgeToEdge()
        setContent {
            TrekCloneTheme {
                val viewModel = koinViewModel<MainViewModel>()
                val state by viewModel.isConnected.collectAsStateWithLifecycle()
                val isLoading by viewModel.isLoading.collectAsState()
                isSplashScreenShown = isLoading
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {

                        NetworkStatus(
                            modifier = Modifier.align(Alignment.TopCenter),
                            isConnected = state
                        )

                        Greeting(
                            name = "Android",
                            modifier = Modifier.align(Alignment.Center)
                        )

                    }


                }
            }
        }
    }
}




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        style = MaterialTheme.typography.headlineLarge
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TrekCloneTheme {
        Greeting("Android")
    }
}