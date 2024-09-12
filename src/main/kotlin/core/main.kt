package core

fun main() {
    println("Bienvenido al Buscaminas!")
    println("Selecciona la modalidad de juego:")
    println("1. Fácil (8x8, 10 minas)")
    println("2. Medio (16x16, 40 minas)")
    println("3. Difícil (24x24, 99 minas)")

    val choice = readLine()?.toIntOrNull()  // Leer la opción seleccionada por el usuario y convertirla a Int

    val board = when (choice) {
        1 -> Board.createEasyBoard()   // Crear un tablero fácil
        2 -> Board.createMediumBoard() // Crear un tablero medio
        3 -> Board.createHardBoard()   // Crear un tablero difícil
        else -> {
            println("Opción no válida. Se selecciona el modo fácil por defecto.")
            Board.createEasyBoard()  // Valor predeterminado si la entrada es inválida
        }
    }

    board.displayBoard()  // Mostrar el tablero seleccionado
}
