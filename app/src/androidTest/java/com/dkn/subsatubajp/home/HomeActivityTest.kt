package com.dkn.subsatubajp.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dkn.subsatubajp.R
import com.dkn.subsatubajp.utilis.DummyData
import org.hamcrest.Matchers
import org.junit.Test
import org.junit.Rule

class HomeActivityTest {

    private val dummyMovie = DummyData.generateMovieListData()
    private val dummyTvShow = DummyData.generateTvShowListData()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun checkListMovie() {
        Espresso.onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun checkListTvShow() {
        Espresso.onView(ViewMatchers.withText("TV Show")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_shows))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_tv_shows))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun checkDetailMovie() {
        Espresso.onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        Espresso.onView(withId(R.id.textMovieName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.textMovieName))
            .check(ViewAssertions.matches(withText(dummyMovie[0].name)))
        Espresso.onView(withId(R.id.textMovieDescription))
            .check(ViewAssertions.matches(withText(dummyMovie[0].description)))
        Espresso.onView(withId(R.id.textPublishedYear))
            .check(ViewAssertions.matches(withText(dummyMovie[0].publishedYear)))
        Espresso.onView(withId(R.id.textDirectorName))
            .check(ViewAssertions.matches(withText(dummyMovie[0].director)))
        Espresso.onView(withId(R.id.webView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.textLinkNotFound))
            .check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())))
    }

    @Test
    fun checkMovieTrailerNotFound() {
        Espresso.onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(3))
        Espresso.onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(3,
                ViewActions.click()
            ))
        Espresso.onView(withId(R.id.textMovieName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.textMovieName))
            .check(ViewAssertions.matches(withText(dummyMovie[3].name)))
        Espresso.onView(withId(R.id.textMovieDescription))
            .check(ViewAssertions.matches(withText(dummyMovie[3].description)))
        Espresso.onView(withId(R.id.textPublishedYear))
            .check(ViewAssertions.matches(withText(dummyMovie[3].publishedYear)))
        Espresso.onView(withId(R.id.textDirectorName))
            .check(ViewAssertions.matches(withText(dummyMovie[3].director)))
        Espresso.onView(withId(R.id.webView))
            .check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())))
        Espresso.onView(withId(R.id.textLinkNotFound))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun checkDetailTvShow() {
        Espresso.onView(ViewMatchers.withText("TV Show")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        Espresso.onView(withId(R.id.textMovieName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.textMovieName))
            .check(ViewAssertions.matches(withText(dummyTvShow[0].name)))
        Espresso.onView(withId(R.id.textMovieDescription))
            .check(ViewAssertions.matches(withText(dummyTvShow[0].description)))
        Espresso.onView(withId(R.id.textPublishedYear))
            .check(ViewAssertions.matches(withText(dummyTvShow[0].publishedYear)))
        Espresso.onView(withId(R.id.textDirectorName))
            .check(ViewAssertions.matches(withText(dummyTvShow[0].creator)))
        Espresso.onView(withId(R.id.webView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.textLinkNotFound))
            .check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())))
    }

    @Test
    fun checkTvShowTrailerNotFound() {
        Espresso.onView(ViewMatchers.withText("TV Show")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_shows))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(4))
        Espresso.onView(withId(R.id.rv_tv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(4,
                ViewActions.click()
            ))
        Espresso.onView(withId(R.id.textMovieName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.textMovieName))
            .check(ViewAssertions.matches(withText(dummyTvShow[4].name)))
        Espresso.onView(withId(R.id.textMovieDescription))
            .check(ViewAssertions.matches(withText(dummyTvShow[4].description)))
        Espresso.onView(withId(R.id.textPublishedYear))
            .check(ViewAssertions.matches(withText(dummyTvShow[4].publishedYear)))
        Espresso.onView(withId(R.id.textDirectorName))
            .check(ViewAssertions.matches(withText(dummyTvShow[4].creator)))
        Espresso.onView(withId(R.id.webView))
            .check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())))
        Espresso.onView(withId(R.id.textLinkNotFound))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}