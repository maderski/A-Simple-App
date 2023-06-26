package maderski.asimpleapp.userdirectory.presentation.userlocation

import org.junit.Test


class UserMapLocationViewModelTest {
    private val viewModel: UserMapLocationViewModel = UserMapLocationViewModel()

    @Test
    fun `When lat and long are not null ShowingMap state is shown`() {
        viewModel.init("Test", "31", "83")
        assert(viewModel.screenState.value is UserMapLocationViewModel.UIState.ShowingMap)
    }

    @Test
    fun `When lat and long are null ErrorOccurred state is shown`() {
        viewModel.init(null, null, null)
        assert(viewModel.screenState.value is UserMapLocationViewModel.UIState.ErrorOccurred)
    }
}