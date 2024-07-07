package piece

class Rook(color: Int, col: Int, row: Int) : Piece(color, col, row) {
    init {
        image = if(color == GamePanel.WHITE)
            getImage("/piece/w-rook")!!
        else
            getImage("/piece/b-rook")!!
    }
}