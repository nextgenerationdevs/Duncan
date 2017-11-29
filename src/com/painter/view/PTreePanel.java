package com.painter.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.EventObject;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.CellEditor;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.painter.controller.PCommand;

public class PTreePanel extends JPanel
{
	PCommand cmd;

	public static JTree m_tree;
	public static DefaultTreeModel m_model;
	public static JTextField m_display;
	public static String bufName;
	public static DefaultMutableTreeNode nodeToUpdate;

	public PTreePanel(PCommand cmd)
	{
		this.cmd = cmd;
		JLabel nameLabel = new JLabel("Windows");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		nameLabel.setAlignmentX(CENTER_ALIGNMENT);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(Box.createRigidArea(new Dimension(180, 0)));

		DefaultMutableTreeNode top = new DefaultMutableTreeNode(new IconData(null, null, "Computer"));

		DefaultMutableTreeNode node;
		File[] roots = File.listRoots();
		for (int k = 0; k < roots.length; k++)
		{
			node = new DefaultMutableTreeNode(new IconData(null, null, new FileNode(roots[k])));
			top.add(node);
			node.add(new DefaultMutableTreeNode(new Boolean(true)));
		}

		m_model = new DefaultTreeModel(top);
		m_model.addTreeModelListener(new MyTreeModelListener());

		m_tree = new JTree(m_model);

		m_tree.putClientProperty("JTree.lineStyle", "Angled");

		TreeCellRenderer renderer = new IconCellRenderer();
		m_tree.setCellRenderer(renderer);

		m_tree.setCellEditor(new FileTreeCellEditor());

		m_tree.addTreeExpansionListener(new DirExpansionListener());

		m_tree.addTreeSelectionListener(new DirSelectionListener());

		m_tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		m_tree.setShowsRootHandles(true);
		m_tree.setRootVisible(false);

		m_tree.setEditable(true);

		JScrollPane scrollPane = new JScrollPane(m_tree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(nameLabel);
		add(scrollPane);
		setVisible(true);

		m_display = new JTextField();
		m_display.setEditable(false);
		add(m_display, BorderLayout.NORTH);

		//// this.add(panel);
		//
		// WindowListener wndCloser = new WindowAdapter() {
		// public void windowClosing(WindowEvent e) {
		// System.exit(0);
		// }
		// };
		// addWindowListener(wndCloser);
	}

	DefaultMutableTreeNode getTreeNode(TreePath path)
	{
		return (DefaultMutableTreeNode) (path.getLastPathComponent());
	}

	FileNode getFileNode(DefaultMutableTreeNode node)
	{
		if (node == null) return null;
		Object obj = node.getUserObject();
		if (obj instanceof IconData) obj = ((IconData) obj).getObject();
		if (obj instanceof FileNode) return (FileNode) obj;
		else return null;
	}

	public JPanel getBrowser()
	{
		return this;
	}

	class DirExpansionListener implements TreeExpansionListener
	{
		public void treeExpanded(TreeExpansionEvent event)
		{
			final DefaultMutableTreeNode node = getTreeNode(event.getPath());
			final FileNode fnode = getFileNode(node);
			nodeToUpdate = node;

			Thread runner = new Thread()
			{
				public void run()
				{
					if (fnode != null && fnode.expand(node))
					{
						Runnable runnable = new Runnable()
						{
							public void run()
							{
								m_model.reload(node);
							}
						};
						SwingUtilities.invokeLater(runnable);
					}
				}
			};
			runner.start();
		}

		public void treeCollapsed(TreeExpansionEvent event)
		{
		}
	}

	class DirSelectionListener implements TreeSelectionListener
	{
		public void valueChanged(TreeSelectionEvent event)
		{
			DefaultMutableTreeNode node = getTreeNode(event.getPath());
			FileNode fnode = getFileNode(node);
			if (fnode != null) m_display.setText(fnode.getFile().getAbsolutePath());
			else m_display.setText("");
		}
	}
}

class IconCellRenderer extends JLabel implements TreeCellRenderer
{
	private static final long serialVersionUID = 6860672454817752545L;
	protected Color m_textSelectionColor;
	protected Color m_textNonSelectionColor;
	protected Color m_bkSelectionColor;
	protected Color m_bkNonSelectionColor;
	protected Color m_borderSelectionColor;

	protected boolean m_selected;

