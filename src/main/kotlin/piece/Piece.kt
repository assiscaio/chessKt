package piece

import Board
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.io.IOException
import javax.imageio.ImageIO

open class Piece (
    val color: Int,
    val col: Int,
    val row: Int
){
    lateinit var image: BufferedImage
    val x: Int = getX(col)
    val y: Int = getY(row)
    val preCol: Int = col
    val preRow: Int = row

    fun getX(col: Int) = col * Board.SQUARE_SIZE
    fun getY(row: Int) = row * Board.SQUARE_SIZE

    fun getImage(imagePath: String): BufferedImage? {
        var image: BufferedImage? = null
        try {
            image = ImageIO.read(javaClass.getResourceAsStream(imagePath + ".png"))
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return image
    }

    fun draw(g2: Graphics2D): Unit {
        g2.drawImage(image, x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE, null)
    }
}