package qaCinema;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame mainFrame= new JFrame("Qa Cinema");
		JPanel moiveDays =new JPanel();
		JPanel movies =new JPanel();
		JPanel days =new JPanel();
		JPanel ticket= new JPanel();
		JPanel result= new JPanel();
		JPanel standard= new JPanel();
		JPanel OAP= new JPanel();
		JPanel student= new JPanel();
		JPanel child= new JPanel();
		
		ticket.setLayout(new GridLayout(5,1));
		moiveDays.setLayout(new GridLayout(3,1));
		movies.setLayout(new FlowLayout());
		days.setLayout(new FlowLayout());
		result.setLayout(new FlowLayout());
		
		Label standardLabel= new Label("Standard");
		Label OAPLabel= new Label("OAP     ");
		Label studentLabel= new Label("Student ");
		Label childLabel= new Label("Child   ");
		Label ticketPrice= new Label("Ticket Price");
		Label moiveLabel= new Label("Select a moive type and the Day");
		Label ticketLabel= new Label("Select your Tickets");
		
		
		TextField standardText = new TextField("0");
		TextField OAPText = new TextField("0");
		TextField studentText = new TextField("0");
		TextField childText = new TextField("0");
		TextField resultText = new TextField(35);
		
		Button addStandard= new Button("+");
		Button subStandard= new Button("-");
		Button addOAP= new Button("+");
		Button subOAP= new Button("-");
		Button addStudent= new Button("+");
		Button subStudent= new Button("-");
		Button addChild= new Button("+");
		Button subChild= new Button("-");
		Button getPrice= new Button("Get Ticket Prices");
		
		JRadioButton horror = new JRadioButton ("Horror (18)");
		horror.setActionCommand("H");
		JRadioButton action = new JRadioButton ("Action (12A)");
		action.setActionCommand("A");
		JRadioButton drama = new JRadioButton ("Drama (GEN)");
		action.setActionCommand("D");
		ButtonGroup moiveType = new ButtonGroup();
		
		moiveType.add(horror);
		moiveType.add(action);
		moiveType.add(drama);
		
		movies.add(horror);
		movies.add(action);
		movies.add(drama);
		
		JRadioButton mon = new JRadioButton ("Mon");
		mon.setActionCommand("mon");
		JRadioButton tue = new JRadioButton ("Tue");
		tue.setActionCommand("tue");
		JRadioButton wed = new JRadioButton ("Wed");
		wed.setActionCommand("wed");
		JRadioButton thurs = new JRadioButton ("Thurs");
		thurs.setActionCommand("thurs");
		JRadioButton fri= new JRadioButton ("Fri");
		fri.setActionCommand("fri");
		JRadioButton sat = new JRadioButton ("Sat");
		sat.setActionCommand("sat");
		JRadioButton sun = new JRadioButton ("Sun");
		sun.setActionCommand("sun");
		ButtonGroup dayType = new ButtonGroup();
		
		dayType.add(mon);
		dayType.add(tue);
		dayType.add(wed);
		dayType.add(thurs);
		dayType.add(fri);
		dayType.add(sat);
		dayType.add(sun);
		
		days.add(mon);
		days.add(tue);
		days.add(wed);
		days.add(thurs);
		days.add(fri);
		days.add(sat);
		days.add(sun);
		
		
		moiveDays.add(moiveLabel);
		moiveDays.add(movies);
		moiveDays.add(days);
		
		standard.add(standardLabel);
		standard.add(subStandard);
		standard.add(standardText);
		standard.add(addStandard);
		
		OAP.add(OAPLabel);
		OAP.add(subOAP);
		OAP.add(OAPText);
		OAP.add(addOAP);
		
		student.add(studentLabel);
		student.add(subStudent);
		student.add(studentText);
		student.add(addStudent);
		
		child.add(childLabel);
		child.add(subChild);
		child.add(childText);
		child.add(addChild);
		
		
		ticket.add(ticketLabel);
		ticket.add(standard);
		ticket.add(OAP);
		ticket.add(student);
		ticket.add(child);
		
		result.add(ticketPrice);
		result.add(resultText);
		result.add(getPrice);
	
		TicketPriceEvents insertStudent= new TicketPriceEvents(studentText);	
		addStudent.addActionListener(insertStudent);
		TicketPriceEvents removeStudent= new TicketPriceEvents(studentText);	
		subStudent.addActionListener(removeStudent);
		
		TicketPriceEvents insertOAP= new TicketPriceEvents(OAPText);	
		addOAP.addActionListener(insertOAP);
		TicketPriceEvents removeOAP= new TicketPriceEvents(OAPText);	
		subOAP.addActionListener(removeOAP);
		
		TicketPriceEvents insertStandard= new TicketPriceEvents(standardText);	
		addStandard.addActionListener(insertStandard);
		TicketPriceEvents removeStandard= new TicketPriceEvents(standardText);	
		subStandard.addActionListener(removeStandard);
		
		TicketPriceEvents insertChild= new TicketPriceEvents(childText);	
		addChild.addActionListener(insertChild);
		TicketPriceEvents removeChild= new TicketPriceEvents(childText);	
		subChild.addActionListener(removeChild);
		
		TicketPriceEvents getTicketPrices= new TicketPriceEvents(standardText,OAPText,studentText,childText,resultText,dayType,moiveType,mainFrame);	
		getPrice.addActionListener(getTicketPrices);
		
		
		horror.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				childText.setText("0");
				child.setVisible(false);
				JOptionPane.showMessageDialog(mainFrame,"This Moive Type is not Suitable for Children");	
			}});
		
		
		drama.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				child.setVisible(true);
	
			}});
		
		action.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {		
				child.setVisible(true);
				
			}});
		
		
		
		mainFrame.add(moiveDays,BorderLayout.NORTH);
		mainFrame.add(ticket,BorderLayout.CENTER);
		mainFrame.add(result,BorderLayout.SOUTH);
		mainFrame.setSize(500, 500);
		mainFrame.setLocation(300, 300);
		mainFrame.setVisible(true);
		
		
		
		 
		
	}

}
