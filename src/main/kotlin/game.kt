import characterKlassen.*
import enemieKlassen.*


val SLEEP_TIME: Long = 2000   // Von Gordon übernohmen


fun main() {


//    Charaktere

    var charListeMain = Arena()

    var krieger1 = Worrior("Gladius", "Krieger", 10)
    var magier1 = Mage("Lenni", "Magier", 10)
    var heiler1 = Healer("Sienna", "Support", 10)

    charListeMain.charListe.add(krieger1)
    charListeMain.charListe.add(magier1)
    charListeMain.charListe.add(heiler1)




//    Gegner

    var enemieListeMain = Arena()

    var dragonBoss = Dragon("Smaug", "Feuer", 100)
    var zombie1 = Zombie("Zombie1", "Untot", 100)
    var zombie2 = Zombie("Zombie2", "Untot", 100)
    var zombie3 = Zombie("Zombie3", "Untot", 100)
    var zombie4 = Zombie("Zombie4", "Untot", 100)
    var evilMage1 = DarkMage("Dunkler Magier 1", "Magie", 100)
    var evilMage2 = DarkMage("Dunkler Magier 1", "Magie", 100)
    var evilMage3 = DarkMage("Dunkler Magier 1", "Magie", 100)
    var evilMage4 = DarkMage("Dunkler Magier 1", "Magie", 100)

    enemieListeMain.enemieListe.add(dragonBoss)



    println("""
        
        
        
    ----------Willkommen!!!---------
    
    Ein episches Abenteuer erwartet dich.
    
    Du bist mit einer Heldengruppe aus Krieger, Magier und Heiler unterwegs. Euch stellt sich ein 
    riesiger Drache entgegen. Ihn gilt es zu besigen und die Welt vor seinen Flammen zu schützen!
    
    Viel Erfolg!
    
    """.trimIndent())

    Thread.sleep(SLEEP_TIME)

    println("""
        
        Der Drache Smaug türmt sich vor euch auf und der Kampf beginnt!
        
        
    """.trimIndent())

    Thread.sleep(SLEEP_TIME)


    do {
        // Krieger kämpft
        if (dragonBoss.hp > 0 && krieger1.hp > 0) {

            krieger1.atkChar(dragonBoss)
        }

        // Magier kämpft
        if (dragonBoss.hp > 0 && magier1.hp > 0) {

            magier1.atkChar(dragonBoss)
        }

        // Heiler kämpft
        if (dragonBoss.hp > 0 && heiler1.hp > 0) {

            heiler1.atkChar(dragonBoss)
        }

        // Gegner kämpft
        if (dragonBoss.hp > 0) {

            var opfer = charListeMain.charListe.random()
            dragonBoss.angriffGegner(opfer)

        } else {
            enemieListeMain.enemieListe.remove(dragonBoss)
        }

        if (krieger1.hp < 0) {
            charListeMain.charListe.remove(krieger1)
        }

        if (magier1.hp < 0){
            charListeMain.charListe.remove(magier1)
        }

        if (heiler1.hp < 0){
            charListeMain.charListe.remove(heiler1)
        }


    } while (charListeMain.charListe.isNotEmpty() && enemieListeMain.enemieListe.isNotEmpty())

    if (enemieListeMain.enemieListe.isEmpty()) {
        println("Du hast gesiegt die Welt ist gerettet und kann erneut erblühen! Good Job, Mate!")
    } else {
        println("Das Böse hat gesiegt und die Welt wird untergehen! Blöd gelaufen...")
    }
}


