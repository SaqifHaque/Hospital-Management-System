import java.awt.*;
import java.awt.event.*;


class AddPatient extends Frame implements WindowListener, ActionListener{
	
	private Register register;
	private Label title,id,name,mobile,address,dob,gender,ms,bg,age,email;
	private TextField Tid;
	private TextField Tname,Tmobile,Taddress,Tdob,Tgender,Tms,Tbg,Tage,Temail;
	private Button Add,Delete,Back,Show;
	private Panel panel;
	
	
	public AddPatient(Register r){
		super("Hospital Management System");
		this.register=r;
		setSize(800,600);
		panel=new Panel();
		panel.setLayout(null);
		
		title=new Label("Enter patient information.");
		title.setBounds(280,30,500,80);
		panel.add(title);
		
		bg=new Label("Blood Group");
		bg.setBounds(400,110,100,30);
		panel.add(bg);
		
		Tbg=new TextField(5);
		Tbg.setBounds(520,110,150,30);
		panel.add(Tbg);
		
		name=new Label("Name");
		name.setBounds(80,170,100,30);
		panel.add(name);
		
		Tname=new TextField(5);
		Tname.setBounds(200,170,150,30);
	   	panel.add(Tname);
		
		age=new Label("Age");
		age.setBounds(400,170,100,30);
		panel.add(age);
		
		Tage=new TextField(5);
		Tage.setBounds(520,170,150,30);
	   	panel.add(Tage);
		
		mobile=new Label("Mobile No");
		mobile.setBounds(80,230,100,30);
		panel.add(mobile);
		
		Tmobile=new TextField(5);
		Tmobile.setBounds(200,230,150,30);
	   	panel.add(Tmobile);
		
		email=new Label("Email ");
		email.setBounds(400,230,100,30);
		panel.add(email);
		
		Temail=new TextField(5);
		Temail.setBounds(520,230,150,30);
	   	panel.add(Temail);
		
		address=new Label("Address");
		address.setBounds(80,290,100,30);
		panel.add(address);
		
		Taddress=new TextField(5);
		Taddress.setBounds(200,290,150,30);
	   	panel.add(Taddress);
		
		dob=new Label("Date of Birth");
		dob.setBounds(80,350,100,30);
		panel.add(dob);
		
		Tdob=new TextField(5);
		Tdob.setBounds(200,350,150,30);
	   	panel.add(Tdob);
		
		
		gender=new Label("Gender");
		gender.setBounds(400,290,100,30);
		panel.add(gender);
		
		Tgender=new TextField(5);
		Tgender.setBounds(520,290,150,30);
	   	panel.add(Tgender);
		
		ms=new Label("Marital Status");
		ms.setBounds(400,350,100,30);
		panel.add(ms);
		
		Tms=new TextField(5);
		Tms.setBounds(520,350,150,30);
	   	panel.add(Tms);	
		
		Add = new Button("Add");
		Add.setBounds(450,470,45,30);
		panel.add(Add);
		
		Delete = new Button("Delete");
		Delete.setBounds(500,470,45,30);
		panel.add(Delete);
		
		Back = new Button("Back");
		Back.setBounds(550,470,45,30);
		panel.add(Back);
		
		Show = new Button("Show Details");
		Show.setBounds(200,470,80,30);
		panel.add(Show);
		
		
		add(panel);
		Add.addActionListener(this);
		Delete.addActionListener(this);
		Back.addActionListener(this);
		Show.addActionListener(this);
		
			
		addWindowListener(this);
		
		
		
	}
	
    public void windowClosing(WindowEvent we){
        System.out.println("Window is closing");
		System.exit(0);
	}
	public void actionPerformed(ActionEvent e){
		String text=e.getActionCommand();
	    DataAccess da=new DataAccess();
		if(text.equals("Add")){
			text="insert into patient_details values(null,'"+Tname.getText()+"','"+Tmobile.getText()+"','"+Taddress.getText()+"','"+Tdob.getText()+"','"+Tbg.getText()+"','"+Tage.getText()+"','"+Temail.getText()+"','"+Tgender.getText()+"','"+Tms.getText()+"')";
			da.updateDB(text);
			
		}
		else if(text.equals("Delete")){
				
			text="Delete from patient_details where email='"+Temail.getText()+"'";
			da.updateDB(text);
			
		}
		/*else if(text.equals("Update")){
			text="update beta set salary='"+Tsalary.getText()+"' where email='"+email.getText()+"'";
			da.updateDB(text);
		}*/
		else if(text.equals("Back")){
			register.adminDashboard.setVisible(true);
			register.addDoctor.setVisible(false);
		}
		else if(text.equals("Show Details")){
			register.patientsearchForm.setVisible(true);
			register.addDoctor.setVisible(false);
		}
		
	   
		
		
	}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
}