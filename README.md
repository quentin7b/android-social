Social
===

![Version 2.0.0](https://img.shields.io/badge/version-2.0.0-green.svg) ![Hosted on Jitpack.io](https://img.shields.io/badge/hosting-jitpack-blue.svg)

_TL;DR A simple library to open social networks on Android_

## Usage

This library is made of one `Context` extension and several `SocialNetwork`s.
To open a social network just call it from a `Context`

For example

```Kotlin
baseContext.openSocialNetwork(Twitter("kleinquentin"))
```

(or in **OLD** Java)

```Java
Context_extKt.openSocialNetwork(getBaseContext(), new Twitter("kleinquentin"));
```

Then the library will either open the twitter app or start the web browser on the given profile.

> Look at the doc because if the paramter format is incorrect, it will throw an `IllegalArgumentException`

## Supported Social Networks

- [x] Twitter
- [x] Facebook
- [x] Instagram
- [x] LinkedIn
- [x] Youtube
- [ ] Tumblr
- [ ] Meetup

## Install

Add it over [jitpack.io](https://jitpack.io/docs/ANDROID/)


In the *project* `build.gradle`

```gradle
allprojects {
    repositories {
        jcenter()
        // Maybe google() 
        maven { url "https://jitpack.io" }
    }
}
```

In the *module* `build.gradle`

```gradle
dependencies {
    implementation 'com.github.quentin7b:android-social:2.0.0'
}
```

## Extends

If a social network is not yet supported, but you know how to build it, just implements `SocialNetwork` and give it to `openSocialNetwork()` as a parameter.

To implement `SocialNetwork`, you'll have to:
- override `buildWebUrl()` which builds the URL to open by the browser if the app is not foud
- override `buildIntentUri()` which builds the Intent.ACTION_VIEW's extra data

Also, feel free to add the implementation in this project by opening a pull request.

## License

Project is under [Apache 2](LICENSE)
Feel free to improve by opening an issue or a pull request