package com.example.instagram_app.login.data

interface LoginDataSource {

    fun login(email:String,password:String,callback:LoginCallback)

}