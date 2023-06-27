package maderski.asimpleapp.userdirectory.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import maderski.asimpleapp.userdirectory.navigation.Navigation
import maderski.asimpleapp.userdirectory.presentation.ui.theme.ASimpleAppTheme

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