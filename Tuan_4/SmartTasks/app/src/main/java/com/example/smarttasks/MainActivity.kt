package com.example.smarttasks

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.smarttasks.ui.theme.SmartTasksTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartTasksTheme {
                ForgotPasswordFlow()
            }
        }
    }
}

@Composable
fun LogoHeader() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), // Place logo.png in res/drawable
            contentDescription = "UTH Logo",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text("SmartTasks", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ForgotPasswordFlow() {
    val context = LocalContext.current
    var step by remember { mutableStateOf(0) }
    var email by remember { mutableStateOf("") }
    var code by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("SmartTasks") })
        },
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            when (step) {
                0 -> {
                    LogoHeader()
                    Text("🔐 Forgot Password", style = MaterialTheme.typography.headlineSmall)
                    Text("Enter your email. We’ll send you a verification code.")
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(
                        onClick = {
                            if (email.isNotBlank() &&
                                android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
                            ) {
                                step++
                            } else {
                                Toast.makeText(context, "Invalid email address", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Next")
                    }
                }

                1 -> {
                    LogoHeader()
                    Text("📩 Verify Code", style = MaterialTheme.typography.headlineSmall)
                    Text("Enter the code we sent to your registered email.")
                    OutlinedTextField(
                        value = code,
                        onValueChange = { code = it },
                        label = { Text("Verification Code") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(
                        onClick = {
                            if (code.isNotBlank()) {
                                step++
                            } else {
                                Toast.makeText(context, "Please enter the verification code", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Next")
                    }
                }

                2 -> {
                    LogoHeader()
                    Text("🔑 Create New Password", style = MaterialTheme.typography.headlineSmall)
                    Text("Enter and confirm your new password.")
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        label = { Text("Confirm Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(
                        onClick = {
                            if (password.length >= 6 && password == confirmPassword) {
                                step++
                            } else {
                                Toast.makeText(
                                    context,
                                    "Password must be at least 6 characters and match",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Next")
                    }
                }

                3 -> {
                    LogoHeader()
                    Text("✅ Confirm", style = MaterialTheme.typography.headlineSmall)
                    Text("We’ve sent the new password to your email:")
                    Text(email, style = MaterialTheme.typography.bodyLarge)

                    OutlinedTextField(
                        value = password,
                        onValueChange = {},
                        label = { Text("New Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        enabled = false,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Button(onClick = { /* Submit logic */ }, modifier = Modifier.fillMaxWidth()) {
                        Text("Submit")
                    }
                }
            }
        }
    }
}