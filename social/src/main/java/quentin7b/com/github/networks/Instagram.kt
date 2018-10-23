package quentin7b.com.github.networks

import quentin7b.com.github.social.SocialNetwork

class Instagram(private val profileId: String) : SocialNetwork {

    init {
        if (profileId.isEmpty() || profileId.startsWith("https") || profileId.startsWith('@')) {
            throw IllegalArgumentException("profileId for Twitter must only be the account name (no @ nor http)")
        }
    }

    override fun buildWebUrl() = "$URL_SCHEME$profileId"

    override fun buildIntentUri() = "$INTENT_SCHEME$profileId"


    companion object {
        private const val INTENT_SCHEME = "https://instagram.com/_u/"
        private const val URL_SCHEME = "https://instagram.com/"
    }
}