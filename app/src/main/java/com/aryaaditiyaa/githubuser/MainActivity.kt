package com.aryaaditiyaa.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_users.setHasFixedSize(true)

        list.addAll(getListUsers())
        showRecyclerList()
    }

    private fun getListUsers(): ArrayList<User> {
        val dataUsername = resources.getStringArray(R.array.username)
        val dataName = resources.getStringArray(R.array.name)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getIntArray(R.array.repository)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataFollowers = resources.getIntArray(R.array.followers)
        val dataFollowing = resources.getIntArray(R.array.following)
        val dataAvatar = resources.obtainTypedArray(R.array.avatar)

        val listUser = ArrayList<User>()
        for (position in dataName.indices) {
            val user = User(
                dataUsername[position],
                dataName[position],
                dataLocation[position],
                dataRepository[position],
                dataCompany[position],
                dataFollowers[position],
                dataFollowing[position],
                dataAvatar.getResourceId(position, -1)
            )
            listUser.add(user)
        }
        dataAvatar.recycle()
        return listUser
    }

    private fun showRecyclerList() {
        rv_users.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rv_users.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                showSelectedUser(data)
            }
        })
    }

    private fun showSelectedUser(user: User) {
        val detailUserIntent = Intent(this, UserDetailActivity::class.java)
        detailUserIntent.putExtra(UserDetailActivity.KEY_USER, user)
        startActivity(detailUserIntent)
    }
}