package maderski.asimpleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import maderski.asimpleapp.navigation.Navigation
import maderski.asimpleapp.ui.theme.ASimpleAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                /*
                 We don't need to observe this since setKeepOnScreenCondition is evaluated
                 before each request to draw the application, so it needs to be fast to avoid
                 blocking the UI.
                */
                viewModel.isAppStarting.value
            }
        }
        setContent {
            ASimpleAppTheme {
                Navigation()
            }
        }
    }
}