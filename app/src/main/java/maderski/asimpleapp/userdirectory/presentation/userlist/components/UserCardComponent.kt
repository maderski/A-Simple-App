package maderski.asimpleapp.userdirectory.presentation.userlist.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import maderski.asimpleapp.R
import maderski.asimpleapp.userdirectory.presentation.common.component.UrlImageWithDefaultComponent
import maderski.asimpleapp.userdirectory.presentation.userlist.models.UserCardData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserCardComponent(
    modifier: Modifier = Modifier,
    data: UserCardData,
) {
    Card(
        modifier = modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        onClick = { data.onClick.invoke(data.id) },
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            UrlImageWithDefaultComponent(
               modifier = Modifier
                   .width(140.dp)
                   .padding(8.dp),
                imageUrl = data.imageUrl,
                defaultImage = R.drawable.user_placeholder
            )
            Column() {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = data.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = data.companyName,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserCardComponent() {
    UserCardComponent(
        data = UserCardData(
            id = 1,
            name = "John Doe",
            companyName = "Create Stuff, Inc.",
            imageUrl = null,
            onClick = {},
        )
    )
}