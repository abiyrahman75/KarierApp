package com.example.karier.presentation.Dashboard.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.karier.R
import com.example.karier.ui.theme.KarierTheme
import com.example.karier.ui.theme.PrimaryBlue200
import com.example.karier.ui.theme.PrimaryBlue300
import com.example.karier.ui.theme.PrimaryBlue400
import com.example.karier.ui.theme.SecondaryBackground

@Composable
fun ItemRecomendation(modifier: Modifier = Modifier) {
    Card(
        shape = CardDefaults.elevatedShape,
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .wrapContentSize()
            .height(120.dp)
            .padding(end = 4.dp)
            .clip(RoundedCornerShape(4.dp)),
        colors = CardDefaults.cardColors(SecondaryBackground)
    ) {
        val image =
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pramborsfm.com%2Flifestyle%2F45-kosakata-bahasa-jepang-yang-sering-digunakan-di-anime-lengkap-dengan-arti&psig=AOvVaw3EwjL1Qo4YIMRZTlPQyYMh&ust=1716034043822000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPjqyo7TlIYDFQAAAAAdAAAAABAE"
        Column {
            Row(
                modifier = modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = image,
                    contentDescription = "",
                    modifier = modifier
                        .clip(RoundedCornerShape(10.dp))
                        .wrapContentHeight()
                        .background(Color.Gray)
                        .weight(1f)
                )
                Column(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxHeight()
                        .padding(start = 10.dp),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Marketing Manager",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
                    )
                    Text(
                        text = "PT. Sangkala Jaya Abadi",
                        style = MaterialTheme.typography.labelSmall
                    )
                    Row(
                        verticalAlignment = Alignment.Top,
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_location),
                            modifier = Modifier.size(15.dp),
                            contentDescription = ""
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Samarinda Seberang, Samarinda Kalimantan Timur",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
                        )
                    }
                }
                Card(
                    modifier = modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp)),
                    colors = CardDefaults.cardColors(PrimaryBlue300.copy(alpha = 0.25f)),
                ) {
                    Column(
                        modifier = modifier
                            .padding(5.dp)
                            .align(Alignment.CenterHorizontally),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = ImageVector
                                .vectorResource(id = R.drawable.ic_schedule),
                            modifier = modifier.size(30.dp),
                            contentDescription = ""
                        )
                        Text(
                            text = "Full Time",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }
    }
}

@Preview()
@Composable
private fun ItemRecomendationPreview() {
    KarierTheme {
        ItemRecomendation()
    }
}