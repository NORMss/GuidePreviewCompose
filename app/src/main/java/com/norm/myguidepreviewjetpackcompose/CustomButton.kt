package com.norm.myguidepreviewjetpackcompose

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.tooling.LocalInspectionTables

import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.tooling.preview.PreviewParameter

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.norm.myguidepreviewjetpackcompose.ui.theme.MyGuidePreviewJetpackComposeTheme

@Composable
fun CustomButton(
    title: String,
    isOutline: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (isOutline) {
        OutlinedButton(
            onClick = onClick,
            shape = RectangleShape,
            contentPadding = PaddingValues(16.dp),
            modifier = modifier,
            border = BorderStroke(
                width =
                if (LocalInspectionMode.current) 3.dp
                else 1.dp,
                color = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = title
            )
        }
    } else {
        Button(
            onClick = onClick,
            shape = RectangleShape,
            contentPadding = PaddingValues(16.dp),
            modifier = modifier
        ) {
            Text(
                text = title
            )
        }
    }
}

//for the preview to work, you need apiLevel = 33
// relevant for "androidx.compose:compose-bom:2024.02.00"
@Preview(
    apiLevel = 33,
//    widthDp = 256,
//    heightDp = 64,
//    showSystemUi = true,
//    locale = "ru",
//    fontScale = 2f,
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    device = Devices.PIXEL_TABLET
)
@Composable
fun CustomButtonPreview() {
    MyGuidePreviewJetpackComposeTheme {
        CustomButton(
            title = "Hello, World!",
            isOutline = false,
            onClick = { }
        )
    }
}

class OutlineParameterProvider() : PreviewParameterProvider<Boolean> {
    override val values: Sequence<Boolean>
        get() = sequenceOf(false, true)
}

@Preview(
    apiLevel = 33,
)
//@PreviewScreenSizes
//@PreviewFontScale
//@PreviewLightDark
//@PreviewDynamicColors

@Composable
fun CustomOutlinedPreview(
    @PreviewParameter(OutlineParameterProvider::class) isOutline: Boolean
) {
    MyGuidePreviewJetpackComposeTheme {
        CustomButton(
            title = "Hello, World!",
            isOutline = isOutline,
            onClick = { }
        )
    }
}