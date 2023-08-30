package com.ticmas.fmedina.evaluation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ticmas.fmedina.evaluation.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value = viewModel.comparador.value?.resultado
        assertEquals("", value)
    }

    @Test
    fun mainViewModel_Equal() = runTest {
        launch {
            viewModel.fnComparar("HOLA","HOLA")
        }
        advanceUntilIdle()
        val value = viewModel.comparador.value?.resultado
        assertEquals("IGUALES", value)
    }

    @Test
    fun mainViewModel_NotEqual() = runTest {
        launch {
            viewModel.fnComparar("HOLA","CHAU")
        }
        advanceUntilIdle()
        val value = viewModel.comparador.value?.resultado
        assertEquals("DISTINTOS", value)
    }
}