package quentin7b.com.github.social

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_social.*
import quentin7b.com.github.networks.Facebook
import quentin7b.com.github.networks.Instagram
import quentin7b.com.github.networks.LinkedIn
import quentin7b.com.github.networks.Twitter

class SocialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social)

        btn_social_fb.setOnClickListener {
            openSocialNetwork(Facebook(Facebook.Type.PAGE, "LilleFrance"))
        }

        btn_social_tw.setOnClickListener {
            openSocialNetwork(Twitter("kleinquentin"))
        }

        btn_social_in.setOnClickListener {
            openSocialNetwork(Instagram("quentin7b"))
        }

        btn_social_li.setOnClickListener {
            openSocialNetwork(LinkedIn(LinkedIn.Type.COMPANY, "lamobilery"))
        }
    }

}