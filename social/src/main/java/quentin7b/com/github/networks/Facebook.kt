package quentin7b.com.github.networks

import quentin7b.com.github.social.SocialNetwork

/**
 * A Facebook item
 *
 * @param type the type of the facebook item (EVENT, GROUP or PERSON)
 * @param pageId the page id to open (profile name, event id or page id) not the full url
 */
class Facebook(private val type: Type, private val pageId: String) : SocialNetwork {

    init {
        // A facebook page id must be provided not empty
        if (pageId.isEmpty()) {
            throw IllegalArgumentException("pageId of a Facebook item must not be empty")
        }
    }

    enum class Type {
        EVENT, GROUP, PERSON, PAGE
    }

    override fun buildWebUrl() = buildTarget()

    override fun buildIntentUri() = "$INTENT_SCHEME${buildTarget()}"

    private fun buildTarget(): String {
        val urn = "https://www.facebook.com/" + when (type) {
            Type.EVENT -> "events/"
            Type.GROUP -> "groups/"
            else -> ""
        }
        if (pageId.isNotEmpty()) {
            return "$urn$pageId"
        } else {
            throw IllegalArgumentException("Facebook item to open must be provided")
        }
    }

    companion object {
        private const val INTENT_SCHEME = "fb://facewebmodal/f?href="
    }
}