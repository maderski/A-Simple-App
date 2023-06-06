package maderski.asimpleapp.userdirectory.presentation.userdetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import maderski.asimpleapp.userdirectory.presentation.common.component.PrimaryButtonComponent
import maderski.asimpleapp.userdirectory.presentation.common.content.ErrorMessageContent
import maderski.asimpleapp.userdirectory.presentation.common.content.LoadingContent
import maderski.asimpleapp.navigation.navigateToDestination
import maderski.asimpleapp.userdirectory.presentation.userdetails.UserDetailsScreenViewModel.*
import maderski.asimpleapp.userdirectory.presentation.userdetails.components.UserDetailsInfoComponent
import maderski.asimpleapp.userdirectory.presentation.userdetails.components.UserImageCircleComponent
import maderski.asimpleapp.userdirectory.presentation.userdetails.models.UserDetailsData
import maderski.asimpleapp.userdirectory.presentation.userdetails.models.ViewLocationClickedData

@Composable
fun UserDetailsScreen(
    userId: String?,
    viewModel: UserDetailsScreenViewModel = hiltViewModel(),
    navController: NavController
) {
    val screenState by viewModel.screenState.collectAsState()
    HandleScreenStates(state = screenState)

    val navEvent = viewModel.navEvent.collectAsState()
    LaunchedEffect(navEvent.value) {
        navEvent.navigateToDestination(navController)
    }

    viewModel.init(userId)
}

@Composable
private fun HandleScreenStates(state: UIState) {
    when (state) {
        UIState.Loading -> LoadingContent()
        is UIState.ShowingUserDetails -> UserDetailsScreenContent(
            data = state.userDetailsData
        )

        is UIState.ErrorOccurred -> ErrorMessageContent(message = state.message)
    }
}

@Composable
private fun UserDetailsScreenContent(
    modifier: Modifier = Modifier,
    data: UserDetailsData,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = modifier
                .weight(1f)
                .verticalScroll(rememberScrollState()),
        ) {
            Box(
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                UserImageCircleComponent(imageUrl = data.imageUrl)
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = data.name,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            UserDetailsInfoComponent(
                userName = data.userName,
                phone = data.phone,
                email = data.email,
                address = data.address,
                website = data.website,
                businessName = data.businessName,
                businessCatchPhrase = data.businessCatchPhrase,
                businessStrategy = data.businessStrategy
            )
        }
        Box(
            contentAlignment = Alignment.BottomCenter
        ) {
            PrimaryButtonComponent(
                text = data.viewLocationCTAText,
                isEnabled = data.isViewLocationCTAEnabled
            ) {
                data.onViewLocationClick.invoke(
                    ViewLocationClickedData(
                        data.userId,
                        data.businessName,
                        data.locationLat,
                        data.locationLng,
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserDetailsScreenContent() {
    UserDetailsScreenContent(
        data = UserDetailsData(
            userId = "1",
            userName = "JohnDoe123",
            name = "John Doe",
            phone = "867-5309",
            email = "johndoe@test.com",
            address = "Kulas Light Apt. 556, Gwenborough, 92998-3874",
            website = "hildegard.org",
            businessName = "Joe's Computer Repair",
            businessCatchPhrase = "Get er done!",
            businessStrategy = "Fix computers",
            imageUrl = null,
            locationLng = null,
            locationLat = null,
            isViewLocationCTAEnabled = true,
            viewLocationCTAText = "View on Map",
            onViewLocationClick = {}
        )
    )
}