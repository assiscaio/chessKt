import javax.swing.JFrame

fun main() {
    val window: JFrame = JFrame("Simple chess").apply {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        isResizable = false
        setLocationRelativeTo(null)
        isVisible = true
    }

    val gamePanel = GamePanel()
    window.add(gamePanel)
    window.pack()

    gamePanel.launchGame()
}