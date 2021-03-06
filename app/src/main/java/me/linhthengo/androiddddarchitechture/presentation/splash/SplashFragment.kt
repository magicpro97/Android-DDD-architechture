package me.linhthengo.androiddddarchitechture.presentation.splash

import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import me.linhthengo.androiddddarchitechture.R
import me.linhthengo.androiddddarchitechture.core.platform.BaseFragment
import me.linhthengo.androiddddarchitechture.utils.FirebaseAuthManager
import javax.inject.Inject

class SplashFragment : BaseFragment() {

    @Inject
    lateinit var firebaseAuthManager: FirebaseAuthManager

    override fun layoutId(): Int = R.layout.splash_fragment

    init {
        lifecycleScope.launchWhenStarted {
            delay(3000)
            val user = firebaseAuthManager.getCurrentUser()
            Toast.makeText(context, "Loading finished", Toast.LENGTH_SHORT)
                .show()
            if (user != null) {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
            } else {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToSignInFragment())
            }
        }
    }
}
