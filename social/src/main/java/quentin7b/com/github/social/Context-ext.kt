package quentin7b.com.github.social

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri

/**
 * Check if a social package exists and then open a specific page on it.
 * If the package does not exists, it opens the web browser on the page
 *
 * @param socialNetwork the network to open
 */
fun Context.openSocialNetwork(socialNetwork: SocialNetwork) {
    var appIntent = Intent(Intent.ACTION_VIEW, Uri.parse(socialNetwork.buildIntentUri()))
    val matchingActivities = packageManager.queryIntentActivities(appIntent, PackageManager.MATCH_DEFAULT_ONLY)

    if (matchingActivities.isEmpty()) {
        // No Activity found for this intent so start the browser
        appIntent = Intent(Intent.ACTION_VIEW, Uri.parse(socialNetwork.buildWebUrl()))
    }

    startActivity(appIntent)
}
