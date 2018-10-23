package quentin7b.com.github.networks

import quentin7b.com.github.social.SocialNetwork

/**
 * Twitter page on the profile given.
 *
 * @param profileId the Twitter profile to open (no @, nor http...)
 */
class Twitter(private val profileId: String) : SocialNetwork {

    init {
        if (profileId.isEmpty() || profileId.startsWith("https") || profileId.startsWith('@')) {
            throw IllegalArgumentException("profileId for Twitter must only be the account name (no @ nor http)")
        }
    }

    override fun buildWebUrl() = "$URL_SCHEME$profileId"

    override fun buildIntentUri() = "$INTENT_SCHEME$profileId"

    companion object {
        private const val INTENT_SCHEME = "twitter://user?screen_name="
        private const val URL_SCHEME = "https://www.twitter.com/"
    }
}