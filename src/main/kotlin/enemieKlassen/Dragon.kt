package enemieKlassen

import SLEEP_TIME
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

    fun angriffGegner(): Int{
        var atkName = attacks.keys
        var attacke = atkName.random()
        println("${this.name} greift mit $attacke an!!")
        Thread.sleep(SLEEP_TIME)
        var gegnerSchaden = attacks[attacke]!!
        return gegnerSchaden
    }



}