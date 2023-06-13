package enemieKlassen

class Zombie(name: String, typ: String, hp: Int, isBurning: Boolean, isPoisen: Boolean, isBleeding: Boolean, var strength: Int = 6):
    Enemie(name, typ, hp, isBurning, isPoisen, isBleeding) {

    var attacks: MutableMap<String, Int> = mutableMapOf(
        "Kratzer" to 10,
        "Gift" to 5, // Schaden über 2-5 Runden
        "Blocken" to 0,
        "Umfallen" to 0, // enemie setzt für eine Runde aus
    )
}