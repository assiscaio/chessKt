package piece

class King(color: Int, col: Int, row: Int) : Piece(color, col, row) {
    init {
        image = if(color == GamePanel.WHITE)
            getImage("/piece/w-king")!!
        else
            getImage("/piece/b-king")!!
    }
}