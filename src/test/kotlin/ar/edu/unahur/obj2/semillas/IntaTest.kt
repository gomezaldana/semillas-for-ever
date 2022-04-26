package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class IntaTest: DescribeSpec( {
    describe("Creacion de parcelas para el INTA") {
        val menta = Menta(1.0, 2021)
        val menta2 = Menta(1.0, 2021)
        val quinoa = Quinoa(0.2, 2014,0.5)
        val quinoa2 = Quinoa(0.1, 2018,0.5)
        val soja= Soja(0.6, 2014)
        val pEcologica = ParcelaEcologica(6.0, 2.0,10,mutableListOf(menta,menta2),5)
        val pIndustrial = ParcelaIndustrial(3.0, 3.0,10,mutableListOf(menta,soja),3)

        val pEcologica2 = ParcelaEcologica(6.0, 2.0,8,mutableListOf(),6)
        val pIndustrial2 = ParcelaIndustrial(3.0, 3.0,10,mutableListOf(),3)

        val inta= Inta


        it("Promedio plantas por parcela deberian ser 1") {
            inta.promedioPlantas().shouldBe(1)
        }

        it("Obtener la parcela mas autosustentable") {
            inta.agregarParcela(pEcologica2)//agregar plantas para las 2 parcelas
            inta.agregarParcela(pIndustrial2)
            inta.parcelaMasAutosustentable().shouldBe(pEcologica2)
        }
    }

})
