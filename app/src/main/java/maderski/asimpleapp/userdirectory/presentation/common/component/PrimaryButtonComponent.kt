package maderski.asimpleapp.userdirectory.presentation.common.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PrimaryButtonComponent(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
        onClick = onClick,
        enabled = isEnabled,
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            color = Color.White,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPrimaryButtonComponent() {
    PrimaryButtonComponent(
        text = "View on Map",
        isEnabled = true,
        onClick = {},
    )
}