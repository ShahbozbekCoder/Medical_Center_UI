package uz.shahbozbek.medicalcenterui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.shahbozbek.medicalcenterui.ui.theme.MedicalCenterUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MedicalCenterUITheme {
                MyNavigation()
            }
        }
    }
}
@Composable
fun MyNavigation() {
    val myNavController = rememberNavController()
    NavHost(navController = myNavController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController = myNavController)
        }
        composable("welcome") {
            WelcomeScreen(navController = myNavController)
        }
        composable("walkthrough1") {
            WalkThroughScreen1(navController = myNavController)
        }
        composable("letsyouin") {
            LetsYouInUI(navController = myNavController)
        }
        composable("newaccount") {
            NewAccountPage(navController = myNavController)
        }
        composable("loginaccount") {
            LoginAccountPage(navController = myNavController)
        }
    }
}
