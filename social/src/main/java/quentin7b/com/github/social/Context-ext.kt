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
fun Context.openSocialNetwork(socialNetwork: SocialNetwork) =
        startActivity(
                Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(try {
                            // Try to resolve package of the app
                            packageManager.getApplicationInfo(socialNetwork.packageName, 0)
                            socialNetwork.buildIntentUri()
                        } catch (_: PackageManager.NameNotFoundException) {
                            // Social network is not installed
                            socialNetwork.buildWebUrl()
                        })
                )
        )