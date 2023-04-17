import java.awt.event.*;
import java.text.DecimalFormat;
import java.awt.*;
import javax.swing.*;

public class CalcFrame extends JFrame {

    private JButton btnEqual;
    private JTextField textFieldA, textFieldB;
    private JRadioButton rbtnAdd, rbtnSub, rbtnMul, rbtnDiv;
    private JTextArea outputArea;
    
    public CalcFrame() {

        outputArea = new JTextArea(8, 12);
        outputArea.setEditable(false);

        createTextField();
        createButton();
        createRbtn();
        createLayout();

        setSize(600, 200);

    }
    private void createTextField() {

        textFieldA = new JTextField(10);
        textFieldB = new JTextField(10);

    }
    private void createRbtn() {

        rbtnAdd = new JRadioButton("+");
        rbtnSub = new JRadioButton("-");
        rbtnMul = new JRadioButton("*");
        rbtnDiv = new JRadioButton("/");

        ButtonGroup group = new ButtonGroup();

        group.add(rbtnAdd);
        group.add(rbtnSub);
        group.add(rbtnMul);
        group.add(rbtnDiv);

    }

    private void createButton(){

        btnEqual = new JButton("=");
        
        btnEqual.addActionListener(new ActionListener(){
        	
        	 public void actionPerformed(ActionEvent e){

        	        if(e.getSource() == btnEqual){  
        	            double a = Double.parseDouble(textFieldA.getText());
        	            double b = Double.parseDouble(textFieldB.getText());
        	            String operator = "";

        	            if(rbtnAdd.isSelected()){
        	                operator = "+";
        	                outputArea.append(getResult(a, operator, b));
        	            }else if(rbtnSub.isSelected()){
        	                operator = "-";
        	                outputArea.append(getResult(a, operator, b));
        	            }else if(rbtnMul.isSelected()){
        	                operator = "*";
        	                outputArea.append(getResult(a, operator, b));
        	            }else if(rbtnDiv.isSelected()){
        	                operator = "/";
        	                if(b == 0){
        	                    outputArea.append("除數不能為0");
        	                }else{
        	                    outputArea.append(getResult(a, operator, b));
        	                }
        	            }
        	        }
        	 }
        });       
    }

    private String getResult(double a, String op, double b) {
        
        double result = 0.00;

        switch(op){

            case "+" :
                result = a + b;
                break;

            case "-" :
                result = a - b;
                break;

            case "*" :
                result = a * b;
                break;

            case "/" :
                result = a / b;
                break;

        }

        DecimalFormat df = new DecimalFormat("#.00");      //DecimalFormat可在不用print時控制小數點位數
        return df.format(a) + " " + op + " " + df.format(b) +" = " + df.format(result) + "\n"; 

    }

    private void createLayout(){

        JPanel flow_panel = new JPanel();
        JPanel rbtn_panel = new JPanel(new GridLayout(4,1));

        rbtn_panel.add(this.rbtnAdd);
        rbtn_panel.add(this.rbtnSub);
        rbtn_panel.add(this.rbtnMul);
        rbtn_panel.add(this.rbtnDiv);

        flow_panel.add(this.textFieldA);
        flow_panel.add(rbtn_panel);
        flow_panel.add(this.textFieldB);
        flow_panel.add(this.btnEqual);
        flow_panel.add(new JScrollPane(outputArea));

        add(flow_panel);
    }
}
