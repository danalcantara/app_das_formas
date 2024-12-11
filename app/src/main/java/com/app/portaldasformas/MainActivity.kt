import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.*
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Portal das Formas", fontSize = 24.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("login") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text(text = "Logar")
        }

        Button(
            onClick = { navController.navigate("register") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text(text = "Cadastrar")
        }
    }
}

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login", fontSize = 24.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text(text = "Entrar")
        }

        Spacer(modifier = Modifier.height(20.dp))

        TextButton(onClick = { navController.navigate("register") }) {
            Text("Não possui uma conta? Cadastre-se")
        }
    }
}

@Composable
fun RegisterScreen(navController: NavController) {
    var nome by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var senha by remember { mutableStateOf(TextFieldValue()) }
    var confirmacaoSenha by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Cadastro", fontSize = 24.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = confirmacaoSenha,
            onValueChange = { confirmacaoSenha = it },
            label = { Text("Confirmar Senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("register_success") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text(text = "Cadastrar")
        }
    }
}

@Composable
fun RegisterSuccessScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Cadastro Efetuado com Sucesso!", fontSize = 24.sp, color = Color.Green)

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("login") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text(text = "Voltar para Login")
        }
    }
}

// Componente de Menu Principal
@Composable
fun MainMenu(navController: NavController) {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TextButton(onClick = { navController.navigate("home") }) {
                Text("Home")
            }
            TextButton(onClick = { navController.navigate("profile") }) {
                Text("Perfil")
            }
            TextButton(onClick = { navController.navigate("terms") }) {
                Text("Termos de Uso")
            }
            TextButton(onClick = { navController.navigate("logout") }) {
                Text("Logout")
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bem-vindo ao Portal das Formas!", fontSize = 24.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = { navController.navigate("shape/circle") }) {
                Text("Círculo")
            }
            Button(onClick = { navController.navigate("shape/square") }) {
                Text("Quadrado")
            }
            Button(onClick = { navController.navigate("shape/rectangle") }) {
                Text("Retângulo")
            }
        }
    }
}

@Composable
fun ShapeScreen(shape: String, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = shape.capitalize(), fontSize = 24.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(20.dp))

        // Exemplo de imagem para a forma
        // Box(modifier = Modifier.size(200.dp, 200.dp).background(Color.Gray))

        Text(text = "Descrição sobre o formato $shape aqui.", fontSize = 16.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(20.dp))

        var areaInput by remember { mutableStateOf(TextFieldValue()) }

        TextField(
            value = areaInput,
            onValueChange = { areaInput = it },
            label = { Text("Insira o valor") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { /* Realizar cálculo da área */ },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text(text = "Calcular Área")
        }

        // Exemplo de resultado
        Text(text = "Área calculada: X unidade²", fontSize = 16.sp, color = Color.Black)
    }
}

@Composable
fun ProfileScreen(navController: NavController) {
    var nome by remember { mutableStateOf(TextFieldValue("John Doe")) }
    var email by remember { mutableStateOf(TextFieldValue("john.doe@example.com")) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Perfil", fontSize = 24.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { /* Salvar alterações */ },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text(text = "Salvar")
        }
    }
}

@Composable
fun TermsScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Termos de Uso", fontSize = 24.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Aqui estão os termos de uso do aplicativo...", fontSize = 16.sp, color = Color.Black)
    }
}

@Composable
fun LogoutScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tem certeza que deseja sair?", fontSize = 24.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("login") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text(text = "Sim, Sair")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text(text = "Cancelar")
        }
    }
}

@Composable
fun AppNavGraph(navController: NavController) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Main"
    ) {

        composable("main") { MainScreen(navController = navController) }
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("register_success") { RegisterSuccessScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("terms") { TermsScreen(navController) }
        composable("logout") { LogoutScreen(navController) }
        composable("shape/circle") { ShapeScreen("circle", navController) }
        composable("shape/square") { ShapeScreen("square", navController) }
        composable("shape/rectangle") { ShapeScreen("rectangle", navController) }
        composable("shape/rhombus") { ShapeScreen("rhombus", navController) }
        composable("shape/trapezoid") { ShapeScreen("trapezoid", navController) }
        composable("shape/polygon") { ShapeScreen("polygon", navController) }
    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            Scaffold(
                bottomBar = { MainMenu(navController) }
            ) { innerpadding ->
                var padding = innerpadding
                AppNavGraph(navController)
            }
        }
    }
}
