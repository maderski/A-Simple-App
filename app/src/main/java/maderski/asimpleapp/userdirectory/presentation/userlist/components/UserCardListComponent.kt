package maderski.asimpleapp.userdirectory.presentation.userlist.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import maderski.asimpleapp.userdirectory.presentation.userlist.models.UserCardData

@Composable
fun UserCardListComponent(
    modifier: Modifier = Modifier,
    cardDataList: List<UserCardData>,
) {
    LazyColumn(modifier = modifier) {
        items(cardDataList) { userCardData ->
            UserCardComponent(data = userCardData)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserCardListComponent() {
    UserCardListComponent(cardDataList = listOf(
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
    ))
}