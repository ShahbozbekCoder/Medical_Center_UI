package uz.shahbozbek.medicalcenterui

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LetsYouInUI(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 24.dp, end = 24.dp, top = 16.dp),
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
            painter = painterResource(R.drawable.girl_tree),
            contentDescription = "Girl Tree",
            modifier = Modifier.size(250.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Let's you in!",
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomCard(
            img = R.drawable.fb,
            text = "Continue with Facebook"
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomCard(
            img = R.drawable.google,
            text = "Continue with Google"
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomCard(
            img = R.drawable.apple,
            text = "Continue with Apple"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            HorizontalDivider(
                modifier = Modifier
                    .padding(end = 16.dp, top = 12.dp)
                    .weight(1f)
                    .alignByBaseline()
                    .height(1.dp),
                color = Color(0xFFEEEEEE)
            )
            Text(
                text = "or",
                fontSize = 22.sp,
                color = Color(0xFF616161),
                textAlign = TextAlign.Center
            )
            HorizontalDivider(
                modifier = Modifier
                    .padding(start = 16.dp, top = 12.dp)
                    .weight(1f)
                    .alignByBaseline()
                    .height(1.dp),
                color = Color(0xFFEEEEEE)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.navigate("newaccount")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF246BFD),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(50)
        ) {
            Text(text = "Sign in with password")
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account?",
                color = Color(0xFF9E9E9E)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = "Sign up",
                color = Color(0xFF246BFD),
                modifier = Modifier.clickable {

                }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun CustomCard(
    img: Int,
    text: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable {

            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFEEEEEE))
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(img),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                text = text,
                fontSize = 20.sp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LetsYouInUIPreview() {
    LetsYouInUI(navController = NavController(LocalContext.current))
}