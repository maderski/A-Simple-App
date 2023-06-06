package maderski.asimpleapp.userdirectory.presentation.common.component

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import maderski.asimpleapp.R

@Composable
fun LogoComponent(
    modifier: Modifier = Modifier,
    logoHeight: Dp = 50.dp,
    logoWidth: Dp = 50.dp,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        val context = LocalContext.current
        Text(
            modifier = Modifier.padding(8.dp),
            text = context.getString(R.string.app_name),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Image(
            modifier = Modifier
                .height(logoHeight)
                .width(logoWidth),
            bitmap = BitmapFactory.decodeResource(
                context.resources,
                R.drawable.rocket
            ).asImageBitmap(),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogoComponent() {
    LogoComponent()
}