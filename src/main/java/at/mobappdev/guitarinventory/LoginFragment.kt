package at.mobappdev.guitarinventory

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import at.mobappdev.guitarinventory.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        val binding = DataBindingUtil.inflate<LoginFragmentBinding>(
            inflater, R.layout.login_fragment, container, false
        )

        // SafeArgs-Version of navigation
        binding.btnNewLogin.setOnClickListener { view: View ->

            if (!checkEMail(binding)) {

                binding.editTextMail.text?.let {

                    if (it.toString().isNotEmpty()) {

                        view.findNavController()
                            .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(binding.editTextMail.text.toString()))
                    } // end-if e-mail is empty
                } // end-if text is not set
            } // end-if eMail is null or empty
        } // end setOnClickListener

        binding.btnExistingLogin.setOnClickListener { view: View ->

            if (!checkEMail(binding)) {

                binding.editTextMail.text?.let {

                    if (it.toString().isNotEmpty()) {

                        view.findNavController()
                            .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(binding.editTextMail.text.toString()))
                    } // end-if e-mail is empty
                } // end-if text is not set
            } // end-if eMail is null or empty
        } // end setonClickListener


        return binding.root

    } // end onCreateView()

    /* ---------------------------------------------------------------------- */
    /* checkEMail: - check if EMail is empty                                  */
    /*             - post error message and do not navigat to welcome screen  */
    /* ---------------------------------------------------------------------- */
    fun checkEMail(binding: LoginFragmentBinding):Boolean {
        var mailError:Boolean

        mailError = false
        if (binding.editTextMail?.text.isNullOrEmpty()) {
            binding.editTextMail.error = getString(R.string.string_email_error)
            mailError = true
        } // end-if
        return mailError
    } // end fun checkEMail()

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).supportActionBar?.title = getString(R.string.app_name)
    }

} // end class LoginFragment