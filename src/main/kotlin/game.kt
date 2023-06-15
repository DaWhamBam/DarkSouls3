import characterKlassen.*
import enemieKlassen.*


val SLEEP_TIME: Long = 0   // Von Gordon übernohmen


fun main() {


//    Charaktere

    val arena = Arena()

    var krieger1 = Worrior("Gladius", "Krieger", 10)
    var magier1 = Mage("Lenni", "Magier", 10)
    var heiler1 = Healer("Sienna", "Support", 10)

    arena.charListe.add(krieger1)
    arena.charListe.add(magier1)
    arena.charListe.add(heiler1)




//    Gegner



    var dragonBoss = Dragon("Smaug", "Feuer", 100)

    arena.enemieListe.add(dragonBoss)



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

            heiler1.atkChar(dragonBoss, arena)
        }

        // Gegner kämpft
        if (dragonBoss.hp > 0) {

            var helden = arena.charListe.random()
            dragonBoss.angriffGegner(helden, arena)
//            arena.enemieListe.

        } else {
            arena.enemieListe.remove(dragonBoss)
        }

//        if(arena.enemieListe.elementAt(1) == Enemie("Zombie1", "Untot", 100))


        if (krieger1.hp < 0) {
            arena.charListe.remove(krieger1)
        }

        if (magier1.hp < 0){
            arena.charListe.remove(magier1)
        }

        if (heiler1.hp < 0){
            arena.charListe.remove(heiler1)
        }


    } while (arena.charListe.isNotEmpty() && arena.enemieListe.isNotEmpty())

    if (arena.enemieListe.isEmpty()) {
        println("Du hast gesiegt die Welt ist gerettet und kann erneut erblühen! Good Job, Mate!")
    } else {
        println("Das Böse hat gesiegt und die Welt wird untergehen! Blöd gelaufen...")
    }
}


