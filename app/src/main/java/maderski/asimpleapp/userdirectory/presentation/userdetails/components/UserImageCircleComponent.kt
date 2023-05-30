package maderski.asimpleapp.userdirectory.presentation.userdetails.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import maderski.asimpleapp.R
import maderski.asimpleapp.common.component.UrlImageWithDefaultComponent

@Composable
fun UserImageCircleComponent(
    modifier: Modifier = Modifier,
    imageUrl: String?,
) {
    Card(
        modifier = Modifier.size(150.dp),
        shape = CircleShape,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 12.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentAlignment = Alignment.Center,
        ) {
            UrlImageWithDefaultComponent(
                modifier = modifier,
                imageUrl = imageUrl,
                defaultImage = R.drawable.user_placeholder
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserImageCircleComponent() {
    UserImageCircleComponent(imageUrl = null)
}