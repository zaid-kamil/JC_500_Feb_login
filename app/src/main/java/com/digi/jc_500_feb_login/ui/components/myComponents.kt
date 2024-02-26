package com.digi.jc_500_feb_login.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.digi.jc_500_feb_login.ui.theme.JC_500_Feb_loginTheme

@Composable
fun UserInputField(
    modifier: Modifier = Modifier,
    label: String = "Email",
    icon: ImageVector = Icons.Default.Email,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    isFocused: Boolean = false,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = {
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier.padding(start = 24.dp)
            )
        },
        shape = MaterialTheme.shapes.extraLarge,
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Blue,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.Transparent,
        )
    )
}

@Composable
fun RoundedButton(
    modifier: Modifier = Modifier,
    text: String = "Log in",
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        modifier = modifier.width(150.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) Color.Yellow else Color.Blue,
            contentColor = if (isSystemInDarkTheme()) Color.Black else Color.White
        )
    ) {
        Text(text = text)
    }
}

@Composable
fun RectangularButton(
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.Refresh,
    text: String = "facebook",
    color: Color = Color.Blue,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.small,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = Color.White
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text)
    }
}

@Preview
@Composable
fun UserInputFieldPreview() {
    JC_500_Feb_loginTheme {
        UserInputField(isFocused = true)
    }
}

@Preview
@Composable
fun ButtonPreview() {
    RoundedButton(text = "Create")
}