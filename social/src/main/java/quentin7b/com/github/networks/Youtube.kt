package quentin7b.com.github.networks

import quentin7b.com.github.social.SocialNetwork

/**
 * A Youtube item
 *
 * @param type the type of the Youtube item (CHANNEL or VIDEO)
 * @param pageId the page id to open (channel id, video id) not the full url
 */
class Youtube(private val type: Type, private val pageId: String) : SocialNetwork("com.google.android.youtube") {

    init {
        // A LinkedIn page id must be provided not empty
        if (pageId.isEmpty()) {
            throw IllegalArgumentException("pageId of a Youtube item must not be empty")
        }
    }

    enum class Type {
        CHANNEL, PERSON
    }

    override fun buildWebUrl() = "$URL_SCHEME${buildTarget()}"

    override fun buildIntentUri() = "$INTENT_SCHEME$pageId"

    private fun buildTarget(): String {
        val urn = when (type) {
            Type.CHANNEL -> "channel/"
            Type.PERSON -> "watch?v="
        }
        if (pageId.isNotEmpty()) {
            return "$urn$pageId"
        } else {
            throw IllegalArgumentException("item or page for LinkedIn must be valid")
        }
    }

    companion object {
        private const val INTENT_SCHEME = "vnd.youtube:"
        private const val URL_SCHEME = "http://www.youtube.com/"
    }

}