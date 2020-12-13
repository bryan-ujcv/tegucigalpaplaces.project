package tegucigalpaplaces.project

class Lugar {
    private lateinit var nombre:String
    private lateinit var ubicacion:String
    private lateinit var horario:String
    private lateinit var img:String

    fun getNombre(): String? {
        return nombre
    }
    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    fun getUbicacion(): String? {
        return ubicacion
    }
    fun setUbicacion(ubicacion: String) {
        this.ubicacion = ubicacion
    }

    fun getHorario(): String? {
        return horario
    }
    fun setHorario(horario: String) {
        this.horario = horario
    }

    fun getImg(): String? {
        return img
    }
    fun setImg(img: String) {
        this.img = img
    }
}