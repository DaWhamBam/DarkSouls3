package inventory
import Arena
import characterKlassen.Hero
import enemieKlassen.Enemie


class Trank(name: String, art: String, var heilung: Int = 10): Item(name, art) {

//    fun heiltrankNutzen(hero: Hero, enemie: Enemie, arena: Arena) {
//        var charHeilung = arena.inventoryList[nameGegenstand]!!
//        println("Heiltrank gewählt. Wenn möchtest du Heilen?")
//        println(
//            """
//                1: ${arena.charListe.elementAt(0).name}
//                2: ${arena.charListe.elementAt(1).name}
//                3: ${arena.charListe.elementAt(2).name}
//            """.trimIndent()
//        )
//
//        var eingabeCharHeilung = readln()
//        var indexCharGeheilter = eingabeCharHeilung.toInt() - 1
//        var geheilter = arena.charListe.elementAt(indexCharGeheilter)
//        geheilter.hp += charHeilung
//
//        println("${held.name} (${held.klasse}) heilt ${geheilter.name} und hat nun ${geheilter.hp} HP.\n")
//        continue
//    }
}