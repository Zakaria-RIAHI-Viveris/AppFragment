package com.viveris.appfragment.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.viveris.appfragment.R
import com.viveris.appfragment.ui.fragment.AbstractBaseFragment
import com.viveris.appfragment.ui.fragment.HomeFragment
import com.viveris.appfragment.ui.fragment.SettingsFragment
import com.viveris.appfragment.ui.fragment.TransactionsFragment
import com.viveris.appfragment.ui.listener.NavigationListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)
        }

        nav_view.setNavigationItemSelectedListener { menuItem -> // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            drawer_layout.closeDrawers()
            selectDrawerItem(menuItem.itemId, menuItem.title.toString())

            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here
            true
        }
        selectDrawerItem(100000, "Home")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawer_layout?.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        drawer_layout?.let {
            if (it.isDrawerOpen(GravityCompat.START)) {
                it.closeDrawers()
            } else {
                val fragmentManager = supportFragmentManager
                val primaryNavigationFragment = fragmentManager.primaryNavigationFragment
                // if we are not in the home fragment we go to the previous fragment (cf NavigationComputer)
                // if we are in home fragment we exit the app
                if (primaryNavigationFragment != null && primaryNavigationFragment.javaClass == HomeFragment::class.java) {
                    super.onBackPressed()
                } else {
                    selectDrawerItem(R.id.nav_home, getString(R.string.home))
                }
            }
        }

    }

    private fun selectDrawerItem(itemId: Int, itemTitle: String?) {
        supportActionBar?.title = itemTitle

        val fragmentClass: Class<*>? = when (itemId) {
            R.id.nav_transactions -> TransactionsFragment::class.java
            R.id.nav_settings -> SettingsFragment::class.java
            R.id.nav_disconnect -> null
            else -> HomeFragment::class.java
        }

        val fragmentManager = supportFragmentManager

        if (fragmentClass != null) {
            try {
                val fragment = fragmentClass.newInstance() as AbstractBaseFragment
                fragment.setNavigationListener(this)
                fragmentManager.beginTransaction().replace(R.id.content_main, fragment).setPrimaryNavigationFragment(fragment).commit()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
        }
    }

    override fun onItemSlected(itemId: Int, itemTitle: String?) {
        selectDrawerItem(itemId, itemTitle)
    }
}