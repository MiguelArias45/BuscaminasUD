package boardGenerator

import kotlin.random.Random

// Representa el tablero del juego de Buscaminas
class Board(private val rows: Int, private val cols: Int, private val numMines: Int) {
    private val cells: Array<Array<Cell>> = Array(rows) { Array(cols) { Cell() } }

    // Inicializa el tablero con celdas vacías
    init {
        initializeBoard()
        placeMines()  // Coloca las minas en el tablero
    }

    // Método para inicializar el tablero con celdas vacías
    private fun initializeBoard() {
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                cells[row][col] = Cell()  // Inicializa cada celda
            }
        }
    }

    // Método para colocar minas aleatoriamente en el tablero
    private fun placeMines() {
        var minesPlaced = 0
        while (minesPlaced < numMines) {
            val randomRow = Random.nextInt(rows)
            val randomCol = Random.nextInt(cols)
            
            if (!cells[randomRow][randomCol].hasMine) {  // Verificar que no haya una mina ya
                cells[randomRow][randomCol].hasMine = true
                minesPlaced++
            }
        }
    }

    // Método para mostrar el tablero (solo para pruebas y depuración)
    fun displayBoard() {
        for (row in cells) {
            for (cell in row) {
                print(if (cell.isRevealed) {
                    if (cell.hasMine) " * " else " . "  // Muestra "*" para minas reveladas y "." para celdas reveladas sin minas
                } else if (cell.isFlagged) {
                    " F "  // Muestra "F" para una celda marcada
                } else {
                    " ? "  // Muestra "?" para celdas no reveladas
                })
            }
            println()
        }
    }

    // Método para revelar una celda
    fun revealCell(row: Int, col: Int): Boolean {
        if (cells[row][col].hasMine) {
            println("¡Boom! Has revelado una mina. ¡Perdiste!")
            return false  // El jugador pierde
        }
        // Aquí podríamos añadir la lógica para revelar celdas vacías y números
        cells[row][col].isRevealed = true
        return true
    }

    // Método para marcar o desmarcar una celda como sospechosa de tener una mina
    fun markCell(row: Int, col: Int) {
        if (!cells[row][col].isRevealed) {  // No se puede marcar una celda ya revelada
            cells[row][col].isFlagged = !cells[row][col].isFlagged  // Alterna entre marcado y no marcado
        }
    }

    // Método para verificar si todas las celdas sin minas han sido reveladas
    fun checkWin(): Boolean {
        for (row in cells) {
            for (cell in row) {
                if (!cell.hasMine && !cell.isRevealed) {
                    return false  // Si hay una celda no revelada que no tiene mina, el jugador no ha ganado aún
                }
            }
        }
        println("¡Felicidades! Has revelado todas las celdas sin minas. ¡Ganaste!")
        return true
    }
}

// Clase que representa una celda en el tablero de Buscaminas
class Cell {
    var hasMine: Boolean = false  // Indica si hay una mina en esta celda
    var isRevealed: Boolean = false  // Indica si la celda ha sido revelada
    var isFlagged: Boolean = false  // Indica si el jugador ha marcado esta celda con una bandera

    fun display(): String {
        return when {
            isFlagged -> "F"  // Muestra "F" para una celda marcada
            isRevealed -> if (hasMine) "*" else " "  // Muestra "*" si es una mina y está revelada
            else -> "?"
        }
    }
}