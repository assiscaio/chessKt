package piece

class Bishop(color: Int, col: Int, row: Int) : Piece(color, col, row) {
    init {
        image = if(color == GamePanel.WHITE)
            getImage("/piece/w-bishop")!!
        else
            getImage("/piece/b-bishop")!!
    }
}