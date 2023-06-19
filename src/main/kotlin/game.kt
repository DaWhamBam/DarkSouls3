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




//    Hier beginnt das Spiel

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

        spielerZug(arena)

        gegnerZug(arena)

        heldGestorben(arena)

    } while (arena.charListe.isNotEmpty() && arena.enemieListe.isNotEmpty())


    if (arena.enemieListe.isEmpty()) {
        println("Du hast gesiegt die Welt ist gerettet und kann erneut erblühen! Good Job, Mate!")
    } else {
        println("Das Böse hat gesiegt und die Welt wird untergehen! Blöd gelaufen...")
    }
}


/*
Der Angriff der Heldentruppe findet hier statt.
Anfangs soll entschieden werden ob das Inventar aufgerufen werden soll oder ein Angriff
stattfinden soll.
Bevor der Angirff gewählt wird, wird ein Ziel(Gegner) ausgesucht.
 */
fun spielerZug(arena: Arena) {

// Auswahl Kampf / Inventory
    for (held in arena.charListe) {

        if (arena.enemieListe.size == 0) break

//    Wer soll angegriffen werden
        if (arena.enemieListe.size > 1) {
            println("Wenn möchtest du engreifen?")
            println(
                """
            1: ${(arena.enemieListe.elementAt(0).name)}
            2: ${(arena.enemieListe.elementAt(1).name)}
          
        """.trimIndent()
            )
            var eingabe = readln()
            var index = eingabe.toInt() - 1
            var gegnerWahl = arena.enemieListe.elementAt(index)
            held.atkChar(gegnerWahl, arena)

            if (gegnerWahl.hp <= 0) {
                arena.enemieListe.remove(gegnerWahl)
                println("${gegnerWahl.name} wurde besiegt!\n")
            }


        } else {
            held.atkChar(arena.enemieListe[0], arena)
            if (arena.enemieListe[0].hp == 0) {
                arena.enemieListe.remove(arena.enemieListe[0])
                println("Gegner wurde besiegt!\n")
                break
            }

        }
//    Inventar evtl Fun
    }
}


    /* In der Funktion werden über die for Schleife die einzelnen objekte in der Liste genommen um einen Angriff auszuführen.
Der Drache wird immer der erste Gegner sein und hat inherhalb der Angriffs Funktion die Möglichkeit weiter Gegner
erscheinen zu lassen.
Damit das alles klappt wird eine Kopie der enemieListe erstellt.
 */

    fun gegnerZug(arena: Arena) {
        for (enemie in arena.enemieListe.toList()) {
            if (enemie is Dragon) {
                if (enemie.hp > 0) {

                    var helden = arena.charListe.random()
                    enemie.angriffGegner(helden, arena)
                } else {
                    arena.enemieListe.remove(enemie)
                }
                continue
            }
            if (enemie.hp > 0) {

                var helden = arena.charListe.random()
                enemie.angriffGegner(helden, arena)
            } else {
                arena.enemieListe.remove(enemie)
            }
        }
    }

    /*
Hier wird kontrolliert ob ein Held noch am Leben ist und aus der Liste entfernt.
 */
    fun heldGestorben(arena: Arena) {
        for (held in arena.charListe) {
            if (held.hp <= 0)
                arena.charListe.remove((held))
        }
    }


