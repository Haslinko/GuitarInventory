package at.mobappdev.guitarinventory

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import at.mobappdev.guitarinventory.databinding.LoginFragmentBinding
import at.mobappdev.guitarinventory.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<WelcomeFragmentBinding>(
            inflater, R.layout.welcome_fragment, container, false
        )
        // SafeArgs-Version of navigation
        binding.btnInstructions.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        }

        val args = WelcomeFragmentArgs.fromBundle(requireArguments())

        binding.textViewWelcome.text = getString(R.string.string_welcome, args.loginName)

        return binding.root
        //return inflater.inflate(R.layout.welcome_fragment, container, false)
    } // end onCreateView()

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).supportActionBar?.title = getString(R.string.app_name)
    }

} // end class WelcomeFragment