	public IconCellRenderer()
	{
		super();
		m_textSelectionColor = UIManager.getColor("Tree.selectionForeground");
		m_textNonSelectionColor = UIManager.getColor("Tree.textForeground");
		m_bkSelectionColor = UIManager.getColor("Tree.selectionBackground");
		m_bkNonSelectionColor = UIManager.getColor("Tree.textBackground");
		m_borderSelectionColor = UIManager.getColor("Tree.selectionBorderColor");
		setOpaque(false);
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus)

	{
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
		Object obj = node.getUserObject();
		setText(obj.toString());

		if (obj instanceof Boolean) setText("Retrieving data...");

		if (obj instanceof IconData)
		{
			IconData idata = (IconData) obj;
			if (expanded) setIcon(idata.getExpandedIcon());
			else setIcon(idata.getIcon());
		}
		else setIcon(null);

		setFont(tree.getFont());
		setForeground(sel ? m_textSelectionColor : m_textNonSelectionColor);
		setBackground(sel ? m_bkSelectionColor : m_bkNonSelectionColor);
		m_selected = sel;
		return this;
	}

	public void paintComponent(Graphics g)
	{
		Color bColor = getBackground();
		Icon icon = getIcon();

		g.setColor(bColor);
		int offset = 0;
		if (icon != null && getText() != null) offset = (icon.getIconWidth() + getIconTextGap());
		g.fillRect(offset, 0, getWidth() - 1 - offset, getHeight() - 1);

		if (m_selected)
		{
			g.setColor(m_borderSelectionColor);
			g.drawRect(offset, 0, getWidth() - 1 - offset, getHeight() - 1);
		}
		super.paintComponent(g);
	}
}

class IconData
{
	protected Icon m_icon;
	protected Icon m_expandedIcon;
	protected Object m_data;

	public IconData(Icon icon, Object data)
	{
		m_icon = icon;
		m_expandedIcon = null;
		m_data = data;
	}

	public IconData(Icon icon, Icon expandedIcon, Object data)
	{
		m_icon = icon;
		m_expandedIcon = expandedIcon;
		m_data = data;
	}

	public Icon getIcon()
	{
		return m_icon;
	}

	public Icon getExpandedIcon()
	{
		return m_expandedIcon != null ? m_expandedIcon : m_icon;
	}

	public Object getObject()
	{
		return m_data;
	}

	public String toString()
	{
		return m_data.toString();
	}
}

class FileNode
{
	protected File m_file;

	public FileNode(File file)
	{
		m_file = file;
	}

	public File getFile()
	{
		return m_file;
	}

	public String toString()
	{
		return m_file.getName().length() > 0 ? m_file.getName() : m_file.getPath();
	}

	public boolean expand(DefaultMutableTreeNode parent)
	{
		DefaultMutableTreeNode flag = (DefaultMutableTreeNode) parent.getFirstChild();
		if (flag == null) return false;
		Object obj = flag.getUserObject();
		if (!(obj instanceof Boolean)) return false;

		parent.removeAllChildren();

		File[] files = listFiles();
		if (files == null) return true;

		Vector<FileNode> v = new Vector<FileNode>();

		for (int k = 0; k < files.length; k++)
		{
			File f = files[k];
			// if (!(f.isDirectory()))
			// continue;
			// TODO
			FileNode newNode = new FileNode(f);

			boolean isAdded = false;
			for (int i = 0; i < v.size(); i++)
			{
				FileNode nd = (FileNode) v.elementAt(i);
				if (newNode.compareTo(nd) < 0)
				{
					v.insertElementAt(newNode, i);
					isAdded = true;
					break;
				}
			}
			if (!isAdded) v.addElement(newNode);
		}

		for (int i = 0; i < v.size(); i++)
		{
			FileNode nd = (FileNode) v.elementAt(i);
			IconData idata = new IconData(null, null, nd);
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(idata);
			parent.add(node);

			if (nd.hasSubDirs()) node.add(new DefaultMutableTreeNode(new Boolean(true)));
		}

		return true;
	}

	public boolean hasSubDirs()
	{
		File[] files = listFiles();
		if (files == null) return false;
		for (int k = 0; k < files.length; k++)
		{
			if (files[k].isDirectory()) return true;
		}
		return true;
	}

	public int compareTo(FileNode toCompare)
	{
		return m_file.getName().compareToIgnoreCase(toCompare.m_file.getName());
	}

