package com.ylt.viewpager2test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val categories = listOf(
        Category(0, "Dog", R.drawable.dog),
        Category(1, "Elephant", R.drawable.elephant),
        Category(2, "Lion", R.drawable.lion),
        Category(3, "Frog", R.drawable.frog),
        Category(4, "Rat", R.drawable.rat)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val offsetPx = resources.getDimensionPixelOffset(R.dimen.offset)

        viewPager2.orientation = ViewPager2.ORIENTATION_VERTICAL

        viewPager2.setPageTransformer { page, position ->
            val viewPager = page.parent.parent as ViewPager2
            val offset = position * -(2 * offsetPx + pageMarginPx)

            if (viewPager.orientation == ORIENTATION_HORIZONTAL) {
                if (ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                    page.translationX = -offset
                } else {
                    page.translationX = offset
                }
            } else {
                page.translationY = offset
            }
        }

        val localAdapter = CategoryAdapter()
        localAdapter.setItem(categories)
        viewPager2.adapter = localAdapter

        TabLayoutMediator(tabLayout, viewPager2,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = categories[0].name
                    }
                    1 -> {
                        tab.text = categories[1].name
                    }
                    2 -> {
                        tab.text = categories[2].name
                    }
                    3 -> {
                        tab.text = categories[3].name
                    }
                    4 -> {
                        tab.text = categories[4].name
                    }
                }
            }).attach()
    }
}