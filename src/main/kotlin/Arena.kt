import characterKlassen.Hero
import enemieKlassen.Enemie
import inventory.Item
import inventory.ProtectionStone
import inventory.Potion
import inventory.ThrowingKnife

class Arena {
    /*
    Here are the lists of enemies, heroes and the inventory.
     */
    var charList: MutableList<Hero> = mutableListOf()
    var enemieList: MutableList<Enemie> = mutableListOf()
    var inventoryList: MutableMap<Item, Int> = mutableMapOf(
        Potion("Healpotion", "Healing") to 10,
        ProtectionStone("Protection Stone", "Support") to 10,
        ThrowingKnife("Throwing Knife", "Damage") to 10,
    )

    var menueList: MutableList<String> = mutableListOf(
        "1: Select attack!",
        "2: Open inventory."
    )
}