package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe


class ParcelasTest: DescribeSpec({
    describe("creacion plantas y parcelas") {
        val menta = Menta(1.0, 2021)
        val quinoa = Quinoa(0.2, 2014,0.5)
        val quinoa2 = Quinoa(0.1, 2018,0.5)
        val soja= Soja(0.6, 2014)
        val pEcologica = ParcelaEcologica(6.0, 2.0,10,mutableListOf(),5)
        val pIndustrial = ParcelaIndustrial(3.0, 3.0,10,mutableListOf(),3)

        val pEcologica2 = ParcelaEcologica(6.0, 2.0,8,mutableListOf(),6)
        val pIndustrial2 = ParcelaIndustrial(3.0, 3.0,10,mutableListOf(),3)

        it("planta se asocia bien en una parcela ecologica") {
            pEcologica.plantarPlanta(menta)
            pEcologica.tieneComplicaciones().shouldBeFalse()
            menta.esIdealParaParcela(pEcologica)
            pEcologica.seAsociaBien(menta).shouldBeTrue()
        }

        it("planta NO se asocia bien en una parcela ecologica porque la parcela tiene complicaciones") {
            pEcologica2.plantarPlanta(soja)
            pEcologica2.tieneComplicaciones().shouldBeTrue()
            menta.esIdealParaParcela(pEcologica).shouldBeTrue()
            pEcologica2.seAsociaBien(menta).shouldBeFalse()
        }

        it("planta se asocia bien en una parcela industrial") {
            pIndustrial.plantarPlanta(quinoa2)
            quinoa.esFuerte().shouldBeTrue()
            pIndustrial.listasPlantas.size.shouldBe(1)
            pIndustrial.seAsociaBien(quinoa).shouldBeTrue()
        }

        it("planta NO se asocia bien en una parcela industrial porque hay mas de dos plantas en la parcela") {
            pIndustrial2.plantarPlanta(menta)
            pIndustrial2.plantarPlanta(soja)
            quinoa.esFuerte().shouldBeTrue()
            pIndustrial2.listasPlantas.size.shouldBe(2)
            pIndustrial2.seAsociaBien(quinoa).shouldBeFalse()
        }
    }
})