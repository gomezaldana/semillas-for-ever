package ar.edu.unahur.obj2.semillas

class Menta(altura: Double, anioSemilla: Int): Planta(altura,anioSemilla) {

    fun espacio(): Double {
        return altura+1
    }

    fun daSemillas(): Boolean {
        return self.esFuerte() or altura>0.4
    }

}

class Soja(altura: Double, anioSemilla: Int): Planta(altura,anioSemilla) {
    fun espacio(): Double {
        return altura/2
    }

    fun daSemillas(): Boolean {
        return self.esFuerte() or (anioSemilla>2007 and 0.75<altura<0.9)
    }

    override fun horasTolerablesAlSol(){
        if (altura >0.5){
            return 6
        } else if (0.5<altura< 1.0){
            return 8
        }else{
            return 12
        }
    }



}

class Quinoa(altura: Double, anioSemilla: Int,val espacio: Double): Planta(altura,anioSemilla) {

    fun daSemillas(): Boolean {
        return self.esFuerte() or 2001<anioSemilla<2008
    }

    override fun horasTolerablesAlSol(){
        if (espacio<0.3){
            return 10
        } else {
            return 7
        }
    }


}


/////////////////////////////////////////////////////////////////

class Planta(var altura: Double, val anioSemilla: Int) {

    object Constates{
        val auxEsFuerte=9 //no se si dejar este nombre
    }

    fun horasTolerablesAlSol(){ return 7}

    fun esFuerte(){
        return self.horasTolerablesAlSol() > Planta.Constates.auxEsFuerte
    }

    fun daSemillas(){}//no se si dejarlo o sacarlo

    fun espacio() {//no se si dejarlo o sacarlo
    
    }

}