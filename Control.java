import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.BasicArrowButton;

public class Control extends JPanel{
	Display f;
	
	private JSlider iterSlide;
	private JLabel iterLabel;
	
	private JSlider zooomSlide;
	private JLabel zoomLabel;

	public Control(Display f)
	{
		this.f = f;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(VAR.CONTROL_WIDTH, VAR.DISPLAY_HEIGHT));
		
		JLabel iterLabel = new JLabel("Iterations");
		this.add(iterLabel);
		iterLabel.setAlignmentX(iterLabel.CENTER_ALIGNMENT);
		
		JSlider iterSlide = new JSlider(0,2000,100);
		iterSlide.setMajorTickSpacing(100);
		iterSlide.setPaintTicks(true);
		//iterSlide.setPaintLabels(true);
		iterSlide.addChangeListener(
				new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						f.iterations = iterSlide.getValue();
						f.repaint();
					}
				});
		this.add(iterSlide);
		
		JLabel zoomLabel = new JLabel("Zoom");
		this.add(zoomLabel);
		zoomLabel.setAlignmentX(zoomLabel.CENTER_ALIGNMENT);
		
		JSlider zoomSlide = new JSlider(100,800,100);
		//iterSlide.setMinorTickSpacing(0.01);
		zoomSlide.setPaintTicks(true);
		zoomSlide.setPaintLabels(true);
		zoomSlide.addChangeListener(
				new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						f.zoom = zoomSlide.getValue()/100.0;
						f.repaint();
					}
				});
		this.add(zoomSlide);
		
		JLabel hueLabel = new JLabel("Hue");
		this.add(hueLabel);
		hueLabel.setAlignmentX(hueLabel.CENTER_ALIGNMENT);
		
		JSlider hueSlide = new JSlider(0,1000,500);
		//iterSlide.setMinorTickSpacing(0.01);
		hueSlide.setPaintTicks(true);
		hueSlide.setPaintLabels(true);
		hueSlide.addChangeListener(
				new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						f.hue = hueSlide.getValue()/1000.0f;
						f.repaint();
					}
				});
		this.add(hueSlide);
		
		BasicArrowButton right = new BasicArrowButton(BasicArrowButton.EAST);
		right.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.locX-=(0.1/f.zoom);
				f.repaint();
			}
		});
		BasicArrowButton up = new BasicArrowButton(BasicArrowButton.NORTH);
		up.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.locY+=(0.1/f.zoom);
				f.repaint();
			}
		});
		BasicArrowButton left = new BasicArrowButton(BasicArrowButton.WEST);
		left.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.locX+=(0.1/f.zoom);
				f.repaint();
			}
		});
		BasicArrowButton down = new BasicArrowButton(BasicArrowButton.SOUTH);
		down.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.locY-=(0.1/f.zoom);
				f.repaint();
			}
		});
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(VAR.CONTROL_WIDTH, VAR.CONTROL_WIDTH));
		buttonPanel.setMaximumSize(new Dimension(VAR.CONTROL_WIDTH, VAR.CONTROL_WIDTH));

		
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(right, BorderLayout.EAST);
		buttonPanel.add(up, BorderLayout.NORTH);
		buttonPanel.add(left, BorderLayout.WEST);
		buttonPanel.add(down, BorderLayout.SOUTH);
		
		this.add(buttonPanel);	
		}
}
