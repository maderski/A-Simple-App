package maderski.asimpleapp.userdirectory.presentation.userlist.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import maderski.asimpleapp.userdirectory.presentation.userlist.models.UserCardData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserCardComponent(
    modifier: Modifier = Modifier,
    data: UserCardData,
) {
    Card(
        modifier = modifier
            .height(240.dp)
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        onClick = { data.onClick.invoke(data.id) },
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
//        colors = CardDefaults.cardColors(containerColor = )
    ) {

    }
}