	protected File[] listFiles()
	{
		if (!m_file.isDirectory()) return null;
		try
		{
			return m_file.listFiles();
		}
		catch (Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Error reading directory " + m_file.getAbsolutePath(), "Warning",
					JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}

}

class MyTreeModelListener implements TreeModelListener
{
	String filePath = "";

	@Override
	public void treeNodesChanged(TreeModelEvent e)
	{
		// TODO

		// File f = new File(filePath + "\\" +
		// e.getChildren()[0].toString());
		File f = new File(filePath + "\\" + PTreePanel.bufName);
		f.renameTo(new File(filePath + "\\" + e.getChildren()[0].toString()));
		PTreePanel.m_model.reload();
		PTreePanel.m_tree.updateUI();

	}

	@Override
	public void treeNodesInserted(TreeModelEvent e)
	{
	}

	@Override
	public void treeNodesRemoved(TreeModelEvent e)
	{
	}

	@Override
	public void treeStructureChanged(TreeModelEvent e)
	{
		// [Computer, C:\]
		filePath = "";
		for (int i = 0; i < e.getPath().length; i++)
		{
			if (i != 0)
			{
				if (i != 1)
				{
					filePath += "\\" + e.getPath()[i].toString();
				}
				else
				{
					filePath += e.getPath()[i].toString();
				}
			}
		}
	}
}

class FileTreeCellEditor implements TreeCellEditor
{
	FileEditor fileEditor;
	CellEditor currentEditor;
	String val;

	public FileTreeCellEditor()
	{
		FileEditor fe = new FileEditor();
		fileEditor = fe;
	}

	public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded,
			boolean leaf, int row)
	{
		currentEditor = fileEditor;
		fileEditor.setText(value.toString());
		return (Component) currentEditor;
	}

	public Object getCellEditorValue()
	{
		return currentEditor.getCellEditorValue();
	}

	public boolean isCellEditable(EventObject eo)
	{
		if ((eo == null) || ((eo instanceof MouseEvent) && (((MouseEvent) eo).getClickCount() == 3)))
		{
			return true;
		}
		return false;
	}

	public boolean shouldSelectCell(EventObject event)
	{
		return currentEditor.shouldSelectCell(event);
	}

	public boolean stopCellEditing()
	{
		return currentEditor.stopCellEditing();
	}

	public void cancelCellEditing()
	{
		currentEditor.cancelCellEditing();
	}

	public void addCellEditorListener(CellEditorListener l)
	{
		fileEditor.addCellEditorListener(l);
	}

	public void removeCellEditorListener(CellEditorListener l)
	{
		fileEditor.removeCellEditorListener(l);
	}

	class FileEditor extends JTextField implements CellEditor
	{
		private static final long serialVersionUID = 119104841886129870L;
		String value = "";
		Vector<CellEditorListener> listeners = new Vector<CellEditorListener>();

		public FileEditor()
		{
			this("", 5);
		}

		public FileEditor(String s, int w)
		{
			super(s, w);
			addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					if (stopCellEditing())
					{
						fireEditingStopped();
					}
				}
			});
		}

		public void cancelCellEditing()
		{
			setText("");
		}

		public boolean stopCellEditing()
		{
			// TODO
			String tmp = getText();
			String buf = PTreePanel.m_display.getText();
			PTreePanel.bufName = buf.substring(buf.lastIndexOf("\\") + 1);

			value = tmp;
			return true;
		}

		public Object getCellEditorValue()
		{
			return value;
		}

		public boolean isCellEditable(EventObject eo)
		{
			if ((eo == null) || ((eo instanceof MouseEvent) && (((MouseEvent) eo).getClickCount() == 3)))
			{
				return true;
			}
			return false;
		}

		public boolean shouldSelectCell(EventObject eo)
		{
			return true;
		}

		public void addCellEditorListener(CellEditorListener cel)
		{
			listeners.addElement(cel);
		}

		public void removeCellEditorListener(CellEditorListener cel)
		{
			listeners.removeElement(cel);
		}

		protected void fireEditingStopped()
		{
			if (listeners.size() > 0)
			{
				ChangeEvent ce = new ChangeEvent(this);
				for (int i = listeners.size() - 1; i >= 0; i--)
				{
					((CellEditorListener) listeners.elementAt(i)).editingStopped(ce);
				}
			}
		}
	}

}