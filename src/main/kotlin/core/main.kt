import boardGenerator.Board

fun main() {
    println("Selecciona la dificultad: (1) Fácil, (2) Medio, (3) Difícil")
    val difficulty = readLine()?.toIntOrNull()

    // Configuración del tamaño del tablero y número de minas según el nivel de dificultad
    val (rows, cols, numMines) = when (difficulty) {
        1 -> Triple(8, 8, 10)  // Fácil: 8x8 con 10 minas
        2 -> Triple(16, 16, 40)  // Medio: 16x16 con 40 minas
        3 -> Triple(24, 24, 99)  // Difícil: 24x24 con 99 minas
        else -> {
            println("Opción no válida. Seleccionando dificultad por defecto (Fácil).")
            Triple(8, 8, 10)
        }
    }

    val board = Board(rows, cols, numMines)
    board.displayBoard()
    
    while (true) {
        println("Escribe 'reveal x y' para revelar una celda o 'mark x y' para marcar/desmarcar una celda:")
        val input = readLine()?.split(" ")
        if (input == null || input.size != 3) {
            println("Entrada no válida. Intenta de nuevo.")
            continue
        }
        val action = input[0]
        val x = input[1].toIntOrNull() ?: continue
        val y = input[2].toIntOrNull() ?: continue

        when (action) {
            "reveal" -> {
                if (!board.revealCell(x, y)) break  // Termina el juego si el jugador pierde
                board.displayBoard()
            }
            "mark" -> {
                board.markCell(x, y)
                board.displayBoard()
            }
            else -> println("Acción no válida. Intenta de nuevo.")
        }

        if (board.checkWin()) break  // Termina el juego si el jugador gana
    }
}