package qaCinema;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicketPriceEvents implements ActionListener{
	
	private ButtonGroup day,moiveType;
	private  int standardTicketprice=8;
	private int OAPTicketprice=6;
	private int studentTicketprice=6;
	private int childTicketprice=4;
	private TextField standardTicketNum, studentTicketNum, OAPTicketNum,childTicketNum,ticketNum, output;
	private JFrame currentframe;
	
	public TicketPriceEvents(TextField ticketNum)
	{
		this.ticketNum=ticketNum;
		
	}
	

	public TicketPriceEvents(TextField standardText, TextField OAPText, TextField studentText, TextField childText,TextField resultText,ButtonGroup dayType,ButtonGroup moiveType,JFrame currentframe) {
		// TODO Auto-generated constructor stub
		
		this.standardTicketNum=standardText;
		this.studentTicketNum=studentText;
		this.OAPTicketNum=OAPText;
		this.childTicketNum=childText;
		this.output=resultText;
		this.day=dayType;
		this.currentframe=currentframe;
		this.moiveType=moiveType;
	}

	

	@Override
	public void actionPerformed(ActionEvent x) {
		// TODO Auto-generated method stub
		
		Button y= (Button)x.getSource();
		System.out.println(y.getLabel());
		switch(y.getLabel()) {
		case"+":addTicket();
		break;
		case"-": subTicket();
		break;
		case "Get Ticket Prices": getPrices();
		break;	
		default:JOptionPane.showMessageDialog(currentframe,"Button action Error");
		break;
		}
		
	}
	
	
	public void addTicket()
	{
		int x=Integer.parseInt(this.ticketNum.getText());
		x=x+1;
		this.ticketNum.setText(""+x);
		
	}
	
	public void subTicket()
	{
		int x=Integer.parseInt(this.ticketNum.getText());
		if(x>0)
		{x=x-1;}
		this.ticketNum.setText(""+x);
	}
	
	
	public void getPrices()
	{
		 if(chechInfo())
		 {	 
			String result="The total cost of tickets for this movie is ";
			int totalprice=(Integer.parseInt(standardTicketNum.getText())*standardTicketprice)+(Integer.parseInt(OAPTicketNum.getText())*OAPTicketprice)+(Integer.parseInt(studentTicketNum.getText())*studentTicketprice)+(Integer.parseInt(childTicketNum.getText())*childTicketprice);
			int totalTickets=Integer.parseInt(standardTicketNum.getText())+Integer.parseInt(OAPTicketNum.getText())+Integer.parseInt(studentTicketNum.getText())+(Integer.parseInt(childTicketNum.getText())*childTicketprice);
			if(day.getSelection().getActionCommand().equals("wed"))
			{
				totalprice=totalprice-(totalTickets*2);
				JOptionPane.showMessageDialog(currentframe,"You have been giveen a discount of"+totalTickets*2+" for Wedensday");	
			}
			output.setText(result+" £"+totalprice);
		 }
	}
	
	public boolean chechInfo()
	{
		boolean check=true;
		
		try {
			if(day.getSelection()==null)
			{
				JOptionPane.showMessageDialog(currentframe,"You have not selected a day");	
				 check=false;
			}
			if(moiveType.getSelection()==null)
			{
				JOptionPane.showMessageDialog(currentframe,"You have not selected a Moive Type");	
				 check=false;
			}
			
			if(standardTicketNum.getText().equals("0")&&OAPTicketNum.getText().equals("0")&&studentTicketNum.getText().equals("0")&&childTicketNum.getText().equals("0"))
			{
				JOptionPane.showMessageDialog(currentframe,"You have not selected any tickets");	
				 check=false;
			}
		}
		
		catch(Exception e)
		{
			
		}
		return check;
		
		
		
	}
	
	
	
	

}
