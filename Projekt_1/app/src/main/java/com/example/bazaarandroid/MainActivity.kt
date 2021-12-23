package com.example.bazaarandroid

import android.app.ProgressDialog.show
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.View
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.bazaarandroid.fragments.SettingsOwnerFragment

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bottom navigation
        navController = findNavController(R.id.nav_host_fragment)
        //val navControllerTop = findNavController(R.id.nav_host_fragment2)
        //val navControllerTop2 = findNavController(R.id.nav_host_fragment3)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        //val bottomNavTop = findViewById<BottomNavigationView>(R.id.bottom_nav_view2)
        //val bottomNavTop2 = findViewById<BottomNavigationView>(R.id.bottom_nav_view3)

        bottomNav?.setupWithNavController(navController)
        //bottomNavTop?.setupWithNavController(navControllerTop)
        //bottomNavTop2?.setupWithNavController(navControllerTop2)

        // Up navigation
        NavigationUI.setupActionBarWithNavController(this, navController)
        //NavigationUI.setupActionBarWithNavController(this, navControllerTop)
        //NavigationUI.setupActionBarWithNavController(this, navControllerTop2)

        // Hide bottom navigation bar in some fragments
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id != R.id.timelineFragment && destination.id != R.id.myMarketFragment && destination.id != R.id.myFaresFragment){
                bottomNav.visibility = View.GONE
                //bottomNavTop.visibility = View.GONE
                //bottomNavTop2.visibility = View.GONE
            } else {
                if(destination.id == R.id.myMarketFragment){
                    //bottomNavTop2.visibility = View.VISIBLE
                    //bottomNavTop.visibility = View.GONE
                }
                else
                {
                    //bottomNavTop.visibility = View.VISIBLE
                    //bottomNavTop2.visibility = View.GONE
                }
                bottomNav.visibility = View.VISIBLE

            }

            //tudtommal nem megy
            if(destination.id == R.id.settingsOwnerFragment){
                bottomNav.visibility = View.VISIBLE
                //bottomNavTop.visibility = View.GONE
                //bottomNavTop2.visibility = View.GONE
            }

            if(destination.id == R.id.detailPageScretchFragment){
                bottomNav.visibility = View.VISIBLE
                //bottomNavTop.visibility = View.GONE
                //bottomNavTop2.visibility = View.GONE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()  || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        MyApplication.token = ""
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_nav_menu,menu)

        val search = menu?.findItem(R.id.searchPanel)
        val searchView = search?.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if(query != null){
            //searchDatabase(query)
        }
        return true
    }

}


