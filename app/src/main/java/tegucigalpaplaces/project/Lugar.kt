package tegucigalpaplaces.project

import android.os.Parcelable
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import kotlinx.android.parcel.Parcelize

@Parcelize
@IgnoreExtraProperties
data class Lugar(
    var nombre: String? = "",
    var ubicacion: String? = "",
    var horario: String? = "",
    var img: String? = ""
) : Parcelable {

    @Exclude
    fun toMap(): Map<String, Any?>{
        return mapOf(
            "nombre" to nombre,
            "ubicacion" to ubicacion,
            "horario" to horario,
            "img" to img
        )
    }
}