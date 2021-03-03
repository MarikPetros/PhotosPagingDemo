package com.marik.getphotos.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.marik.getphotos.R
import com.marik.getphotos.core.model.Weather
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModel()
    private lateinit var email: com.google.android.material.textfield.TextInputEditText
    private lateinit var password: com.google.android.material.textfield.TextInputEditText
    private lateinit var logIn: com.google.android.material.button.MaterialButton
    private lateinit var loginLayout: androidx.constraintlayout.widget.ConstraintLayout


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        loginLayout = root.findViewById(R.id.layout_login)
        email = root.findViewById(R.id.text_email)
        password = root.findViewById(R.id.text_input_password)
        logIn = root.findViewById(R.id.btn_log_in)
        var weather: Weather
        logIn.setOnClickListener {
            lifecycleScope.launch {
                weather = loginViewModel.onEnterButtonClick()
                loginLayout.visibility = View.GONE
                showSnackBar(weather)
            }
        }
        return root
    }

    private fun showSnackBar(weather: Weather) {
        val text = " %s%n температура %dC%n облачность: %s%n влажность %d"
        Snackbar.make(
            requireContext(),
            loginLayout,
            text.format(
                weather.name,
                weather.main.temp,
                weather.weather[0].description,
                weather.main.humidity
            ),
            BaseTransientBottomBar.LENGTH_LONG
        )
    }

}