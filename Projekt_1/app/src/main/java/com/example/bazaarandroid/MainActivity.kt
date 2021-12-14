package com.example.bazaarandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bottom navigation
        val navController = findNavController(R.id.nav_host_fragment)
        val navControllerTop = findNavController(R.id.nav_host_fragment2)
        val navControllerTop2 = findNavController(R.id.nav_host_fragment3)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        val bottomNavTop = findViewById<BottomNavigationView>(R.id.bottom_nav_view2)
        val bottomNavTop2 = findViewById<BottomNavigationView>(R.id.bottom_nav_view3)

        bottomNav?.setupWithNavController(navController)
        bottomNavTop?.setupWithNavController(navControllerTop)
        bottomNavTop2?.setupWithNavController(navControllerTop2)

        // Up navigation
        NavigationUI.setupActionBarWithNavController(this, navController)
        NavigationUI.setupActionBarWithNavController(this, navControllerTop)
        NavigationUI.setupActionBarWithNavController(this, navControllerTop2)

        // Hide bottom navigation bar in some fragments
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id != R.id.timelineFragment && destination.id != R.id.myMarketFragment && destination.id != R.id.myFaresFragment){
                bottomNav.visibility = View.GONE
                bottomNavTop.visibility = View.GONE
                bottomNavTop2.visibility = View.GONE
            } else {
                if(destination.id == R.id.myMarketFragment){
                    Log.d("xxx", "nem elotte")
                    bottomNavTop2.visibility = View.VISIBLE
                    bottomNavTop.visibility = View.GONE
                    Log.d("xxx", "nem utana")
                }
                else
                {
                    bottomNavTop.visibility = View.VISIBLE
                    bottomNavTop2.visibility = View.GONE
                }
                bottomNav.visibility = View.VISIBLE

            }

            //tudtommal nem megy
            if(destination.id == R.id.settingsOwnerFragment){
                bottomNav.visibility = View.VISIBLE
                bottomNavTop.visibility = View.GONE
                bottomNavTop2.visibility = View.GONE
            }

            if(destination.id == R.id.detailPageScretchFragment){
                bottomNav.visibility = View.VISIBLE
                bottomNavTop.visibility = View.GONE
                bottomNavTop2.visibility = View.GONE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        val navController2 = findNavController(R.id.nav_host_fragment2)
        val navController3 = findNavController(R.id.nav_host_fragment3)
        return (navController.navigateUp() &&  navController2.navigateUp() &&  navController3.navigateUp()) || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        MyApplication.token = ""
    }
}