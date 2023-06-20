package enemieKlassen

import characterKlassen.Hero
import Arena
import SLEEP_TIME

class DarkMage(name: String, typ: String, hp: Int):
    Enemie(name, typ, hp)  {

    var attacks: MutableMap<String, Int> = mutableMapOf(
        "Feuerball" to 10,
        "Eispfeil" to 10, // Schaden über 2-5 Runden // noch nicht implementiert
        "Elektroblitz" to 10,
        "Schutzschild" to 0, // Schütz eine Runde den Enemie
    )
    override fun angriffGegner(hero: Hero, arena: Arena) {
        kannAngegriffenWerden = true

        if (hero.hatSchutzStein == true) {
            attacks["Feuerball"] = 5
            attacks["Eispfeil"] = 5
            attacks["Elektroblitz"] = 5

        } else {
            attacks["Feuerball"] = 10
            attacks["Eispfeil"] = 10
            attacks["Elektroblitz"] = 10
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
                        println("${opfer1.name} bekommt $gegnerSchaden und hat nur noch ${opfer1.hp} HP!!")
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
                        println("${opfer3.name} bekommt $gegnerSchaden und hat nur noch ${opfer3.hp} HP!!\n")
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
                if (hero.kannAngegriffenWerden == true) {
                    var attacke = atkName.elementAt(2)
                    println("${this.name} greift mit $attacke an!!")
                    Thread.sleep(SLEEP_TIME)
                    var gegnerSchaden = attacks[attacke]!!
                    var opfer = hero
                    opfer.hp -= gegnerSchaden
                    Thread.sleep(SLEEP_TIME)
                    println("${opfer.name} bekommt $gegnerSchaden und hat nur noch ${opfer.hp} HP!!\n")
                } else {
                    var attacke = atkName.elementAt(2)
                    println("${this.name} greift mit $attacke an!!")
                    Thread.sleep(SLEEP_TIME)
                    println("${hero.name} ist durch seinen Schutz geschützt!\n")
                }
            }

            in 76..100 -> {
                var attacke = atkName.elementAt(3)
            kannAngegriffenWerden = false
                    println("${this.name} setzt $attacke ein und schützt sich!\n")
            }
        }
    }
}