package maderski.asimpleapp.userdirectory.presentation.userlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.runtime.collectAsState
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import maderski.asimpleapp.userdirectory.domain.models.UserModel
import maderski.asimpleapp.userdirectory.domain.repository.UserRepository
import maderski.asimpleapp.userdirectory.presentation.userlist.mappers.UserModelSetToUserCardDataMapper
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

internal class UserListScreenViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    private val repository: UserRepository = mockk {
        coEvery { getAllUsers() } returns mockk()
    }
    private val userCardMapper: UserModelSetToUserCardDataMapper = mockk()
    private val viewModel: UserListScreenViewModel = UserListScreenViewModel(repository, userCardMapper)

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        every { userCardMapper.invoke(any(), any()) }.returns(listOf())
    }

    @Test
    fun `When getting all users is finished, the ShowingUserList state is shown`() {
        viewModel.loadUsers()
        dispatcher.scheduler.advanceUntilIdle()
        assert(viewModel.screenState.value is UserListScreenViewModel.UIState.ShowingUserList)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `When getting all users Loading state is shown before ShowingUserList state is shown`() =
        runTest {
            val states = mutableListOf<UserListScreenViewModel.UIState>()
            val job = launch {
                viewModel.screenState.collect {
                    states.add(it)
                }
            }
            viewModel.loadUsers()
            advanceUntilIdle()
            assert(states[0] is UserListScreenViewModel.UIState.Loading)
            assert(states[1] is UserListScreenViewModel.UIState.ShowingUserList)
            job.cancel()
        }
}