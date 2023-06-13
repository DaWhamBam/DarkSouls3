import characterKlassen.*
import enemieKlassen.*


val SLEEP_TIME: Long = 2000   // Von Gordon übernohmen


fun main() {


//    Charaktere

    var charListeMain = Arena()

    var krieger1 =  Worrior("Gladius", "Krieger", 300, 6)
    var magier1 = Mage("Lenni", "Magier", 250, false, false, false, 6)
    var heiler1 = Healer("Sienna", "Support", 250, false, false, false, 6 )

    charListeMain.charListe.add(krieger1)
    charListeMain.charListe.add(magier1)
    charListeMain.charListe.add(heiler1)



//    Gegner

    var enemieListeMain = Arena()

    var dragonBoss = Dragon("Smaug", "Feuer", 100, false, false, false)
    var zombie1 = Zombie("Zombie1", "Untot", 100, false, false, false)
    var zombie2 = Zombie("Zombie2", "Untot", 100, false, false, false)
    var zombie3 = Zombie("Zombie3", "Untot", 100, false, false, false)
    var zombie4 = Zombie("Zombie4", "Untot", 100, false, false, false)
    var evilMage1 = DarkMage("Dunkler Magier 1", "Magie", 100, false, false, false)
    var evilMage2 = DarkMage("Dunkler Magier 1", "Magie", 100, false, false, false)
    var evilMage3 = DarkMage("Dunkler Magier 1", "Magie", 100, false, false, false)
    var evilMage4 = DarkMage("Dunkler Magier 1", "Magie", 100, false, false, false)

    enemieListeMain.enemieListe.add(dragonBoss)



    while (charListeMain.charListe.isNotEmpty() && enemieListeMain.enemieListe.isNotEmpty()) {

        if (dragonBoss.hp > 0) {

            println("Der Krieger ist an der Reihe. Aktuell hast du ${krieger1.hp} HP.")
            var schadenVonKrieger = krieger1.atkChar()
            dragonBoss.hp -= schadenVonKrieger
            println("Du triffst!! ${dragonBoss.name} bekommt $schadenVonKrieger Schaden und hat nur noch ${dragonBoss.hp} HP")
        }

        if (dragonBoss.hp > 0) {

            println("Der Magier ist an der Reihe. Aktuell hast du ${magier1.hp} HP.")
            var schadenVonMagier = magier1.atkChar()
            dragonBoss.hp -= schadenVonMagier
            println("Du triffst!! ${dragonBoss.name} bekommt $schadenVonMagier Schaden und hat nur noch ${dragonBoss.hp} HP")
        }

        if (dragonBoss.hp > 0) {

            println("Der Heiler ist an der Reihe. Aktuell hast du ${heiler1.hp} HP.")
            var schadenVonHeiler = heiler1.atkChar()
            dragonBoss.hp -= schadenVonHeiler
            println("Du triffst!! ${dragonBoss.name} bekommt $schadenVonHeiler Schaden und hat nur noch ${dragonBoss.hp} HP")
        }

        if (dragonBoss.hp > 0) {

            println("Nun greift der Boss an!")
            var schadenGegenChar = dragonBoss.angriffGegner()
            Thread.sleep(SLEEP_TIME)
            var opfer = charListeMain.charListe.random()
            opfer.hp -= schadenGegenChar
            println("${opfer.name} bekommt $schadenGegenChar und hat nur noch ${opfer.hp} HP!!")

        } else {
            enemieListeMain.enemieListe.remove(dragonBoss)
            println("Gewonnen!")
        }
    }
}
