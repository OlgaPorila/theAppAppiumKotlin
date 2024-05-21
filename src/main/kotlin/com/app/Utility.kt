package appUI.com

open class Utility {

    fun getAdbPath(): Any {
        val osName = System.getProperty("os.name").lowercase()
        return when {
            osName.contains("windows") -> "C:\\Users\\${System.getProperty("user.name")}\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb"
            osName.contains("mac") -> "/Users/${System.getProperty("user.name")}/Library/Android/sdk/platform-tools/adb"
            osName.contains("linux") -> "/home/${System.getProperty("user.name")}/Android/Sdk/platform-tools/adb"
            else -> throw IllegalStateException("Unsupported operating system.")
        }
    }

}
