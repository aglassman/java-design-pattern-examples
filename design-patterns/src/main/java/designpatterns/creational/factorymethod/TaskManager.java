package designpatterns.creational.factorymethod;

import designpatterns.creational.factorymethod.task.Task;
import designpatterns.creational.factorymethod.task.TaskFactory;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class TaskManager extends JFrame {

	private final TaskFactory taskFactory = new TaskFactory();
	private final JList<Task> taskList;
	private final DefaultListModel<Task> taskListModel = new DefaultListModel<Task>();
	
	public TaskManager() {
		super();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
			List<String> availableTaskClasses = taskManager.taskFactory.getAvailableTaskClasses().stream()
					.map(clazz -> clazz.getSimpleName())
					.collect(Collectors.toList());

			String[] availableTaskClassArray = availableTaskClasses.toArray(new String[availableTaskClasses.size()]);

			int index = JOptionPane.showOptionDialog(
					taskManager, 
					"Choose task type", 
					"Create New Task", 
					JOptionPane.DEFAULT_OPTION , 
					JOptionPane.QUESTION_MESSAGE, 
					null,
					availableTaskClassArray,
					availableTaskClassArray[0]);
			
			try {
				if(index > -1)
				{
					Task t = taskManager.taskFactory.createTask((Class<? extends Task>)taskManager.taskFactory.getAvailableTaskClasses().get(index));
					taskManager.addTask(t);
				}
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
