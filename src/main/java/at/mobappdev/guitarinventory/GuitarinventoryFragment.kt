package at.mobappdev.guitarinventory

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.marginTop
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import at.mobappdev.guitarinventory.databinding.GuitarinventoryFragmentBinding

class GuitarinventoryFragment : Fragment() {

    // The list and the detail-screen are sharing the same viewModel
    private  val viewModel: GuitarinventoryViewModel by activityViewModels()
    private lateinit var linearLayoutView : LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<GuitarinventoryFragmentBinding>(
            inflater, R.layout.guitarinventory_fragment, container, false
        )

        viewModel.guitarList.observe(this, Observer{
            updateList(it)
        })

        // SafeArgs-Version of navigation
        binding.fabToGuitarDetail.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(GuitarinventoryFragmentDirections.actionGuitarinventoryFragmentToNewguitarFragment()
                )
        }

        // get a reference to the linearLayout in the ScrollView
        linearLayoutView = binding.guitarlistlayout

        binding.lifecycleOwner = this

        return binding.root
    } // end onCreateView()

    private fun updateList(pGuitarList:MutableList<Guitar>) {

        // new LinearLayout to each item
        var myLinearLayout:LinearLayout

        // the textViews for the cardView
        var productTextView:TextView
        var styleTextView:TextView
        var stringsTextView:TextView
        var descriptionTextView:TextView

        // Position - Parameters
        val posX = 15.0f

        // the LayoutParams we use to add the cardView to the LinearLayout
        // therefore we need to have LinearLayout.Parameters
        val lpCardView: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                      LinearLayout.LayoutParams.WRAP_CONTENT);

        // the LayoutParams we use to add a textView to the CardView
        // therefore we need to have LinearLayout.Parameters
        val lpTextView: ViewGroup.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                 LinearLayout.LayoutParams.WRAP_CONTENT);


        pGuitarList.forEach { guitar->
            // For each guitar we add a cardView
            // The cardView holds:
            //    - textView for product
            //    - textView for style
            //    - textView for stringAmount
            //    - textView for description

            // Create new cardView
            myLinearLayout = LinearLayout(requireContext())

            myLinearLayout.setBackgroundColor(requireContext().getColor(R.color.purple_500))
            myLinearLayout.orientation = LinearLayout.VERTICAL

            // Create the Product textView and add to cardView
            productTextView = TextView(requireContext())
            productTextView.text = requireContext().getString(R.string.string_product) + ": " + guitar.product
            productTextView.setX ( posX )
            productTextView.layoutParams = lpTextView
            myLinearLayout.addView(productTextView)

            // Create the Style textView and add to cardView
            styleTextView = TextView(requireContext())
            styleTextView.text = requireContext().getString(R.string.string_guitar_style) + ": " + guitar.style
            styleTextView.setX ( posX )
            styleTextView.layoutParams = lpTextView
            myLinearLayout.addView(styleTextView)

            // Create the StringsAmount textView and add to cardView
            stringsTextView = TextView(requireContext())
            stringsTextView.text = requireContext().getString(R.string.string_stringamount) + ": " + guitar.strings
            stringsTextView.setX ( posX )
            stringsTextView.layoutParams = lpTextView
            myLinearLayout.addView(stringsTextView)

            // Create the desc textView and add to cardView
            descriptionTextView = TextView(requireContext())
            descriptionTextView.text = requireContext().getString(R.string.string_guitar_description) + ": " +guitar.description
            descriptionTextView.setX ( posX )
            descriptionTextView.layoutParams = lpTextView
            myLinearLayout.addView(descriptionTextView)

            // finally we add the cardView to the scrollView with a nice
            // margin to the next cardView
            //myCardView.layoutParams = lpCardView
            //var cardViewMarginParams:ViewGroup.MarginLayoutParams =
            //    myCardView.getLayoutParams() as  ViewGroup.MarginLayoutParams;
            //cardViewMarginParams.setMargins(4, 8, 4, 8);
            lpCardView.setMargins(24,8,24,8)
            //myCardView.requestLayout();
            myLinearLayout.layoutParams = lpCardView
            linearLayoutView.addView(myLinearLayout)
       } // end forEach (Guitar)

    } // end updateList()

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).supportActionBar?.title = getString(R.string.app_name)
    }

} // end GuitarinventoryFragment()