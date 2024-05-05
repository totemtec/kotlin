package start

sealed class UIState {
    data object Loading : UIState()
    data class Success(val data: String) : UIState()
    data class Error(val exception: Exception) : UIState()
}

fun updateUI(state: UIState) {
    when (state) {
        is UIState.Loading -> showLoading()
        is UIState.Success -> showData(state.data)
        is UIState.Error -> showError(state.exception)
    }
}

fun showLoading() {
    println("showLoading()")
}

fun showData(data: String) {
    println("showData() data = $data")
}

fun showError(e : Exception) {
    println("showError() exception = $e")
}

fun main() {
    updateUI(UIState.Loading)

    updateUI(UIState.Success("Success Message"))

    updateUI(UIState.Error(Exception("Unknown Error Occurred")))
}