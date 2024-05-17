package com.example.karier.presentation.component

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EventAvailable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.karier.ui.theme.KarierTheme
import com.example.karier.ui.theme.OnPrimaryBlue
import com.example.karier.ui.theme.PrimaryBlue400

@Composable
fun outlineButton(variant: String): ButtonColors {

    val button = if (variant == "isOutline") {
        ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = PrimaryBlue400
        )
    } else {
        ButtonDefaults.buttonColors(
            containerColor = PrimaryBlue400,
            contentColor = OnPrimaryBlue
        )
    }
    return button
}

@Composable
fun KarierButton(
//    colors: ButtonColors,
    text: @Composable RowScope.() -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable RowScope.() -> Unit = {},
    trailingIcon: @Composable RowScope.() -> Unit = {},
    varOutline: String,
    isWide: Boolean = false,
) {
    Button(
        onClick = onClick,
        modifier =
        if (isWide)
            modifier
                .fillMaxWidth()
        else modifier,
        colors = outlineButton(variant = varOutline),
        border = BorderStroke(1.dp, PrimaryBlue400),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier
        ) {
            leadingIcon()
            text()
            trailingIcon()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevButton() {
    KarierTheme {
        KarierButton(
            text = {
                Text(
                    text = "Dokumen",
                    style = MaterialTheme.typography.labelLarge.copy(fontStyle = FontStyle.Normal)
                )
            },
            onClick = { /*TODO*/ },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.EventAvailable,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 8.dp)
                )
            },
            varOutline = "isOutline",
            isWide = true
        )
    }
}