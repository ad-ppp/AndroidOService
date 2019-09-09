## Demo for test
Android 26及以上，在调用 startForegroundService 启动Service后，一定要及时调用 startForeground.
```
android.app.RemoteServiceException: Context.startForegroundService() did not then call Service.startForeground(): ServiceRecord{e2efc4 u0 com.xhb.androidoservice/.service.TestService}
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2126)
        at android.os.Handler.dispatchMessage(Handler.java:112)
        at android.os.Looper.loop(Looper.java:216)
        at android.app.ActivityThread.main(ActivityThread.java:7625)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:524)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:987)
```

## 查看 Activity 栈
- adb shell dumpsys activity services $package-name
- adb shell dumpsys activity activities