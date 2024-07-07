import piece.*
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel

class GamePanel: JPanel(), Runnable {
    companion object {
        const val WIDTH = 1100
        const val HEIGHT = 800
        const val FPS = 60
        const val WHITE = 0
        const val BLACK = 1
        lateinit var pieces: MutableList<Piece>
        var simPieces: MutableList<Piece> = mutableListOf<Piece>()
    }

    private val board: Board = Board()
    private val gameThread: Thread = Thread()
    val currentColor: Int = WHITE

    init {
        preferredSize = Dimension(WIDTH, HEIGHT)
        background = Color.BLACK
        setPieces()
        copyPieces(pieces, simPieces)
    }

    fun launchGame() {
        gameThread.run {
            Thread(this)
            start()
        }
    }

    private fun setPieces() {
        pieces = mutableListOf<Piece>(
            Pawn(WHITE, 0, 6),
            Pawn(WHITE, 1, 6),
            Pawn(WHITE, 2, 6),
            Pawn(WHITE, 3, 6),
            Pawn(WHITE, 4, 6),
            Pawn(WHITE, 5, 6),
            Pawn(WHITE, 6, 6),
            Pawn(WHITE, 7, 6),
            Rook(WHITE, 0, 7),
            Rook(WHITE, 7, 7),
            Knight(WHITE, 1, 7),
            Knight(WHITE, 6,7),
            Bishop(WHITE, 2, 7),
            Bishop(WHITE, 5, 7),
            Queen(WHITE, 3,7),
            King(WHITE, 4, 7),
            // BLACK
            Pawn(BLACK, 0, 1),
            Pawn(BLACK, 1, 1),
            Pawn(BLACK, 2, 1),
            Pawn(BLACK, 3, 1),
            Pawn(BLACK, 4, 1),
            Pawn(BLACK, 5, 1),
            Pawn(BLACK, 6, 1),
            Pawn(BLACK, 7, 1),
            Rook(BLACK, 0, 0),
            Rook(BLACK, 7, 0),
            Knight(BLACK, 1, 0),
            Knight(BLACK, 6,0),
            Bishop(BLACK, 2, 0),
            Bishop(BLACK, 5, 0),
            Queen(BLACK, 3,0),
            King(BLACK, 4, 0)
        )
    }

    private fun copyPieces(source: MutableList<Piece>, target: MutableList<Piece>) {
        target.clear()
        for ((index, piece) in source.withIndex()) {
            target.add(piece)
        }
    }

    override fun run() {
        val drawInterval: Double = (1000000000 / FPS).toDouble()
        var delta: Double = 0.0
        var lastTime: Long = System.nanoTime()
        var currentTime: Long

        while(gameThread != null) {
            currentTime = System.nanoTime()
            delta += (currentTime - lastTime) / drawInterval
            lastTime = currentTime

            if(delta >= 1) {
                update()
                repaint()
                delta--
            }
        }
    }

    private fun update(): Unit {}

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        val g2 = g as Graphics2D
        board.draw(g2)

        for ((index, piece) in simPieces.withIndex()) {
            piece.draw(g2)
        }
    }
}