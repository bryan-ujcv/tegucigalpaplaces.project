package tegucigalpaplaces.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_list.*
import com.firebase.ui.database.FirebaseRecyclerOptions

open class ListActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var recyclerView: RecyclerView
    lateinit var adapter:LugarAdapter
    lateinit var mbase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        mbase=FirebaseDatabase.getInstance().reference
        recyclerView=findViewById(R.id.recycler1)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val options = FirebaseRecyclerOptions.Builder<Lugar>()
            .setQuery(mbase, Lugar::class.java)
            .build()
        adapter = LugarAdapter(options);
        recyclerView.adapter = adapter

        auth=FirebaseAuth.getInstance()
        logOut.setOnClickListener {
            auth.signOut()
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }
}