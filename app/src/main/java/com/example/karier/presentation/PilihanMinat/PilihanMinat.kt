package com.example.karier.presentation.PilihanMinat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.karier.R
import com.example.karier.presentation.PilihanMinat.component.ItemPilihanMinat
import com.example.karier.presentation.component.KarierButton
import com.example.karier.presentation.component.TopBar
import com.example.karier.ui.theme.KarierTheme
import com.example.karier.ui.theme.SecondaryBackground
import com.example.karier.ui.theme.TextPrimary
import com.example.karier.ui.theme.TextSecondary

@Composable
fun PilihanMinatScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit
) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopBar(title = "", navigateBack = navigateBack, backButton = true)
        }
    ) { paddingValues ->
        Column(modifier = modifier
            .verticalScroll(scrollState)
            .padding(paddingValues)) {
            Column(modifier = Modifier.padding(start = 26.dp, top = 16.dp, end = 100.dp)) {
                Text(
                    text = "Minat apa yang Anda cari?",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
                    color = TextPrimary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Pilih 2-4 kategori minat dan mulai cari lowongan untuk anda",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Normal),
                    color = TextSecondary
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Box(modifier = Modifier.fillMaxSize()) {
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 2.dp
                    ),
                    colors = CardDefaults.cardColors(SecondaryBackground),
                    shape = RoundedCornerShape(24.dp, 24.dp),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                        modifier = Modifier.padding(horizontal = 22.dp, vertical = 52.dp)
                    ) {
                        ItemPilihanMinat(
                            icon = ImageVector.vectorResource(id = R.drawable.icon_designer),
                            text = "Designer"
                        )
                        ItemPilihanMinat(
                            icon = ImageVector.vectorResource(id = R.drawable.icon_marketing),
                            text = "Marketing"
                        )
                        ItemPilihanMinat(
                            icon = ImageVector.vectorResource(id = R.drawable.icon_content_marketing),
                            text = "Content Marketing"
                        )
                        ItemPilihanMinat(
                            icon = ImageVector.vectorResource(id = R.drawable.icon_designer2),
                            text = "Designer"
                        )
                        ItemPilihanMinat(
                            icon = ImageVector.vectorResource(id = R.drawable.icon_designer3),
                            text = "Designer"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        KarierButton(
                            text = {
                                Text(
                                    modifier = Modifier.padding(vertical = 8.dp),
                                    text = "Lanjutkan",
                                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
                                )
                            },
                            onClick = { /*TODO*/ },
                            varOutline = "",
                            isWide = true
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    KarierTheme {
        PilihanMinatScreen(navigateBack = {})
    }
}