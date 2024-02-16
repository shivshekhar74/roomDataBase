package com.example.myapplication

import android.app.Activity
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding
import com.example.myapplication.room.MyApp
import com.example.myapplication.room.User


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var activity:Activity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.buttonFirst.setOnClickListener {

           val user = User(name = "John Doe", age = 25)
            MyApp.database.userDao().insert(user)
            val allUsers = MyApp.database.userDao().getAllUsers()

            val dialogBuilder = AlertDialog.Builder(requireActivity())
            dialogBuilder.setMessage(allUsers.toString())
                // if the dialog is cancelable
                .setCancelable(false)
                .setPositiveButton("Ok", DialogInterface.OnClickListener {
                        dialog, id ->
                    dialog.dismiss()
                   // val allUsers = MyApp.database.userDao().deleteById(5)
                    val allUsers = MyApp.database.userDao().deleteAll();
                })

            val alert = dialogBuilder.create()
            alert.setTitle("Test")
            alert.show()

        }


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}