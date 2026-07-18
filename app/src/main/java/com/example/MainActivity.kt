package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = BackgroundColor,
                    bottomBar = { BottomNavBar() }
                ) { innerPadding ->
                    HabitTrackerScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun HabitTrackerScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Header()
        Spacer(modifier = Modifier.height(16.dp))
        CurrentStreakBlock()
        Spacer(modifier = Modifier.height(12.dp))
        BentoGrid()
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Daily Bloom",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary,
                letterSpacing = (-0.5).sp
            )
            Text(
                text = "Tuesday, Oct 24",
                fontSize = 14.sp,
                color = TextSecondary
            )
        }
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(IconBg, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "Profile",
                tint = SecondaryBlockText
            )
        }
    }
}

@Composable
fun CurrentStreakBlock() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(PrimaryBlock, RoundedCornerShape(28.dp))
            .padding(24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "CURRENT STREAK",
                    fontSize = 12.sp,
                    color = PrimaryBlockText.copy(alpha = 0.8f),
                    letterSpacing = 2.sp
                )
                Text(
                    text = "24 Days",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    color = PrimaryBlockText
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.LocalFireDepartment,
                        contentDescription = null,
                        tint = PrimaryBlockText,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Personal Record!",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = PrimaryBlockText.copy(alpha = 0.9f)
                    )
                }
            }
            
            Box(
                modifier = Modifier.size(80.dp),
                contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawCircle(
                        color = Color.White.copy(alpha = 0.2f),
                        radius = size.width / 2,
                        style = Stroke(width = 6.dp.toPx())
                    )
                    drawArc(
                        color = Color.White,
                        startAngle = -90f,
                        sweepAngle = 360f * 0.82f,
                        useCenter = false,
                        style = Stroke(width = 6.dp.toPx(), cap = StrokeCap.Round)
                    )
                }
                Text(
                    text = "82%",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryBlockText
                )
            }
        }
    }
}

@Composable
fun BentoGrid() {
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(modifier = Modifier.fillMaxWidth().height(180.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            // Hydration Block
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(SecondaryBlock, RoundedCornerShape(28.dp))
                    .padding(20.dp)
            ) {
                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(SecondaryIconBg, RoundedCornerShape(16.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.WaterDrop,
                                contentDescription = null,
                                tint = SecondaryBlockText
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Hydration Goal",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = SecondaryBlockText,
                            lineHeight = 22.sp
                        )
                        Text(
                            text = "Drink 2.5L water",
                            fontSize = 12.sp,
                            color = TextSecondary
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Row(verticalAlignment = Alignment.Bottom) {
                            Text(
                                text = "1.8",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = SecondaryBlockText
                            )
                            Text(
                                text = "/2.5",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = SecondaryBlockText,
                                modifier = Modifier.padding(bottom = 2.dp)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(PrimaryBlock, CircleShape)
                                .clickable { },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "Add Water",
                                tint = PrimaryBlockText
                            )
                        }
                    }
                }
            }
            
            // Reading and Workout Blocks
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Reading Block
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(BlueBlock, RoundedCornerShape(28.dp))
                        .padding(16.dp)
                ) {
                    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(BlueIconBg, RoundedCornerShape(16.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Book,
                                    contentDescription = null,
                                    tint = BlueBlockText
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .background(Color.White.copy(alpha = 0.4f), CircleShape)
                                    .padding(horizontal = 8.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = "+15m",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = BlueBlockText
                                )
                            }
                        }
                        Text(
                            text = "Reading",
                            fontWeight = FontWeight.SemiBold,
                            color = BlueBlockText
                        )
                    }
                }
                
                // Workout Block
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(RedBlock, RoundedCornerShape(28.dp))
                        .padding(16.dp)
                ) {
                    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(RedIconBg, RoundedCornerShape(16.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.FitnessCenter,
                                    contentDescription = null,
                                    tint = RedBlockText
                                )
                            }
                            Icon(
                                imageVector = Icons.Filled.CheckCircle,
                                contentDescription = null,
                                tint = RedBlockText.copy(alpha = 0.4f)
                            )
                        }
                        Text(
                            text = "Workout",
                            fontWeight = FontWeight.SemiBold,
                            color = RedBlockText
                        )
                    }
                }
            }
        }
        
        // Reminder Block
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(WhiteBlock, RoundedCornerShape(28.dp))
                .border(1.dp, BorderColor, RoundedCornerShape(28.dp))
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(ReminderIconBg, RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.NotificationsActive,
                    contentDescription = null,
                    tint = PrimaryBlock
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "NEXT REMINDER",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryBlock,
                    letterSpacing = 1.sp
                )
                Text(
                    text = "Evening Meditation at 9:00 PM",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextPrimary
                )
            }
            Box(
                modifier = Modifier
                    .background(ReminderIconBg, CircleShape)
                    .clickable { }
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "SNOOZE",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryBlock
                )
            }
        }
    }
}

@Composable
fun BottomNavBar() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(BorderColor)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(NavBg)
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavItem(icon = Icons.Filled.Home, label = "Today", selected = true)
            NavItem(icon = Icons.Filled.BarChart, label = "Stats", selected = false)
            NavItem(icon = Icons.Outlined.EmojiEvents, label = "Badges", selected = false)
            NavItem(icon = Icons.Outlined.Settings, label = "Settings", selected = false)
        }
    }
}

@Composable
fun NavItem(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, selected: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { }
    ) {
        Box(
            modifier = Modifier
                .background(
                    if (selected) IconBg else Color.Transparent,
                    shape = CircleShape
                )
                .padding(horizontal = 20.dp, vertical = 4.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = if (selected) PrimaryBlock else TextSecondary
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
            color = if (selected) PrimaryBlock else TextSecondary
        )
    }
}

