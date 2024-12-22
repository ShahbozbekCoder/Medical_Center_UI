package uz.shahbozbek.medicalcenterui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginAccountPage(navController: NavController) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    val checked = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
            .padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.arrow_back),
                contentDescription = "Back",
                modifier = Modifier
                    .clickable {
                        navController.popBackStack()
                    }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(R.drawable.main_logo),
            contentDescription = "Main logo",
            modifier = Modifier.size(140.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Create new account",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = email.value, onValueChange = {
            email.value = it
        }, placeholder = {
            Text(text = "Email")
        },
            leadingIcon = {
                Image(painter = painterResource(id = R.drawable.email), contentDescription = null)
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFAFAFA)),
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color(0xFFB3C8F5),
                unfocusedContainerColor = Color(0xFFFAFAFA),
                focusedLeadingIconColor = Color(0xFF246BFD),
                unfocusedLeadingIconColor = Color.Black,

//                focusedTextColor = Color.Black,
//                unfocusedTextColor = Color.Black,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent,
//                containerColor = Color(0xFFFAFAFA),
//                focusedLeadingIconColor = Color(0xFF246BFD),
//                unfocusedLeadingIconColor = Color.Black,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password.value,
            onValueChange = {
                password.value = it
            },
            placeholder = {
                Text(text = "Password")
            },
            leadingIcon = {
                Image(painter = painterResource(id = R.drawable.lock), contentDescription = null)
            },
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color(0xFFB3C8F5),
                unfocusedContainerColor = Color(0xFFFAFAFA),
                focusedLeadingIconColor = Color(0xFF246BFD),
                unfocusedLeadingIconColor = Color.Black,
//                focusedTextColor = Color.Black,
//                unfocusedTextColor = Color.Black,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent,
//                containerColor = Color(0xFFFAFAFA),
//                focusedLeadingIconColor = Color(0xFF246BFD),
//                unfocusedLeadingIconColor = Color.Black,
            ),
            trailingIcon = {
                val icon = if (passwordVisibility.value) {
                    R.drawable.visibility
                } else {
                    R.drawable.visibility_off
                }
                IconButton(onClick = {
                    passwordVisibility.value = !passwordVisibility.value
                }) {
                    Icon(painter = painterResource(id = icon), contentDescription = null)
                }
            },
            visualTransformation = if (passwordVisibility.value) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFAFAFA))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(
                checked = checked.value,
                onCheckedChange = {
                    checked.value = it
                },
                modifier = Modifier.padding(end = 4.dp),
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF246BFD),
                    uncheckedColor = Color(0xFF246BFD)
                )
            )
            Text(
                text = "Remember me",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        checked.value = !checked.value
                    }
            )

        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3062C8),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(
                text = "Sign in", fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Forgot password?", color = Color(0xFF246BFD), fontSize = 16.sp,
            modifier = Modifier.clickable {

            }
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            HorizontalDivider(
                modifier = Modifier
                    .padding(end = 16.dp, top = 7.dp)
                    .weight(1f)
                    .alignByBaseline()
                    .height(1.dp),
                color = Color(0xFFFAFAFA),
                thickness = 2.dp
            )
            Text(
                text = "or continue with",
                fontSize = 14.sp,
                color = Color(0xFFC4C4C4),
                textAlign = TextAlign.Center,
                modifier = Modifier.alignByBaseline()
            )
            HorizontalDivider(
                modifier = Modifier
                    .padding(start = 16.dp, top = 7.dp)
                    .weight(1f)
                    .alignByBaseline()
                    .height(1.dp),
                color = Color(0xFFFAFAFA),
                thickness = 2.dp
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MyCustomCard(R.drawable.fb)
            MyCustomCard(R.drawable.google)
            MyCustomCard(R.drawable.apple)
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Already have an account?",
                color = Color(0xFF9E9E9E),
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Sign in",
                color = Color(0xFF246BFD),
                fontSize = 16.sp,
                modifier = Modifier.clickable {

                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "For scrollable", color = Color.Black, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "For scrollable", color = Color.Black, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "For scrollable", color = Color.Black, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "For scrollable", color = Color.Black, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "For scrollable", color = Color.Black, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "For scrollable", color = Color.Black, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "For scrollable", color = Color.Black, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "For scrollable", color = Color.Black, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "For scrollable", color = Color.Black, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "For scrollable", color = Color.Black, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "For scrollable", color = Color.Black, fontSize = 22.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun LoginAccountPagePreview() {
    LoginAccountPage(navController = NavController(LocalContext.current))
}