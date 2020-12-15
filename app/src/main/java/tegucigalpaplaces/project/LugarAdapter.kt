package tegucigalpaplaces.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.squareup.picasso.Picasso

interface LugarClickListener{
    fun lugarClicked(lugar: Lugar)
}

class LugarAdapter(val lugares: ArrayList<Lugar>, val listener: LugarClickListener) : Adapter<LugarViewholder>() {

    override fun onBindViewHolder(holder: LugarViewholder, position: Int,) {
        val lugar = lugares[position]
        holder.firstname.text = lugar?.nombre
        holder.lastname.text = lugar?.ubicacion
        holder.age.text = lugar?.horario
        Picasso.get().load(lugar.img).into(holder.lugarimg)
        holder.itemView.setOnClickListener {
            listener.lugarClicked(lugar)
        }
    }

    override fun getItemCount(): Int {
        return lugares.count()
    }

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):LugarViewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contenedor, parent, false)
        return LugarViewholder(view)
    }
}
class LugarViewholder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val firstname: TextView = itemView.findViewById(R.id.firstname)
    val lastname:TextView = itemView.findViewById(R.id.lastname)
    val age:TextView = itemView.findViewById(R.id.age)
    val lugarimg = itemView.findViewById<ImageView>(R.id.imageView)
}