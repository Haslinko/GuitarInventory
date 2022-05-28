package at.mobappdev.guitarinventory

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import at.mobappdev.guitarinventory.databinding.NewguitarFragmentBinding
import at.mobappdev.guitarinventory.databinding.WelcomeFragmentBinding
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.activityViewModels

class NewguitarFragment : Fragment() {

    // The list and the detail-screen are sharing the same viewModel
    private val viewModel: GuitarinventoryViewModel by activityViewModels()

    // Declare spinner als member-variables
    private lateinit var productSpinner: EditText
    private lateinit var styleSpinner: EditText
    private lateinit var stringsSpinner: EditText
    private lateinit var descText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<NewguitarFragmentBinding>(
            inflater, R.layout.newguitar_fragment, container, false
        )

        productSpinner = binding.spinnerProduct
        styleSpinner = binding.spinnerStyle
        stringsSpinner = binding.spinnerStrings
        descText = binding.edittextdescription

        /*
        // -------------------------- Init of the Spinners ------------------ //
        /* Product */
        val adapter = context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.product_array, R.layout.support_simple_spinner_dropdown_item
            )
        }
        // Specify the layout to use when the list of choices appears
        adapter?.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        productSpinner.adapter = adapter

        /* Style */
        val adapter_style = context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.style_array, R.layout.support_simple_spinner_dropdown_item
            )
        }
        // Specify the layout to use when the list of choices appears
        adapter_style?.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        binding.spinnerStyle.adapter = adapter_style

        /* Strings */
        val adapter_strings = context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.string_array, R.layout.support_simple_spinner_dropdown_item
            )
        }
        // Specify the layout to use when the list of choices appears
        adapter_strings?.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        binding.spinnerStrings.adapter = adapter_strings
        */
        // ---------------- onClickListener -------------------------------- //

        binding.btnSave.setOnClickListener { view: View ->
           viewModel.addGuitar()
            view.findNavController()
                .navigate(NewguitarFragmentDirections.actionNewguitarFragmentToGuitarinventoryFragment())
        }

        binding.btnCancel.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(NewguitarFragmentDirections.actionNewguitarFragmentToGuitarinventoryFragment())
        }

        // let the viewModel in layout know about my viewModel
        binding.guitarinventoryviewmodel = viewModel

        return binding.root
    } // end onCreateView()

    // ---------------------- private functions ---------------------------- //
    /*
    /* --------------------------------------------------------- */
    /* saveGuitarToViewModel():                                  */
    /*    Reading the input data of the Android widgets          */
    /*    when the save button is clicked.                       */
    /*    Creates a new entry in the guitarList of the viewModel */
    /*    Save also returns to the guitar list view              */
    /* --------------------------------------------------------- */
    private fun saveGuitarToViewModel() {

       // var product =  productSpinner.getSelectedItem().toString();
       // var style =  styleSpinner.getSelectedItem().toString();
       // var strings = try {
       //     stringsSpinner.getSelectedItem().toString().toInt();

        } catch (ex:Exception){
            0
        }
        var desc = descText.text.toString()

        val myGuitar = Guitar(product, strings, desc, style)

        //viewModel.addGuitar(myGuitar)
    } // end fun saveGuitarToViewModel()
    */

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).supportActionBar?.title = getString(R.string.app_name)
    }

} // end class NewguitarFragment()