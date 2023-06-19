package enemieKlassen

import Arena
import SLEEP_TIME
import characterKlassen.Hero
import characterKlassen.Worrior

class Dragon(name: String, typ: String, hp: Int):
    Enemie(name, typ, hp) {

    var attacks: MutableMap<String, Int> = mutableMapOf(
        "Feueratem" to 35,
        "Flügelschlag" to 30, // trifft alle
        "Rasierklaue" to 40,
        "Flügelblock" to 0, // schützt eine Runde den aktuellen Char
        "Hilferuf" to 0, // ruft einen gehilfen zur seite  ---- evtl wieder separate Liste ---- Liste mit verschieden Monstern drinnen die random rausgenommen werden und dann aus der Liste entfernt werden
        "Totbringer" to 65 // ein Angriff der am besten eine geringere Change hat gewählt zu werden als die anderen
    )

    override fun angriffGegner(hero: Hero, arena: Arena) {
        kannAngegriffenWerden = true
        println("${this.name} macht sich bereit für seinen Angriff!")
        Thread.sleep(SLEEP_TIME)
        var atkName = attacks.keys

        var wuerfel = (87)
        when (wuerfel) {
            in 1..35 -> {
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

            in 36..51 -> {
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

            in 52..69 -> {
                if (hero.kannAngegriffenWerden == true) {
                    var attacke = atkName.elementAt(2)
                    println("${this.name} greift mit $attacke an!!")
                    Thread.sleep(SLEEP_TIME)
                    var gegnerSchaden = attacks[attacke]!!
                    var opfer = hero
                    opfer.hp -= gegnerSchaden
                    Thread.sleep(SLEEP_TIME)
                    println("${opfer.name} bekommt $gegnerSchaden und hat nur noch ${opfer.hp} HP!!\n")
                } else{
                    var attacke = atkName.elementAt(2)
                    println("${this.name} greift mit $attacke an!!")
                    Thread.sleep(SLEEP_TIME)
                    println("${hero.name} ist durch seinen Schutz geschützt!\n")
                }
            }

            in 70..85 -> {
                var attacke = atkName.elementAt(3)
                kannAngegriffenWerden = false
                println("${this.name} setzt $attacke ein und schützt sich!\n")
            }

            in 86..90 -> {

                if (arena.enemieListe.size <= 1) {
                    var hilfeRufListe = listOf<Enemie>(
                        Zombie("Zombie159", "Untot", 100),
                        Zombie("Zombie3522", "Untot", 100),
                        Zombie("Zombie695", "Untot", 100),
                        Zombie("Zombie5132", "Untot", 100),
                        Zombie("Zombie451", "Untot", 100),
                        Zombie("Zombie9521", "Untot", 100),
                        Zombie("Zombie324", "Untot", 100),
                        Zombie("Zombie55", "Untot", 100),
                        Zombie("Zombie16", "Untot", 100),
                        Zombie("Zombie6231", "Untot", 100),
                        Zombie("Zombie3354", "Untot", 100),
                        Zombie("Zombie65", "Untot", 100),
                        Zombie("Zombie1", "Untot", 100),
                        Zombie("Zombie85", "Untot", 100),
                        DarkMage("Dunkler Magier Ron", "Magie", 100),
                        DarkMage("Dunkler Magier Harry", "Magie", 100),
                        DarkMage("Dunkler Magier Hermine", "Magie", 100),
                        DarkMage("Dunkler Magier Snape", "Magie", 100)
                    ).random()

                    arena.enemieListe.add(hilfeRufListe)
                    println("Smaug hat sich Hilfe an seine Seite geholt!\n")
                } else {
                    println("Smaug´s Hilferufe wurde nicht erhört!\n")
                }
            }

            in 91..100 -> {
                if (hero.kannAngegriffenWerden == true) {
                    var attacke = atkName.elementAt(5)
                    println("${this.name} greift mit $attacke an!!")
                    Thread.sleep(SLEEP_TIME)
                    var gegnerSchaden = attacks[attacke]!!
                    var opfer = hero
                    opfer.hp -= gegnerSchaden
                    Thread.sleep(SLEEP_TIME)
                    println("${opfer.name} bekommt $gegnerSchaden und hat nur noch ${opfer.hp} HP!!\n")
                } else{
                    var attacke = atkName.elementAt(5)
                    println("${this.name} greift mit $attacke an!!")
                    Thread.sleep(SLEEP_TIME)
                    println("${hero.name} ist durch seinen Schutz geschützt!\n")
                }
            }
        }
    }
}