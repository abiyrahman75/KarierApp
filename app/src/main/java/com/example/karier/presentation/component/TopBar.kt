package com.example.karier.presentation.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.karier.R
import com.example.karier.ui.theme.PrimaryBlue300
import com.example.karier.ui.theme.PrimaryBlue400
import com.example.karier.ui.theme.TextPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String,
    navigateBack: () -> Unit = {},
    backButton: Boolean = false,
    isFilled: Boolean = false
) {
    CenterAlignedTopAppBar(
        modifier = modifier.clip(RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)),
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
                color = TextPrimary,
            )
        },
        navigationIcon = {
            if (backButton) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.navigate_back),
                    modifier = modifier.padding(20.dp),
                )
            }
        },
        colors = if (isFilled) {
            TopAppBarDefaults.topAppBarColors(containerColor = PrimaryBlue300)
        } else TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
    )
}

@Preview
@Composable
private fun TopBarPreview() {
    TopBar(title = "Daftar", backButton = true)
}