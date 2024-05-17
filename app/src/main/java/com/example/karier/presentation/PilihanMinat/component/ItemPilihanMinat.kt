package com.example.karier.presentation.PilihanMinat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.karier.R
import com.example.karier.ui.theme.KarierTheme
import com.example.karier.ui.theme.PrimaryBlue400
import com.example.karier.ui.theme.TextPrimary

@Composable
fun ItemPilihanMinat(modifier: Modifier = Modifier, icon: ImageVector, text: String) {
    var checked by remember { mutableStateOf(true) }

    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(15.dp))
            .background(Color.White)
            .fillMaxWidth(), contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Icon",
                    modifier.padding(start = 8.dp, end = 8.dp),
                    tint = TextPrimary
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Black),
                    color = TextPrimary
                )
            }

            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                colors = CheckboxDefaults.colors(PrimaryBlue400)
            )
        }
    }
}

@Preview()
@Composable
fun Preview() {
    KarierTheme() {
        ItemPilihanMinat(
            icon = ImageVector.vectorResource(id = R.drawable.icon_designer),
            text = "Designer"
        )
    }
}