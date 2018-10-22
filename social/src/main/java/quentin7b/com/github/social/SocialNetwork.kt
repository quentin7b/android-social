package quentin7b.com.github.social


/**
 * This class represents a social network.
 *
 * @param packageName the app package name, used to determine if the app is installed or not.
 */
abstract class SocialNetwork(val packageName: String) {
    /**
     * A full url to open if the app is not found on the device.
     */
    abstract fun buildWebUrl(): String

    /**
     * A way to build an Intent ACTION_VIEW data used to start the app if it is installed.
     */
    abstract fun buildIntentUri(): String
}
