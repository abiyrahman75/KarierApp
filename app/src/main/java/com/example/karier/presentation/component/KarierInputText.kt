package com.example.karier.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.karier.R
import com.example.karier.ui.theme.ContainerDisable
import com.example.karier.ui.theme.ContainerPrimary
import com.example.karier.ui.theme.KarierTheme
import com.example.karier.ui.theme.Outline
import com.example.karier.ui.theme.OutlineFocused
import com.example.karier.ui.theme.TextDisable
import com.example.karier.ui.theme.TextPrimary
import com.example.karier.ui.theme.TextSecondary

@Composable
fun KarierInputText(
    modifier: Modifier = Modifier,
    label: String = "",
    icon: ImageVector? = null,
    value: String,
    placeholder: String = "",
    onValueChange: (String) -> Unit = {},
    enable: Boolean = true,
    readOnly: Boolean = false,
    isObsecure: Boolean? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    minLines: Int = 1,
    maxLines: Int = 3,
    isError: Boolean = false,
    required: Boolean = false,
) {
    var isShowPassword by remember { mutableStateOf(false) }

    Column(modifier) {
        if (label.isNotEmpty()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                icon?.let {
                    Icon(
                        imageVector = icon,
                        tint = TextPrimary,
                        contentDescription = stringResource(
                            id = R.string.label, label
                        )
                    )
                }
                Text(text = label, style = MaterialTheme.typography.labelMedium, color = TextSecondary)
                if (required){
                    Text(text = "*", color = Color.Red)
                }
            }
        }
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .align(Alignment.CenterHorizontally),
            colors =
            OutlinedTextFieldDefaults.colors(
                focusedBorderColor = OutlineFocused,
                unfocusedBorderColor = Outline,
                focusedLabelColor = OutlineFocused,
                cursorColor = Outline,
                unfocusedContainerColor = ContainerPrimary,
                focusedContainerColor = ContainerPrimary,
                disabledContainerColor = ContainerDisable,
                disabledTextColor = TextDisable,
                focusedTextColor = TextPrimary
            ),
            textStyle = MaterialTheme.typography.labelMedium,
            enabled = enable,
            readOnly = readOnly,
            shape = RoundedCornerShape(26.dp),
            placeholder = {
                Text(
                    text = placeholder
                )
            },
            trailingIcon = {
                if (isObsecure != null && isObsecure) {
                    IconButton(onClick = { isShowPassword = !isShowPassword }) {
                        Icon(
                            painter = painterResource(id = if (!isShowPassword) R.drawable.visible else R.drawable.visible_off),
                            contentDescription = stringResource(id = R.string.is_show_password)
                        )

                    }
                }
            },
            visualTransformation = if (isObsecure != null && isObsecure) {
                if (isShowPassword) VisualTransformation.None else PasswordVisualTransformation()
            } else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            maxLines = maxLines,
            minLines = minLines,
            isError = isError,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun KarierInputTextPreview() {
    var text by remember {
        mutableStateOf("")
    }
    KarierTheme {
        KarierInputText(
            value = text,
            onValueChange = {text = it},
            label = "Oke",
            enable = true,
            isObsecure = false,
            icon = ImageVector.vectorResource(id = R.drawable.visible),
            maxLines = 1,
            required = true
        )
    }
}