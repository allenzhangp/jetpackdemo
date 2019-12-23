package com.treefintech.jetpack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import kotlinx.android.synthetic.main.fragment_profile.*


/*
*   Created by zhangping on 2019-12-23
*
*/
class UserProfileFragment : Fragment() {

   private val userProfileViewModel: UserProfileViewModel by viewModels(factoryProducer = {
        SavedStateViewModelFactory(
            activity!!.application,
            this,
            arguments
        )
    })

    companion object {
        fun newInstance(
            uid: String
        ): UserProfileFragment {
            val args = Bundle()
            args.putString("uid", uid)

            val fragment = UserProfileFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        userProfileViewModel = ViewModelProvider(
//            this,
//            SavedStateViewModelFactory(activity!!.application, this, arguments)
//        ).get(UserProfileViewModel::class.java)
        println("userid : ${userProfileViewModel.userId}")
        mTextView.text = userProfileViewModel.userId
    }
}