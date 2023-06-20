import characterKlassen.Hero
import enemieKlassen.Enemie
import inventory.Item
import inventory.SchutzStein
import inventory.Trank
import inventory.Wurfmesser

class Arena {

    var charListe: MutableList<Hero> = mutableListOf()
    var enemieListe: MutableList<Enemie> = mutableListOf()
    var inventoryList: MutableMap<Item, Int> = mutableMapOf(
        Trank("Heiltrank", "Heilung") to 10,
        SchutzStein("Schutzstein", "Support") to 10,
        Wurfmesser("Wurfmesser", "Schaden") to 10,
    )
}