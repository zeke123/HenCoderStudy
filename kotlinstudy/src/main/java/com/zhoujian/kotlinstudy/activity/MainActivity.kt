package com.zhoujian.kotlinstudy.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.zhoujian.base.utils.CacheUtils
import com.zhoujian.base.utils.Utils
import com.zhoujian.kotlinstudy.R
import com.zhoujian.kotlinstudy.bean.User
import com.zhoujian.kotlinstudy.view.CodeView
import com.zhoujian.lesson.activity.LessonActivity

class MainActivity : AppCompatActivity() {

    private val usernameKey: String = "username"
    private val passwordKey: String = "password"
    private lateinit var userName: EditText
    private lateinit var password: EditText
    private lateinit var code: EditText
    private lateinit var login: Button
    private lateinit var codeView: CodeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        clickEvent()
    }

    private fun clickEvent() {
        codeView.setOnClickListener {
            codeView.updateCode()
        }
        login.setOnClickListener {
            login()
        }
    }

    private fun initView() {
        userName = findViewById<EditText>(R.id.et_username)
        password = findViewById<EditText>(R.id.et_password)
        code = findViewById<EditText>(R.id.et_code)
        login = findViewById<Button>(R.id.btn_login)
        codeView = findViewById<CodeView>(R.id.code_view)
    }

    private fun login() {
        val username: String = userName.text.toString()
        val password: String = password.text.toString()
        val code: String = codeView.text.toString()
        val user: User = User(username, password, code)
        if (verity(user)) {
            CacheUtils.save(usernameKey, username)
            CacheUtils.save(passwordKey, password)
        }

        startActivity(Intent(this, LessonActivity::class.java))
    }

    private fun verity(user: User): Boolean {
        if (user.username != null && user.username.length < 4) {
            Utils.toast("用户名不合法")
            return false
        }
        if (user.password != null && user.password.length < 4) {
            Utils.toast("密码不合法")
            return false
        }
        return true
    }
}
