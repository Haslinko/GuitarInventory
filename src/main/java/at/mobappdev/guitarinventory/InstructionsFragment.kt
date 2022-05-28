package at.mobappdev.guitarinventory

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import at.mobappdev.guitarinventory.databinding.InstructionsFragmentBinding
import at.mobappdev.guitarinventory.databinding.WelcomeFragmentBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<InstructionsFragmentBinding>(
            inflater, R.layout.instructions_fragment, container, false
        )

        // SafeArgs-Version of navigation
        binding.btnGuitarList.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(InstructionsFragmentDirections.actionInstructionsFragmentToGuitarinventoryFragment())
        }

        //return inflater.inflate(R.layout.instructions_fragment, container, false)
        return binding.root
    } // end onCreateView()

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).supportActionBar?.title = getString(R.string.app_name)
    }

} // end class InstructionsFragment