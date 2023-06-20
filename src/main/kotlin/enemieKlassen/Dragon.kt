package enemieKlassen

import Arena
import SLEEP_TIME
import characterKlassen.Hero
import characterKlassen.Worrior

/*
Der Drache fungiert als erster Gegner (Boss) im spiel.
Er ist zu Beginn des Spiels bereits aktiv.
Der Drache und alle anderen Gegner im Spiel haben mehrere Angriffe die durch einen "Würdel", der von 1 - 100 geht, gewählt werden.
Ein Angriff vom Drachen ist das rufen eines Gehilfen. Es können gleichzeitig nur 2 Gegner (Drache und 1 Gehilfe) im Spiel sein.
Jder Angriff kann durch ein Block des Helden unterbunden werden.
Sollte ein Held einen Schutzstein tragen, wird der Schaden aller Attacken für eine Runde um 10 Punkte reduziert.
 */
class Dragon(name: String, typ: String, hp: Int):
    Enemie(name, typ, hp) {

    var attacks: MutableMap<String, Int> = mutableMapOf(
        "Feueratem" to 35,
        "Flügelschlag" to 30, // trifft alle
        "Rasierklaue" to 40,
        "Flügelblock" to 0, // schützt eine Runde den aktuellen Char
        "Hilferuf" to 0, // ruft einen Gehilfen zur Seite; Liste mit verschieden Monstern die random genommen werden. Maximal kann ein Gegner zur Hilfe gerufen werden.
        "Totbringer" to 65 // ein Angriff der eine geringere Change hat gewählt zu werden
    )

    override fun angriffGegner(hero: Hero, arena: Arena) {
        kannAngegriffenWerden = true

        if (hero.hatSchutzStein == true) {
            attacks["Feueratem"] = 25
            attacks["Flügelschlag"] = 20
            attacks["Rasierklaue"] = 30
            attacks["Totbringer"] = 55

        } else {
            attacks["Feueratem"] = 35
            attacks["Flügelschlag"] = 30
            attacks["Rasierklaue"] = 40
            attacks["Totbringer"] = 65
        }

        println("${this.name} macht sich bereit für seinen Angriff!")
        Thread.sleep(SLEEP_TIME)
        var atkName = attacks.keys

        var wuerfel = (1..100).random()
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
                        opfer1.hp -= gegnerSchaden
                        println("${opfer1.name} bekommt $gegnerSchaden HP Schaden und hat nur noch ${opfer1.hp} HP!!")
                    } else {
                        println("${opfer1.name} ist durch seinen Schutz geschützt!")
                    }

                    if(opfer2.kannAngegriffenWerden == true){
                        opfer2.hp -= gegnerSchaden
                        println("${opfer2.name} bekommt $gegnerSchaden HP Schaden und hat nur noch ${opfer2.hp} HP!!")
                    } else {
                        println("${opfer2.name} ist durch seinen Schutz geschützt!")
                    }

                    if(opfer3.kannAngegriffenWerden == true){
                        opfer3.hp -= gegnerSchaden
                        println("${opfer3.name} bekommt $gegnerSchaden HP Schaden und hat nur noch ${opfer3.hp} HP!!\n")
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
                        Zombie("Zombie159", "Untot", 200),
                        Zombie("Zombie3522", "Untot", 200),
                        Zombie("Zombie695", "Untot", 200),
                        Zombie("Zombie5132", "Untot", 200),
                        Zombie("Zombie451", "Untot", 200),
                        Zombie("Zombie9521", "Untot", 200),
                        Zombie("Zombie324", "Untot", 200),
                        Zombie("Zombie55", "Untot", 200),
                        Zombie("Zombie16", "Untot", 200),
                        Zombie("Zombie6231", "Untot", 200),
                        Zombie("Zombie3354", "Untot", 200),
                        Zombie("Zombie65", "Untot", 200),
                        Zombie("Zombie1", "Untot", 200),
                        Zombie("Zombie85", "Untot", 200),
                        DarkMage("Dunkler Magier Ron", "Magie", 200),
                        DarkMage("Dunkler Magier Harry", "Magie", 200),
                        DarkMage("Dunkler Magier Hermine", "Magie", 200),
                        DarkMage("Dunkler Magier Snape", "Magie", 200)
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