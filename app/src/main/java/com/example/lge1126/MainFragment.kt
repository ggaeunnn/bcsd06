package com.example.lge1126

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {

    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val countTextView: TextView = view.findViewById(R.id.textViewCount)
        val buttonDialog: Button = view.findViewById(R.id.buttonDialog)

        buttonDialog.setOnClickListener {
            showAlertDialog(countTextView)
        }

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().finish()
                }
            }
        )

        return view
    }

    private fun showAlertDialog(countTextView: TextView) {
        AlertDialog.Builder(requireContext())
            .setTitle("Choose an Action")
            .setMessage("Select what you want to do.")
            .setPositiveButton("Reset") { _, _ ->
                count = 0
                countTextView.text = count.toString()
            }
            .setNeutralButton("Toast") { _, _ ->
                countTextView.text = "Toast Clicked!"
            }
            .setNegativeButton("Close") { _, _ ->
                requireActivity().finish()
            }
            .show()
    }
}
