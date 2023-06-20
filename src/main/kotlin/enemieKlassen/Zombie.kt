package enemieKlassen

import characterKlassen.Hero
import Arena
import SLEEP_TIME

class Zombie(name: String, typ: String, hp: Int):
    Enemie(name, typ, hp) {

    var attacks: MutableMap<String, Int> = mutableMapOf(
        "Kratzer" to 10,
        "Gift" to 5, // trifft alle Helden
        "Blocken" to 0,
        "Umfallen" to 0, // Enemie setzt für eine Runde aus
    )

    override fun angriffGegner(hero: Hero, arena: Arena) {
        kannAngegriffenWerden = true

        if (hero.hatSchutzStein == true) {
            attacks["Kratzer"] = 5
            attacks["Gift"] = 1

        } else {
            attacks["Kratzer"] = 10
            attacks["Gift"] = 5
        }

        println("${this.name} macht sich bereit für seinen Angriff!")
        Thread.sleep(SLEEP_TIME)
        var atkName = attacks.keys

        var wuerfel = (1..100).random()
        when (wuerfel) {
            in 1..40 -> {
                if (hero.kannAngegriffenWerden == true) {
                    var attacke = atkName.elementAt(0)
                    println("${this.name} greift mit $attacke an!!")
                    Thread.sleep(SLEEP_TIME)
                    var gegnerSchaden = attacks[attacke]!!
                    var opfer = hero
                    opfer.hp -= gegnerSchaden
                    Thread.sleep(SLEEP_TIME)
                    println("${opfer.name} bekommt $gegnerSchaden und hat nur noch ${opfer.hp} HP!!\n")
                } else{
                    var attacke = atkName.elementAt(0)
                    println("${this.name} greift mit $attacke an!!")
                    Thread.sleep(SLEEP_TIME)
                    println("${hero.name} ist durch seinen Schutz geschützt!\n")
                }
            }

            in 41..60 -> {
                if (hero.kannAngegriffenWerden == true) {
                    var attacke = atkName.elementAt(1)
                    println("${this.name} greift mit $attacke an!!\n")
                    Thread.sleep(SLEEP_TIME)
                    var gegnerSchaden = attacks[attacke]!!
                    var opfer1 = arena.charListe.elementAt(0)
                    var opfer2 = arena.charListe.elementAt(1)
                    var opfer3 = arena.charListe.elementAt(2)

                    if(opfer1.kannAngegriffenWerden == true){
                        println("${opfer1.name} bekommt $gegnerSchaden Schaden und hat nur noch ${opfer1.hp} HP!!")
                        opfer1.hp -= gegnerSchaden
                    } else {
                        println("${opfer1.name} ist durch seinen Schutz geschützt!")
                    }

                    if(opfer2.kannAngegriffenWerden == true){
                        println("${opfer2.name} bekommt $gegnerSchaden und hat nur noch ${opfer2.hp} HP!!")
                        opfer2.hp -= gegnerSchaden
                    } else {
                        println("${opfer2.name} ist durch seinen Schutz geschützt!")
                    }

                    if(opfer3.kannAngegriffenWerden == true){
                        println("${opfer3.name} bekommt $gegnerSchaden Schaden und hat nur noch ${opfer3.hp} HP!!\n")
                        opfer3.hp -= gegnerSchaden
                    } else {
                        println("${opfer3.name} ist durch seinen Schutz geschützt!\n")
                    }

                } else{
                    var attacke = atkName.elementAt(1)
                    println("${this.name} greift mit $attacke an!!")
                    Thread.sleep(SLEEP_TIME)
                    println("Alle sind durch einen Schutz geschützt!\n")
                }
            }

            in 61..75 -> {
                var attacke = atkName.elementAt(2)
                kannAngegriffenWerden = false
                println("${this.name} setzt $attacke ein und schützt sich!\n")
            }

            in 76..100 -> {
                var attacke = atkName.elementAt(3)
                println("${this.name} setzt $attacke und kann sich nicht wehren!\n")
            }
        }
    }
}
