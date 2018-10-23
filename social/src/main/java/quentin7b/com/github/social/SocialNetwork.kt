package quentin7b.com.github.social


/**
 * This interface represents a social network.
 */
interface SocialNetwork {
    /**
     * A full url to open if the app is not found on the device.
     */
    fun buildWebUrl(): String

    /**
     * A way to build an Intent ACTION_VIEW data used to start the app if it is installed.
     */
    fun buildIntentUri(): String
}
