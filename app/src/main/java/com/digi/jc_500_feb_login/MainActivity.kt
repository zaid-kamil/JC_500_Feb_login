package com.digi.jc_500_feb_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.digi.jc_500_feb_login.ui.components.RectangularButton
import com.digi.jc_500_feb_login.ui.components.RoundedButton
import com.digi.jc_500_feb_login.ui.components.UserInputField
import com.digi.jc_500_feb_login.ui.theme.JC_500_Feb_loginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_500_Feb_loginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary.copy(alpha = .9f),
                        MaterialTheme.colorScheme.primary.copy(alpha = .1f),
                    )
                )
            )
            .padding(24.dp)
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Image(
            painter = painterResource(id = R.drawable.login_hero),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        Text(
            text = "Welcome back!",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = "Log in to your existing account of Q Allure",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = .5f)
        )
        Spacer(modifier = Modifier.height(24.dp))

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        UserInputField(
            modifier = Modifier.fillMaxWidth(), onValueChange = { email = it }, value = email
        )
        Spacer(modifier = Modifier.height(16.dp))
        UserInputField(
            modifier = Modifier.fillMaxWidth(),
            label = "Password",
            icon = Icons.Default.Lock,
            onValueChange = { password = it },
            value = password
        )
        Row(
            horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Forgot Password?",
                modifier = Modifier.padding(vertical = 12.dp),
                color = Color.Black.copy(alpha = .8f),
                fontWeight = FontWeight.Bold
            )
        }
        RoundedButton(
            modifier = Modifier
                .height(50.dp)
                .width(180.dp),

            ) {
            // handle action
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Or connect using",
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = .4f),
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            RectangularButton(
                onClick = {},
                color = Color.Blue
            )
            RectangularButton(
                color = Color.Red,
                icon = Icons.Default.Lock,
                text = "Google",
            ) {}
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Don't have an account? Sign up",
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = .8f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    JC_500_Feb_loginTheme {
        LoginScreen()
    }
}