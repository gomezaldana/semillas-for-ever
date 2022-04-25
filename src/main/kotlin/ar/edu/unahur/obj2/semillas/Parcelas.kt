package ar.edu.unahur.obj2.semillas

open class Parcelas(var ancho: Double, val largo: Double, var horasSol: Int, val listasPlantas: MutableList<Planta>, val cantMaximaPlantas: Int) {

    fun superficie()= ancho*largo

    fun cantidadMaxima(): Double {
        if (ancho>largo){
            return this.superficie()/5
        }else{
            return this.superficie()/3+ largo
        }
    }

    fun tieneComplicaciones()=listasPlantas.any{it.horasTolerablesAlSol()<horasSol}

    fun totalPlantas()=listasPlantas.count()

    fun plantarPlanta(planta: Planta){
        if(cantMaximaPlantas>this.totalPlantas() || planta.horasTolerablesAlSol()>=horasSol+2){
            throw IllegalArgumentException("No se pudo plantar la planta")
        } else{
            listasPlantas.add(planta)
        }

    }

}

class ParcelaEcologica (ancho: Double, largo: Double, horasSol: Int,listasPlantas: MutableList<Planta>,cantMaximaPlantas: Int): Parcelas(ancho,largo,horasSol,listasPlantas, cantMaximaPlantas){
    fun seAsociaBien(planta:Planta)=this.tieneComplicaciones() && planta.esIdealParaParcela(this)
}

class ParcelaIndustrial (ancho: Double, largo: Double, horasSol: Int,listasPlantas: MutableList<Planta>,cantMaximaPlantas: Int): Parcelas(ancho,largo,horasSol,listasPlantas, cantMaximaPlantas){
    fun seAsociaBien(planta:Planta)=planta.esFuerte() && listasPlantas.size<=2
}