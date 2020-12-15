package tegucigalpaplaces.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_list.*
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener

class ListActivity : AppCompatActivity(),LugarClickListener {
    private lateinit var auth: FirebaseAuth
    private lateinit var recyclerView: RecyclerView
    private lateinit var db: FirebaseDatabase
    private lateinit var mbase: DatabaseReference
    val TAG = "Tegucigalpa Places"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        auth=FirebaseAuth.getInstance()
        logOut.setOnClickListener {
            auth.signOut()
            finish()
        }

        db=FirebaseDatabase.getInstance()
        mbase=db.getReference("lugares")
        getImageData()
        val adapter = LugarAdapter(ArrayList<Lugar>(), this)
        recyclerView=findViewById(R.id.recycler1)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    private fun getImageData() {
        val listener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                Log.w(TAG, dataSnapshot.toString())
                val datos = dataSnapshot.children
                datos?.let {
                    Log.w(TAG, datos.toString())
                    val autDat = ArrayList<Lugar>()
                    for (dat in datos) {
                        val lugarr = dat.getValue(Lugar::class.java)

                        lugarr?.let {
                            autDat.add(lugarr)
                        }
                    }
                    val adapter = LugarAdapter(autDat, this@ListActivity)
                    recyclerView.adapter = adapter
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(
                    TAG,
                    "Fallo la carga de los lugares desde la base de datos.",
                    databaseError.toException()
                )
                Toast.makeText(baseContext, "Fallo carga lugares", Toast.LENGTH_LONG)
            }
        }
        mbase.addValueEventListener(listener)
    }

    override fun lugarClicked(lugar: Lugar) {
        val intent = Intent(this, DescriptionActivity::class.java)
        intent.putExtra("descripcion", lugar)
        startActivity(intent)
    }
}