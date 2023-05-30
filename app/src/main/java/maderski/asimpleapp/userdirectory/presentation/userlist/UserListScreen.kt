package maderski.asimpleapp.userdirectory.presentation.userlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import maderski.asimpleapp.common.component.LogoComponent
import maderski.asimpleapp.userdirectory.presentation.userlist.components.UserCardListComponent
import maderski.asimpleapp.userdirectory.presentation.userlist.models.UserCardData
import maderski.asimpleapp.userdirectory.presentation.userlist.models.UserListScreenData

@Composable
fun UserListScreen(
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
fun PreviewUserListScreen() {
    UserListScreen(
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