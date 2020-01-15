package dietCreator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class dietCreatorApp extends JFrame {

    private JPanel rootPanel;
    private JTextField weightText;
    private JTextField heightText;
    private JTextField ageText;
    private JButton calculateButton;
    public JTextArea informationArea;
    private JButton showDietButton;
//TODO: Calculate the minimum calories intake of the person.
    //Todo: Research what is the correlation between age and BMI and make it useful in the code.
    //Todo: Write a database or at least an  array that contains food and their calorie values and make daily chart for it.
    //Todo: Make a limitation for maximum and minimum height and weight.
    //Todo extra: Do pop ups for buttons.    
    public dietCreatorApp() //Constructor
    {
        add(rootPanel);
        setTitle("Diet Creator");
        setSize(300,500); //Attention: Size has been set much more smaller than the normal temporarily. Ratio 16:9 must be.
        setVisible(true);
        DecimalFormat dFormat = new DecimalFormat("#.00"); //Format to  see less decimal part.

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double heightTemp = Integer.parseInt(heightText.getText());
                heightTemp /= 100;
                double BMI = Integer.parseInt(weightText.getText())/Math.pow(heightTemp,2);
                String BMIString = dFormat.format(BMI);

                informationArea.append("Your BMI is:" + BMIString);
                String statusReport = personStatus(BMI, heightTemp,Integer.parseInt(weightText.getText()));
                informationArea.append(statusReport);
                if(statusReport.equals("\nYou\'re underweight\n") || statusReport.equals("\nYou\'re overweight\n")|| statusReport.equals("\nYou\'re obese\n"))
                    informationArea.append(idealKilo(BMI, heightTemp,Integer.parseInt(weightText.getText())));

            }
        });
    }

    //Method for deciding to person's status.
    public static String personStatus(double BMI, double height, double weight)
    {double massIndexes[] = {18.5,24.9,29.9};
        String status[] = {"underweight","healthy","overweight","obese","ERROR"};
        int temp = 4;
        for (int i = 0; i < massIndexes.length; i++) {

            if(BMI < massIndexes[i])
            {
                temp = i;
                break;
            }
            else temp = 3;
        }
        return "\nYou\'re "+ status[temp] +"\n";
    }

    //To show ideal kilogram of the person.
    public static String idealKilo(double BMI, double height, double weight)
    {
        JOptionPane.showMessageDialog(null,"A healthy person\'s BMI is between 18.5 and 25.");
            double idealWeight = 0;
            double idealWeightDif;
            if(BMI<18.5)
            {
                idealWeight = (height*height)*18.5;
                idealWeightDif = idealWeight - weight;
                return ("You should gain " + String.format("%.2f",idealWeightDif) + " kg! " + "\nYour ideal weight is "+ String.format("%.2f",idealWeight)+".");
            }
            else if(BMI>24.9)
            {
                idealWeight = (height*height)*24.9;
                idealWeightDif = weight -idealWeight;
                return("You should lose " + String.format("%.2f",idealWeightDif) +" kg! "+"\nYour ideal weight is "+ String.format("%.2f",idealWeight)+"." );
            }
            return "Test";
    }

    public static String minimumCalorie(double BMI, double height, double weight)
    {
        String calorieS = new String();
        return calorieS;
    }


}
