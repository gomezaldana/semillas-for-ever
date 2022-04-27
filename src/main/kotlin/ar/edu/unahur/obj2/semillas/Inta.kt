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

    fun parcelaMasAutosustentable(): Parcelas? {
        val parcelasQueTienenMasCuatroPlantas= listaParcelas.filter { it.totalPlantas()>4 }
        val masSustentable= parcelasQueTienenMasCuatroPlantas.maxByOrNull { it.porcentajeBienAsociadas() }
        if (masSustentable !=null)
            return masSustentable
        else
            throw IllegalArgumentException("No hay una parcela mas autosustentable")
    }

    // Para esto, solo consideraremos aquellas parcelas con más de 4 plantas y elegiremos aquella que tenga
// mayor porcentaje de plantas "bien asociadas" (ver etapa 5)

}