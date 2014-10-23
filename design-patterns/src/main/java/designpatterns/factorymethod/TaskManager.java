package designpatterns.factorymethod;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import designpatterns.factorymethod.task.Task;
import designpatterns.factorymethod.task.TaskFactory;

public class TaskManager extends JFrame {

	private final TaskFactory taskFactory = new TaskFactory();
	private final JList<Task> taskList;
	private final DefaultListModel<Task> taskListModel = new DefaultListModel<Task>();
	
	public TaskManager() {
		super();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		setBounds(0, 0, 400, 300);

		setLocation(dim.width / 2 - 400 / 2, dim.height / 2 - 300 / 2);

		JMenuBar menuBar = new JMenuBar();

		setJMenuBar(menuBar);

		JMenu fileMenu = new JMenu("Task Actions");

		menuBar.add(fileMenu);

		JMenuItem menuItem = new JMenuItem("Add Task");
		menuItem.addActionListener(new AddTaskActionListener(this));
		fileMenu.add(menuItem);

		menuItem = new JMenuItem("Delete Task");
		menuItem.addActionListener(new DeleteTaskActionListener(this));
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("Toggle Complete Task");
		menuItem.addActionListener(new ToggleCompleteTaskActionListener(this));
		fileMenu.add(menuItem);
		
		taskList = new JList<Task>(taskListModel);
		DefaultListSelectionModel listSelectionModel = new DefaultListSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		taskList.setSelectionModel(listSelectionModel);
		
		add(taskList);
		
		setVisible(true);

	}

	private static class AddTaskActionListener implements ActionListener {
		
		private final TaskManager taskManager;
		
		public AddTaskActionListener(TaskManager taskManager) {
			this.taskManager = taskManager;
		}

		public void actionPerformed(ActionEvent e) {
			Object[] availableTaskClasses = taskManager.taskFactory.getAvailableTaskClasses().toArray();
			int index = JOptionPane.showOptionDialog(
					taskManager, 
					"Choose task type", 
					"Create New Task", 
					JOptionPane.DEFAULT_OPTION , 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					availableTaskClasses, 
					availableTaskClasses[0]);
			
			try {
				Task t = taskManager.taskFactory.createTask((Class<? extends Task>)availableTaskClasses[index]);
				taskManager.addTask(t);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} 
		
	}
	
	private static class DeleteTaskActionListener implements ActionListener {

		private final TaskManager taskManager;
		
		public DeleteTaskActionListener(TaskManager taskManager) {
			this.taskManager = taskManager;
		}
		
		public void actionPerformed(ActionEvent e) {
			int index = taskManager.taskList.getSelectedIndex();
			if(index > -1)
			{
				taskManager.taskListModel.remove(index);
			}
		}
		
	}
	
	private static class ToggleCompleteTaskActionListener implements ActionListener {

		private final TaskManager taskManager;
		
		public ToggleCompleteTaskActionListener(TaskManager taskManager) {
			this.taskManager = taskManager;
		}
		
		public void actionPerformed(ActionEvent e) {
			int index = taskManager.taskList.getSelectedIndex();
			if(index > -1)
			{
				Task task = taskManager.taskListModel.get(index);
				task.complete = !task.complete;
				taskManager.taskList.repaint();
			}
		}
		
	}

	public void addTask(Task t) {
		taskListModel.addElement(t);
	}
}
