package com.example.filbertanggriawan.Message.Tutorial

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.filbertanggriawan.Message.Tutorial.TutorialMessageActivity

class TutorialFragmentAdapter (
    activity: TutorialMessageActivity,
    private val fragments: List<Fragment>
)  : FragmentStateAdapter(activity)  {
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}