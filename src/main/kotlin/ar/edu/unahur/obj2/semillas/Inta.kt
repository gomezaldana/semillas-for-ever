package ar.edu.unahur.obj2.semillas

object Inta {
    val listaParcelas= mutableListOf<Parcelas>()

    fun agregarParcela (nuevaParcela:Parcelas){
        listaParcelas.add(nuevaParcela)
    }

    fun cantidadDeParcelas()=listaParcelas.size

    fun cantidadDeplantasEnParcelas()= listaParcelas.sumBy { it.totalPlantas() }

    fun promedioPlantas()=
        if (this.cantidadDeParcelas()==0) {
            0
        }
        else {
            this.cantidadDeplantasEnParcelas()/this.cantidadDeParcelas()
        }

    fun parcelaMasAutosustentable(){

    }
    // Para esto, solo consideraremos aquellas parcelas con más de 4 plantas y elegiremos aquella que tenga
// mayor porcentaje de plantas "bien asociadas" (ver etapa 5)

}