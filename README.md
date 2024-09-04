# BuscaminasUD
Estructura:
├── src/
│   ├── main/
│   │   ├── kotlin/
│   │   │   ├── core/           # Lógica principal del juego (clases del juego y reglas)
│   │   │   │   ├── Board.kt    # Clase para manejar el tablero del juego
│   │   │   │   ├── Cell.kt     # Clase para manejar las celdas del tablero
│   │   │   │   └── Game.kt     # Clase principal para la lógica del juego (gestión de estados)
│   │   │   ├── view/           # Interfaz de usuario
│   │   │   │   ├── ConsoleUI.kt  # Interfaz de usuario basada en consola
│   │   │   ├── utils/          # Funciones auxiliares y utilidades
│   │   │   │   └── Utils.kt    # Funciones utilitarias (por ejemplo, generador de números aleatorios)
│   ├── test/
│   │   └── kotlin/
│   │       ├── core/           # Pruebas para la lógica del juego
│   │       │   ├── BoardTest.kt # Pruebas unitarias para la clase Board
│   │       │   ├── CellTest.kt  # Pruebas unitarias para la clase Cell
│   │       │   └── GameTest.kt  # Pruebas unitarias para la clase Game
│   │       └── view/           # Pruebas para la interfaz de usuario
│   │           └── ConsoleUITest.kt # Pruebas unitarias para la clase ConsoleUI
├── README.md                  # Documentación del proyecto
