package maderski.asimpleapp.common.component

import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import maderski.asimpleapp.R

@Composable
fun UrlImageWithDefaultComponent(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    @DrawableRes defaultImage: Int,
) {
    if (imageUrl != null) {
        AsyncImage(
            modifier = modifier,
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
    } else {
        val context = LocalContext.current
        Image(
            modifier = modifier,
            bitmap = BitmapFactory.decodeResource(
                context.resources,
                defaultImage
            ).asImageBitmap(),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUrlImageWithDefaultComponentShowingDefault() {
    UrlImageWithDefaultComponent(imageUrl = null, defaultImage = R.drawable.user_placeholder)
}