package com.example.profileactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profileactivity.ui.theme.ProfileActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileActivityTheme {
                CredProfileScreen()
            }
        }
    }
}

@Composable
fun CredProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        TopBarSection()
        Spacer(modifier = Modifier.height(16.dp))
        UserInfoSection()
        Spacer(modifier = Modifier.height(16.dp))
        CredGarageSection()
        Spacer(modifier = Modifier.height(16.dp))
        CreditInfoSection()
        Spacer(modifier = Modifier.height(16.dp))
        RewardsSection()
        Spacer(modifier = Modifier.height(16.dp))
        ReferralSection()
        Spacer(modifier = Modifier.height(50.dp))
        TransactionsSection()
    }
}

@Composable
fun TopBarSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, tint = Color.White)
        Text("Profile", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Icon(Icons.Default.MoreVert, contentDescription = null, tint = Color.White)
    }
}

@Composable
fun UserInfoSection() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.profile_image), // Ensure this resource exists
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text("andaz Kumar", color = Color.White, fontWeight = FontWeight.Bold)
            Text("member since Dec, 2020", color = Color.Gray, fontSize = 12.sp)
        }
        Spacer(Modifier.weight(1f))
        Icon(Icons.Default.Edit, contentDescription = null, tint = Color.Gray)
    }
}

@Composable
fun CredGarageSection() {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.DarkGray),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.directions_cars), // Replace with correct drawable
                contentDescription = null,
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text("CRED garage", color = Color.White)
            Spacer(modifier = Modifier.weight(1f))
            Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null, tint = Color.White)
        }
    }
}

@Composable
fun CreditInfoSection() {

    InfoItem(title = "credit score", value = "757")

    Divider(color = Color.DarkGray)
    InfoItem(title = "lifetime cashback", value = "₹3")
    Divider(color = Color.DarkGray)
    InfoItem(title = "bank balance", value = "check")
}

@Composable
fun InfoItem(title: String, value: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, color = Color.White, modifier = Modifier.weight(1f))
        Text(value, color = Color.White)
        Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null, tint = Color.White)
    }
}

@Composable
fun RewardsSection() {
    Text("YOUR REWARDS & BENEFITS", color = Color.Gray, fontSize = 16.sp)
    Spacer(modifier = Modifier.height(8.dp))
    InfoItem(title = "cashback balance", value = "₹0")
    Divider(color = Color.DarkGray)
    InfoItem(title = "coins", value = "26,46,583")
    Divider(color = Color.DarkGray)
}

@Composable
fun ReferralSection() {
    Text("win upto Rs 1000", color = Color.White)
    Text("refer and earn", color = Color.Gray, fontSize = 12.sp)
}

@Composable
fun TransactionsSection() {
    Text("TRANSACTIONS & SUPPORT", color = Color.Gray, fontSize = 15.sp, fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "all transactions", color = Color.White, modifier = Modifier.weight(1f))

        Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null, tint = Color.White)
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CredProfileScreenPreview() {
    ProfileActivityTheme {
        CredProfileScreen()
    }
}
