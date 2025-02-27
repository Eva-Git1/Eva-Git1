import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), MainActivityInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configure le menu de navigation
        setupBottomNavigation()
    }

    override fun setupBottomNavigation() {
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Charger le fragment par défaut
        loadFragment(CategoryFragment())

        // Définir un listener pour les éléments du menu
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            val fragment: Fragment = when (item.itemId) {
                R.id.nav_category -> CategoryFragment()
                R.id.nav_video -> VideoFragment()
                R.id.nav_new_sales -> NewSalesFragment()
                else -> CategoryFragment()
            }
            loadFragment(fragment)
            true
        }
    }

    override fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
