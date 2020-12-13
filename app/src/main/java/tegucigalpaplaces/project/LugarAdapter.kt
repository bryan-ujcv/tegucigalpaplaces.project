package tegucigalpaplaces.project

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.firebase.ui.database.FirebaseRecyclerAdapter

class LugarAdapter(@NonNull options: FirebaseRecyclerOptions<Lugar>):FirebaseRecyclerAdapter<Lugar, LugarAdapter.LugarViewholder>(options) {

    override fun onBindViewHolder(@NonNull holder: LugarViewholder, position: Int, @NonNull model:Lugar) {

        holder.firstname.text = model.getNombre()
        holder.lastname.text = model.getUbicacion()
        holder.age.text = model.getHorario()
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent:ViewGroup, viewType:Int):LugarViewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contenedor, parent, false)
        return LugarViewholder(view)
    }

    class LugarViewholder(@NonNull itemView: android.view.View):RecyclerView.ViewHolder(itemView) {
        var firstname:TextView = itemView.findViewById(R.id.firstname)
        var lastname:TextView = itemView.findViewById(R.id.lastname)
        var age:TextView = itemView.findViewById(R.id.age)
    }

}