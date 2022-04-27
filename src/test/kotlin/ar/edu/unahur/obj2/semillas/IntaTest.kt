package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class IntaTest: DescribeSpec( {
    describe("Creacion de parcelas para el INTA") {
        val menta = Menta(1.0, 2021)
        val menta2 = Menta(1.0, 2012)
        val menta3 = Menta(1.0, 2001)
        val quinoa = Quinoa(0.2, 2014,0.5)
        val quinoa2 = Quinoa(0.1, 2018,0.5)
        val soja= Soja(0.6, 2014)
        val soja2= Soja(0.5, 2011)
        val soja3= Soja(1.5, 2002)
        val pEcologica = ParcelaEcologica(6.0, 2.0,10,mutableListOf(menta,menta2),5)
        val pIndustrial = ParcelaIndustrial(3.0, 3.0,10,mutableListOf(menta,soja),3)

        val pEcologica2 = ParcelaEcologica(6.0, 2.0,1,mutableListOf(menta,quinoa2,soja,menta2,soja2),6)
        val pIndustrial2 = ParcelaIndustrial(3.0, 3.0,10,mutableListOf(menta,menta2,quinoa,soja,soja3),3)

        val inta= Inta

        it("Promedio plantas por parcela deberian ser 0") {
            inta.promedioPlantas().shouldBe(0)
        }

        it("Promedio plantas por parcela deberian ser 2") {
            inta.agregarParcela(pEcologica)
            inta.promedioPlantas().shouldBe(2)
        }

        it("Promedio plantas por parcela tambien deberian ser 2") {
            inta.agregarParcela(pIndustrial)
            inta.promedioPlantas().shouldBe(2)
        }

        it ("Probando funciones esIdealParaParcela, cantBien asociadas"){
            inta.agregarParcela(pEcologica2)
            menta.esIdealParaParcela(pEcologica2).shouldBeTrue()
            menta2.esIdealParaParcela(pEcologica2).shouldBeTrue()
            quinoa2.esIdealParaParcela(pEcologica2).shouldBeTrue()
            soja.esIdealParaParcela(pEcologica2).shouldBeFalse()
            pEcologica2.cantBienAsociadas().shouldBe(3)
        }

        it("Obtener la parcela mas autosustentable") {
            inta.agregarParcela(pIndustrial2)
            pEcologica2.porcentajeBienAsociadas().shouldBe(0.6)
            inta.parcelaMasAutosustentable().shouldBe(pEcologica2)
        }
    }

})
