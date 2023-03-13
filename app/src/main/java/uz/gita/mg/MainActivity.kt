package uz.gita.mg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.mg.navigation.AppNavigator
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var appNavigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appNavigator.navigationFlow.onEach { navigation ->
            navigation.invoke(findNavController(R.id.navHost))
        }.launchIn(lifecycleScope)
    }
}