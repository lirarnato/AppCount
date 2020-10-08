package br.com.arquitetoandroid.appcount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        drawerLayout = findViewById(R.id.nav_drawer_layout)

        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.toggle_open, R.string.toggle_close)
        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)


        val calculoM: LinearLayout = findViewById(R.id.ll_medidor_m)
        calculoM.setOnClickListener {
            val intent: Intent = Intent(this, CalculoMActivity::class.java)
            startActivity(intent)

        }

    }

    override fun onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
        super.onBackPressed()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
           R.id.nav_gd_energia -> Toast.makeText(this, "Geracao", Toast.LENGTH_LONG).show()
            R.id.nav_cd_agua -> Toast.makeText(this, "Captacao", Toast.LENGTH_LONG).show()
            R.id.nav_cobranca_ae -> Toast.makeText(this, "Cobrança", Toast.LENGTH_LONG).show()
            R.id.nav_l_medicao -> Toast.makeText(this, "Leitura", Toast.LENGTH_LONG).show()
            R.id.nav_dc_ag -> Toast.makeText(this, "Economia", Toast.LENGTH_LONG).show()
        }

        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }
}
