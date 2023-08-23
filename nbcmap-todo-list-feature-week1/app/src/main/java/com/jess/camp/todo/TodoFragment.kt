package com.jess.camp.todo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.jess.camp.R
import com.jess.camp.databinding.TodoFragmentBinding

class TodoFragment : Fragment() {

    companion object {
        fun newInstance() = TodoFragment()
    }

    private var _binding: TodoFragmentBinding? = null
    private val binding get() = _binding!!

    private val listAdapter by lazy {
        TodoListAdapter()
    }

    fun getTodoListAdapterItemCount(): Int {
        return listAdapter.getItemCount()
    }

    fun addTodoItem(item: TodoModel) {
        listAdapter.addItems(listOf(item))
    }

    // View Binding 연결
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TodoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        val addTodoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val newTodoTitle = data?.getStringExtra("newTodoTitle")
                val newTodoContent = data?.getStringExtra("newTodoContent")

                if (!newTodoTitle.isNullOrEmpty() && !newTodoContent.isNullOrEmpty()) {
                    val newTodo = TodoModel(
                        id = listAdapter.itemCount, // 적절한 아이템 ID 설정
                        title = newTodoTitle,
                        content = newTodoContent
                    )
                    listAdapter.addItems(listOf(newTodo))
                }
            }
        }

        val btnAdd = binding.btnAdd
        btnAdd.setOnClickListener {
            val intent = Intent(requireContext(), TodoAddActivity::class.java)
            addTodoLauncher.launch(intent)
        }
    }

    private fun initView() = with(binding) {
        todoList.adapter = listAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
