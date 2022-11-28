package com.example.monoplug.activity

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.monoplug.R
import com.example.monoplug.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment

        navController = navHostFragment.navController
        binding.btmNavigation.setupWithNavController(navController)

        hideBottomNav()

        //click listener for toolbar img2.... (search)
        binding.homeToolbar.img2.setOnClickListener {
            if (navController.currentDestination?.id == R.id.socialFragment) {
                navController.navigate(R.id.searchFragment)
            }
            if (navController.currentDestination?.id == R.id.liveFragment) {
                navController.navigate(R.id.searchFragment)
            }
            if (navController.currentDestination?.id == R.id.homeFragment) {
                navController.navigate(R.id.messageFragment)
            }
            if (navController.currentDestination?.id == R.id.searchFragment) {
                navController.navigate(R.id.filterPopup)
            }
        }

        //click listener for toolbar img1 ...(back press)
        binding.homeToolbar.img.setOnClickListener {
            if (navController.currentDestination?.id == R.id.storyDetailsFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.newsDetailsFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.blogDetailsFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.createPostFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.searchFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.jobDetailsFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.postDetailsFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.searchFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.createPostFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.createStoryFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.userProfileFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.createJobFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.proposalDetailsFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.proposalDetails2Fragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.jobDetails2Fragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.jobDetails3Fragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.inviteFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.raiseDisputeFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.createRoomFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.roomsFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.artistProfileFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.messageFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.chatFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.myProfileFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.notificationsFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.archivedFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.editProfileFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.archivedFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.howItWorksFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.changePasswordFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.contactUsFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.roomUsersFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.inviteTwoFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.lessonFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.behindTheScenesFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.behindTheScenesTwoFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.createLessonRequestFragment) {
                navController.navigateUp()
            }
            if (navController.currentDestination?.id == R.id.createIdeaTradingSessionFragment) {
                navController.navigateUp()
            }

        }
    }

    // hiding the btm_Nav for fragments
    private fun hideBottomNav() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.inviteFragment || destination.id == R.id.createJobFragment
                || destination.id == R.id.newsDetailsFragment || destination.id == R.id.storyDetailsFragment
                || destination.id == R.id.blogDetailsFragment || destination.id == R.id.createPostFragment
                || destination.id == R.id.jobDetailsFragment || destination.id == R.id.searchFragment
                || destination.id == R.id.createRoomFragment || destination.id == R.id.inviteTwoFragment
                || destination.id == R.id.createIdeaTradingSessionFragment || destination.id == R.id.postDetailsFragment
                || destination.id == R.id.jobDetails2Fragment || destination.id == R.id.jobDetails3Fragment
                || destination.id == R.id.raiseDisputeFragment || destination.id == R.id.roomsFragment
                || destination.id == R.id.userProfileFragment || destination.id == R.id.artistProfileFragment
                || destination.id == R.id.messageFragment || destination.id == R.id.chatFragment
                || destination.id == R.id.notificationsFragment || destination.id == R.id.archivedFragment
                || destination.id == R.id.myProfileFragment || destination.id == R.id.editProfileFragment
                || destination.id == R.id.liveTwoFragment || destination.id == R.id.proposalDetails2Fragment
                || destination.id == R.id.proposalDetailsFragment || destination.id == R.id.howItWorksFragment
                || destination.id == R.id.contactUsFragment || destination.id == R.id.changePasswordFragment
                || destination.id == R.id.settingsFragment || destination.id == R.id.filterPopup
                || destination.id == R.id.giveRatingsPopup  || destination.id == R.id.roomUsersFragment
                || destination.id == R.id.lessonFragment || destination.id == R.id.behindTheScenesFragment
                || destination.id == R.id.behindTheScenesTwoFragment || destination.id == R.id.createLessonRequestFragment
                || destination.id == R.id.logoutPopup || destination.id == R.id.userStoryFragment
                || destination.id == R.id.createStoryFragment
            ) {
                binding.btmNavigation.visibility = View.GONE
            } else {
                binding.btmNavigation.visibility = View.VISIBLE
            }
        }
    }

    // for hiding the keyboard
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }

}