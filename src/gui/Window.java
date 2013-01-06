package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lang.NumberType;
import lang.ObjectType;
import lang.StringType;

public class Window extends Component {
	JFrame frame;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public java.awt.Component getComponent() {
		return frame;
	}
	
	public Window() {
		frame = new JFrame();
	}
	
	public ObjectType _setSize(ObjectType width, ObjectType height) {
		frame.setSize(width.toNumber().toInt(), height.toNumber().toInt());
		return undefined;
	}
	
	public ObjectType _setTitle(ObjectType title) {
		frame.setTitle(title.toStringType().toString());
		return undefined;
	}
	
	public ObjectType _show() {
		frame.setVisible(true);
		return undefined;
	}
	
	public ObjectType _hide() {
		frame.setVisible(false);
		return undefined;
	}
	
	public ObjectType _add(ObjectType obj) {
		frame.add(((Component) deref(obj)).getComponent()); 
		return undefined;
	}
	
	public ObjectType _setFlowLayout() {
		frame.setLayout(new FlowLayout()); 
		return undefined;
	}
	
	public ObjectType _showMessage(ObjectType msg) {
		infoBox(msg.toStringType().toString(), "");
		return undefined;
	}
	
	public static void infoBox(String infoMessage, String location)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + location, JOptionPane.INFORMATION_MESSAGE);
    }

	public static class Button extends Component {
		JButton button;
		
		@Override
		public java.awt.Component getComponent() {
			return button;	
		}
		
		public Button(String caption) {
			button = new JButton(caption);
		}
		
		public ObjectType _setText(ObjectType caption) {
			button.setText(caption.toStringType().toString());
			return undefined;
		}
		
		public ObjectType _onClick(ObjectType callback) {
			final ObjectType _callback = callback;
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ObjectType pos = new ObjectType();
					pos.setProperty("x", new NumberType(e.getPoint().x));
					pos.setProperty("y", new NumberType(e.getPoint().y));
					_callback.invoke(Button.this, pos);
				}
			});
			return undefined;
		}
	}
	
	public static class TextField extends Component {
		JTextField textField;
		@Override
		public java.awt.Component getComponent() {
			return textField;
		}
		
		public ObjectType _setText(ObjectType caption) {
			textField.setText(caption.toStringType().toString());
			return undefined;
		}
		
		public ObjectType _getText() {
			return new StringType(textField.getText());
		}
		
		public TextField(String text) {
			textField = new JTextField(text, 20);
		}
	}
	
	public static class Panel extends Component {
		JPanel panel;
		
		@Override
		public java.awt.Component getComponent() {
			return panel;
		}
		
		public Panel(ObjectType flow) {
			if (flow.toStringType().toString().equals("flow"))
				panel = new JPanel(new FlowLayout());
			else
				panel = new JPanel();
		}
		
		public ObjectType _add(ObjectType obj) {
			panel.add(((Component) deref(obj)).getComponent()); 
			return undefined;
		}
		
	}
}
