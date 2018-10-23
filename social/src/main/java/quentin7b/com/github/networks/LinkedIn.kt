package quentin7b.com.github.networks

import quentin7b.com.github.social.SocialNetwork


/**
 * A LinkedIn item
 *
 * @param type the type of the LinkedIn item (COMPANY or PERSON)
 * @param pageId the page id to open (profile name, company name) not the full url
 */
class LinkedIn(private val type: Type, private val pageId: String) : SocialNetwork("com.linkedin.android") {

    init {
        // A LinkedIn page id must be provided not empty
        if (pageId.isEmpty()) {
            throw IllegalArgumentException("pageId of a LinkedIn item must not be empty")
        }
    }

    enum class Type {
        COMPANY, PERSON
    }

    override fun buildWebUrl() = "$URL_SCHEME${buildTarget()}"

    override fun buildIntentUri() = "$INTENT_SCHEME${buildTarget()}"

    private fun buildTarget(): String {
        val urn = when (type) {
            Type.COMPANY -> "company/"
            Type.PERSON -> "in/"
        }
        if (pageId.isNotEmpty()) {
            return "$urn$pageId"
        } else {
            throw IllegalArgumentException("item or page for LinkedIn must be valid")
        }
    }

    companion object {
        private const val INTENT_SCHEME = "https://www.linkedin.com/"
        private const val URL_SCHEME = INTENT_SCHEME
    }

}