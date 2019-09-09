package com.xhb.androidoservice.service

import android.app.*
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.xhb.androidoservice.R

class TestService : Service() {
    private val handler = Handler(Looper.getMainLooper())
    private val CHANNEL_ID = "com.xhb.androidoservice"
    private val FORGROUND_ID = 1

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (intent != null) {
                val type = intent.getIntExtra("type", 0)
                if (type == 1) {
                    val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
                    if (notificationManager != null) {
                        val notificationChannel =
                            NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT)
                        notificationChannel.description = "description"
                        notificationChannel.setSound(null, null)
                        notificationManager.createNotificationChannel(notificationChannel)

                        val pendingIntent = PendingIntent.getActivity(
                            this,
                            0, getOpenBrowserIntent("https://www.baidu.com"), 0
                        )

                        val notification = Notification
                            .Builder(this, CHANNEL_ID)
                            .setTicker("Nature")
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setChannelId(CHANNEL_ID)
                            .setContentTitle("Android")
                            .setContentText("Hello world")
                            .setContentIntent(pendingIntent)
                            .build()
                        notification.flags = notification.flags or Notification.FLAG_AUTO_CANCEL
                        startForeground(FORGROUND_ID, notification)

                        handler.postDelayed({
                            stopForeground(false)
                            stopSelf()      // 把服务停止掉

                            Log.d(CHANNEL_ID, "stop test service")
                            // useless
                            // notificationManager.cancel(FORGROUND_ID)
                        }, 3000)
                    }
                } else if (type == 3) {
                    stopForeground(true)
                } else {
                    Toast.makeText(this, "我是bg service", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return super.onStartCommand(intent, flags, startId)

    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    private fun getOpenBrowserIntent(url: String): Intent {
        return Intent(Intent.ACTION_VIEW, Uri.parse(url))
    }
}
