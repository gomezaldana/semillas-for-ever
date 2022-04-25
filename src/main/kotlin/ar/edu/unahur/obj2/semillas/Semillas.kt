package ar.edu.unahur.obj2.semillas

open class Planta(var altura: Double, val anioSemilla: Int) {

    object Constates{
        val auxEsFuerte=9
    }

    open fun horasTolerablesAlSol(): Int{ return 7}

    fun esFuerte(): Boolean{
        return this.horasTolerablesAlSol() > Planta.Constates.auxEsFuerte
    }

    open fun esIdealParaParcela(parcela:Parcelas)=false


}

///////////////////////////////////////////////////

open class Menta(altura: Double, anioSemilla: Int): Planta(altura,anioSemilla) {

    open fun espacio(): Double {
        return altura+1.0
    }

    fun daSemillas()=this.esFuerte() or (altura>0.4)

    override fun esIdealParaParcela(parcela:Parcelas)= parcela.superficie()>6


}



class Quinoa(altura: Double, anioSemilla: Int,val espacio: Double): Planta(altura,anioSemilla) {

    fun daSemillas()= this.esFuerte() or (2001<anioSemilla && anioSemilla<2008)

    fun espacio()=espacio

    override fun horasTolerablesAlSol()=
        if (espacio<0.3){
            10
        } else {
            7
        }

    override fun esIdealParaParcela(parcela:Parcelas)=!(parcela.listasPlantas.any{it.altura>1.5})
    //parcelas en las que no haya ninguna planta cuya altura supere los 1.5 metros

}

open class Soja(altura: Double, anioSemilla: Int): Planta(altura,anioSemilla) {
    fun espacio(): Double {
        return altura/2
    }

    open fun daSemillas()=this.esFuerte() or (anioSemilla>2007 && altura>0.75 && altura<0.9)


    override fun horasTolerablesAlSol()=
        if (altura > 0.5){
            6
        } else if (altura< 1.0){
            8
        }else{
            12
        }

    //la cantidad de sol que recibe la parcela es exactamente igual a los que ella tolera
    override fun esIdealParaParcela(parcela:Parcelas)= parcela.horasSol==this.horasTolerablesAlSol()

}

/////////////////////////////PUNTO 2 ////////////////////////////////

class SojaTransgenica(altura: Double, anioSemilla: Int): Soja(altura,anioSemilla){

    override fun daSemillas()= false
    //prefiere parcelas cuya cantidad máxima de plantas sea igual a 1.
    override fun esIdealParaParcela(parcela:Parcelas)= parcela.cantMaximaPlantas==1

}

class Peperina(altura: Double, anioSemilla: Int): Menta(altura,anioSemilla){

    override fun espacio()= (altura+1)*2

}

