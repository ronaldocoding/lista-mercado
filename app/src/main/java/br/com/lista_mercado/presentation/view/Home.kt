package br.com.lista_mercado.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import br.com.lista_mercado.R
import br.com.lista_mercado.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = binding.root
        setContentView(view)

        val navView = binding.homeNavView
        val drawerLayout = binding.homeDrawerLayout

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_share_list -> Toast.makeText(
                    applicationContext,
                    "Cliquou em Compartilhar sua Lista :)",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_config -> Toast.makeText(
                    applicationContext,
                    "Cliquou em Configurações :)",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_about -> Toast.makeText(
                    applicationContext,
                    "Cliqou em Sobre :)",
                    Toast.LENGTH_SHORT
                ).show()
            }

            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}