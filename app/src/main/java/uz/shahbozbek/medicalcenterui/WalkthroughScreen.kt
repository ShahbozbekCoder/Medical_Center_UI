package uz.shahbozbek.medicalcenterui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun WalkThroughScreen1(navController: NavController) {
    var currentPage by remember { mutableIntStateOf(0) }
    val totalPages = 3
    val currentImage = when (currentPage) {
        0 -> R.drawable.doc_1
        1 -> R.drawable.doc_2
        2 -> R.drawable.doc_3
        else -> R.drawable.doc_3
    }
    val currentTitle = when (currentPage) {
        0 -> "Thousands of doctors & experts to help your health!"
        1 -> "Health checks & consultations easily anywhere anytime"
        2 -> "Let's start living healthy and well with us right now!"
        else -> "Let's start living healthy and well with us right now!"
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = currentImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            contentScale = ContentScale.Crop
        )
        CustomCardView(
            title = currentTitle,
            currentPage = currentPage,
            totalPages = totalPages,
            onNextClick = {
                currentPage++
                if (currentPage == totalPages) {
                    navController.navigate("letsyouin")
                }
            }
        )
    }
}

@Composable
fun CustomCardView(
    title: String,
    currentPage: Int,
    totalPages: Int,
    onNextClick: () -> Unit
) {

    Card(
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .clickable {

            },
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF246BFD),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp),
                lineHeight = 36.sp
            )
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                repeat(totalPages) { index ->

                    Box(
                        modifier = Modifier
                            .size(if (index == currentPage) 12.dp else 8.dp)
                            .clip(CircleShape)
                            .background(
                                if (index == currentPage) Color(0xFF246BFD) else Color(
                                    0xFFE0E0E0
                                )
                            )
                    )

                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = { onNextClick() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF246BFD),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = when (currentPage) {
                        0 -> "Next"
                        1 -> "Next"
                        2 -> "Get Started"
                        else -> {
                            "Get Started"
                        }
                    },
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WalkThroughScreen1Preview() {
    WalkThroughScreen1(navController = NavController(LocalContext.current))
}
