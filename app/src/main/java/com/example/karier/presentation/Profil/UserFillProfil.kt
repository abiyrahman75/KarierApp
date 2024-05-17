package com.example.karier.presentation.Profil

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.karier.R
import com.example.karier.presentation.component.KarierButton
import com.example.karier.presentation.component.KarierInputText
import com.example.karier.presentation.component.TopBar
import com.example.karier.ui.theme.KarierTheme
import com.example.karier.ui.theme.SecondaryBackground

@Composable
fun UserFillProfileScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit
) {

    var namadepan by remember { mutableStateOf("") }
    var namabelakang by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noTelepon by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopBar(
                title = "Isi Profil Anda",
                navigateBack = navigateBack,
                backButton = true,
                isFilled = true
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Spacer(modifier = Modifier.height(16.dp))
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.icon_profile),
                contentDescription = ""
            )
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                colors = CardDefaults.cardColors(SecondaryBackground),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    modifier = modifier.padding(horizontal = 12.dp, vertical = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    KarierInputText(
                        value = namadepan,
                        onValueChange = { namadepan = it },
                        label = "Nama Depan",
                        enable = true,
                        isObsecure = false,
                        maxLines = 1
                    )
                    KarierInputText(
                        value = namabelakang,
                        onValueChange = { namabelakang = it },
                        label = "Nama Belakang",
                        enable = true,
                        isObsecure = false,
                        maxLines = 1
                    )
                    KarierInputText(
                        value = tanggalLahir,
                        onValueChange = { tanggalLahir = it },
                        label = "Tanggal Lahir",
                        enable = true,
                        isObsecure = false,
                        maxLines = 1
                    )
                    KarierInputText(
                        value = email,
                        onValueChange = { email = it },
                        label = "Email",
                        enable = true,
                        isObsecure = false,
                        maxLines = 1
                    )
                    KarierInputText(
                        value = noTelepon,
                        onValueChange = { noTelepon = it },
                        label = "No. Telepon",
                        enable = true,
                        isObsecure = false,
                        maxLines = 1
                    )
                    KarierInputText(
                        value = jenisKelamin,
                        onValueChange = { jenisKelamin = it },
                        label = "Jenis Kelamin",
                        enable = true,
                        isObsecure = false,
                        maxLines = 1
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
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
private fun Preview() {
    KarierTheme {
        UserFillProfileScreen(navigateBack = {})
    }
}