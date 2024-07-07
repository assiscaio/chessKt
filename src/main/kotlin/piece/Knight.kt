package piece

class Knight(color: Int, col: Int, row: Int) : Piece(color, col, row) {
    init {
        image = if(color == GamePanel.WHITE)
            getImage("/piece/w-knight")!!
        else
            getImage("/piece/b-knight")!!
    }
}