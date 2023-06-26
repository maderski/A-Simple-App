package maderski.asimpleapp.userdirectory.presentation.userdetails

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import maderski.asimpleapp.userdirectory.data.repository.UserRepository
import maderski.asimpleapp.userdirectory.presentation.userdetails.mappers.UserModelToUserDetailsDataMapper
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class UserDetailsScreenViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    private val repository: UserRepository = mockk {
        coEvery { getUser(any()) } returns mockk()
    }

    private val userDetailsDataMapper: UserModelToUserDetailsDataMapper = mockk()
    private val viewModel: UserDetailsScreenViewModel = UserDetailsScreenViewModel(repository, userDetailsDataMapper)

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        every { userDetailsDataMapper.invoke(any(), any()) }.returns(mockk())
    }

    @Test
    fun `When getting user details is retrieved, the ShowingUserDetails state is shown`() {
        viewModel.init("1")
        dispatcher.scheduler.advanceUntilIdle()
        assert(viewModel.screenState.value is UserDetailsScreenViewModel.UIState.ShowingUserDetails)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `When getting user details Loading state is shown before ShowingUserDetails state is shown`() =
        runTest {
            val states = mutableListOf<UserDetailsScreenViewModel.UIState>()
            val job = launch {
                viewModel.screenState.collect {
                    states.add(it)
                }
            }
            viewModel.init("1")
            advanceUntilIdle()
            assert(states[0] is UserDetailsScreenViewModel.UIState.Loading)
            assert(states[1] is UserDetailsScreenViewModel.UIState.ShowingUserDetails)
            job.cancel()
        }

    @Test
    fun `When id is null ErrorOccurred state is shown`() {
        viewModel.init(null)
        dispatcher.scheduler.advanceUntilIdle()
        assert(viewModel.screenState.value is UserDetailsScreenViewModel.UIState.ErrorOccurred)
    }
}