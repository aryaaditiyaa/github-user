package com.aryaaditiyaa.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_USER = "key_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val dataUser = intent.getParcelableExtra<User>(KEY_USER) as User

        tv_name.text = dataUser.name
        tv_username.text = dataUser.username
        tv_location.text = dataUser.location
        tv_followers.text = dataUser.followers.toString()
        tv_following.text = dataUser.following.toString()
        tv_repository.text = dataUser.repository.toString()
        tv_company.text = dataUser.company
        img_photo.setImageResource(dataUser.avatar)

    }
}