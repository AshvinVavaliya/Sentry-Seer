package com.auctionmobility.auctions.sentrydemo

import io.sentry.android.core.SentryAndroid
import io.sentry.SentryOptions.BeforeSendCallback
import io.sentry.Hint
import android.app.Application
import io.sentry.SentryEvent
import io.sentry.SentryLevel

class MyApplication : Application() {
  override fun onCreate() {
    super.onCreate()

    SentryAndroid.init(this) { options ->
      options.dsn = "https://c305f838f76af995973bf343af8fcc2b@o4509591568449536.ingest.us.sentry.io/4509591575658496"
      // Add a callback that will be used before the event is sent to Sentry.
      // With this callback, you can modify the event or, when returning null, also discard the event.
      options.beforeSend =
        BeforeSendCallback { event: SentryEvent, hint: Hint ->
          if (SentryLevel.DEBUG == event.level) {
            null
          } else {
            event
          }
        }
    }
  }
}
