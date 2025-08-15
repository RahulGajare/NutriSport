import android.app.Application

class MyApplication : Application()
{
    override fun onCreate() {
        super.onCreate()
        Firebase.initialize(context = this)
    }
}