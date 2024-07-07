import java.awt.Color
import java.awt.Graphics2D

class Board() {
    companion object {
        const val SQUARE_SIZE = 100
        const val HALF_SQUARE_SIZE = SQUARE_SIZE / 2
    }

    val MAX_COL = 8
    val MAX_ROW = 8

    fun draw(g2: Graphics2D): Unit {
        var c = 0
        for (row in 0 until MAX_ROW) {
            for (col in 0 until MAX_COL) {
                if(c == 0) {
                    g2.color = Color(210, 165, 125)
                    c = 1
                } else {
                    g2.color = Color(175, 115, 70)
                    c = 0
                }
                g2.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE)
            }
            c = if(c == 0)
                1
            else
                0
        }
    }
}