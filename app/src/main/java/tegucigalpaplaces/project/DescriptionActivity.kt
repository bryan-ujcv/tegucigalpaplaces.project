package tegucigalpaplaces.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.lugar_descripcion.*

class DescriptionActivity : AppCompatActivity() {
    lateinit var pl: Lugar
    private lateinit var db: FirebaseDatabase
    private lateinit var mbase: DatabaseReference
    val TAG = "Tegucigalpa Places"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lugar_descripcion)
        pl = intent.getParcelableExtra<Lugar>("Lugar")!!

        db = FirebaseDatabase.getInstance()
        mbase = db.getReference("lugares")
        Log.d(TAG, mbase.toString())
        Picasso.get().load(pl.img).into(imgBar)
        txtNombre.text = pl.nombre
        ubicacion.text = pl.ubicacion
        horario.text = pl.horario
    }
}