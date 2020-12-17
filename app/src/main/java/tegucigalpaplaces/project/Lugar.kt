package tegucigalpaplaces.project

import android.os.Parcelable
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import kotlinx.android.parcel.Parcelize

@Parcelize
@IgnoreExtraProperties
data class Lugar(
    var Id: Int? = 0,
    var nombre: String? = "",
    var ubicacion: String? = "",
    var horario: String? = "",
    var img: String? = ""
) : Parcelable {

    @Exclude
    fun toMap(): Map<String, Any?>{
        return mapOf(
            "Id" to Id,
            "nombre" to nombre,
            "ubicacion" to ubicacion,
            "horario" to horario,
            "img" to img
        )
    }
}