package com.myluajpp.luajpp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.myluajpp.luajpp.ui.theme.LuajppTheme
import org.luaj.lib.jse.JsePlatform

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val globals = JsePlatform.standardGlobals()

        // 使用luaj++语法
        val luaScript = "for n=1,10 if n%2==0 continue end print(n) end"
        val chunk = globals.load(luaScript)

        // 执行 Lua 脚本 可在logcat查看日志
        chunk.call()

        enableEdgeToEdge()
        setContent {
            LuajppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LuajppTheme {
        Greeting("Android")
    }
}