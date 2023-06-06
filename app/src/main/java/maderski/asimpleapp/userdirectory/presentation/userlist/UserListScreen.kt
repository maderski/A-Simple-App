package maderski.asimpleapp.userdirectory.presentation.userlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import maderski.asimpleapp.navigation.navigateToDestination
import maderski.asimpleapp.userdirectory.presentation.common.component.LogoComponent
import maderski.asimpleapp.userdirectory.presentation.common.content.ErrorMessageContent
import maderski.asimpleapp.userdirectory.presentation.common.content.LoadingContent
import maderski.asimpleapp.userdirectory.presentation.userlist.UserListScreenViewModel.*
import maderski.asimpleapp.userdirectory.presentation.userlist.components.UserCardListComponent
import maderski.asimpleapp.userdirectory.presentation.userlist.models.UserCardData
import maderski.asimpleapp.userdirectory.presentation.userlist.models.UserListScreenData

@Composable
fun UserListScreen(
    viewModel: UserListScreenViewModel = hiltViewModel(),
    navController: NavController
) {
    val screenState by viewModel.screenState.collectAsState()
    HandleScreenStates(state = screenState)

    val navEvent = viewModel.navEvent.collectAsState()
    LaunchedEffect(navEvent.value) {
        navEvent.navigateToDestination(navController)
    }
}

@Composable
private fun HandleScreenStates(state: UIState) {
    when (state) {
        UIState.Loading -> LoadingContent()
        is UIState.ShowingUserList -> UserListScreenContent(
            data = UserListScreenData(state.cardListData)
        )

        is UIState.ErrorOccurred -> ErrorMessageContent(message = state.message)
    }
}

@Composable
private fun UserListScreenContent(
    modifier: Modifier = Modifier,
    data: UserListScreenData,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LogoComponent()
        UserCardListComponent(cardDataList = data.cardListData)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserListScreenContent() {
    UserListScreenContent(
        data = UserListScreenData(
            cardListData = listOf(
                UserCardData(
                    id = 1,
                    name = "John Doe",
                    companyName = "Create Stuff, Inc.",
                    imageUrl = null,
                    onClick = {},
                ),
                UserCardData(
                    id = 2,
                    name = "John Doe 2",
                    companyName = "Create Stuff, Inc.",
                    imageUrl = null,
                    onClick = {},
                ),
                UserCardData(
                    id = 3,
                    name = "John Doe 3",
                    companyName = "Create Stuff, Inc.",
                    imageUrl = null,
                    onClick = {},
                ),
                UserCardData(
                    id = 4,
                    name = "John Doe 4",
                    companyName = "Create Stuff, Inc.",
                    imageUrl = null,
                    onClick = {},
                ),
                UserCardData(
                    id = 5,
                    name = "John Doe 5",
                    companyName = "Create Stuff, Inc.",
                    imageUrl = null,
                    onClick = {},
                )
            )
        )
    )
}