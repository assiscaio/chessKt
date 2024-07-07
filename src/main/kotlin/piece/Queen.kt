package piece

class Queen(color: Int, col: Int, row: Int) : Piece(color, col, row) {
    init {
        image = if(color == GamePanel.WHITE)
            getImage("/piece/w-queen")!!
        else
            getImage("/piece/b-queen")!!
    }
}