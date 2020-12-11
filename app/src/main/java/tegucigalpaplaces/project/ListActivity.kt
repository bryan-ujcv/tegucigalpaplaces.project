package tegucigalpaplaces.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        auth=FirebaseAuth.getInstance()
        logOut.setOnClickListener {
            auth.signOut()
            finish()
        }
    }
}