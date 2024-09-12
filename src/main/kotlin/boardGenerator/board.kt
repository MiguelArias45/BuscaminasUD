// Representa el tablero del juego de Buscaminas
class Board(private val rows: Int, private val cols: Int) {
    // Matriz bidimensional que representa las celdas del tablero
    private val cells: Array<Array<Cell>> = Array(rows) { Array(cols) { Cell() } }

    // Inicializa el tablero con celdas vacías
    init {
        initializeBoard()
    }

    // Método para inicializar el tablero con celdas vacías
    private fun initializeBoard() {
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                cells[row][col] = Cell()  // Inicializa cada celda
            }
        }
    }

    // Método para mostrar el tablero (solo para pruebas y depuración)
    fun displayBoard() {
        for (row in cells) {
            for (cell in row) {
                print(" ? ")  // Muestra un "?" para representar celdas no reveladas
            }
            println()
        }
    }
}

// Clase que representa una celda en el tablero de Buscaminas
class Cell {
    // Por ahora, no agregamos lógica adicional; solo una clase vacía.
}   