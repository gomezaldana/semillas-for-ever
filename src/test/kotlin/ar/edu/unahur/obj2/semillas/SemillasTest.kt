package ar.edu.unahur.obj2.semillas

import ar.edu.unahur.obj2.semillas.Parcelas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe


class SemillasTest : DescribeSpec ({
    // hay una clase Planta que tiene por atributos
    // anioSemilla, altura
    describe("Creación de las plantas") {

        val menta = Menta(1.0, 2021)
        val mentita = Menta(0.3, 2021)
        val soja = Soja(0.6, 2009)
        val s1= Soja(2.0,2009)
        val s2= Soja(3.0,2009)
        val s3= Soja(4.6, 2009)
        val s4= Soja(3.6, 2009)
        val quinoa = Quinoa(0.2, 2010, 4.0)
        val parcela1 = Parcelas(20, 1, 10, mutableListOf(s1,s2,s3,s4), 4)
        //(var ancho: Int, val largo: Int, val horasSol: Int, val listasPlantas: MutableList<Planta>, val cantMaximaPlantas: Int) {


        it("probamos los atributos altura  y anioSemilla de menta") {
            menta.altura.shouldBe(1.0)
            menta.anioSemilla.shouldBe(2021)
        }

        it("probamos los atributos altura  y anioSemilla de quinoa") {
            quinoa.altura.shouldBe(0.2)
            quinoa.anioSemilla.shouldBe(2010)
        }

        it("probamos los atributos altura  y anioSemilla de soja") {
            soja.altura.shouldBe(0.6)
            soja.anioSemilla.shouldBe(2009)
        }

        it("verificar si da semillas") {
            menta.daSemillas().shouldBeTrue()
            mentita.daSemillas().shouldBeFalse()
            soja.daSemillas().shouldBeFalse()
            quinoa.daSemillas().shouldBeFalse()
        }

        it("es fuerte") {
            menta.esFuerte().shouldBeFalse()
            soja.esFuerte().shouldBeFalse()
            quinoa.esFuerte().shouldBeFalse()
        }

        it("espacio") {
            menta.espacio().shouldBe(2.0)
            mentita.espacio().shouldBe(1.3)
            soja.espacio().shouldBe(0.3)
            quinoa.espacio()
                .shouldBe(4.0)// me tira error, Expression 'espacio' of type 'Double' cannot be invoked as a function. The function 'invoke()' is not found
        }

        it("verifico la suma de varias") {
            val superficie = mutableListOf(
                soja.espacio(),
                menta.espacio(),
                mentita.espacio()
            ).sum()
            Math.ceil(superficie).shouldBe(4)
        }

        it("parcelas") {
            parcela1.superficie()shouldBe(20)
        }
    }
})
