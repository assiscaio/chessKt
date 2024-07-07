package piece

import GamePanel

class Pawn(color: Int, col: Int, row: Int): Piece(color, col, row) {
    init {
        image = if(color == GamePanel.WHITE)
            getImage("/piece/w-pawn")!!
        else
            getImage("/piece/b-pawn")!!
    }
}