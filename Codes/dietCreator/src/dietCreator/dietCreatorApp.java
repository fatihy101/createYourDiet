package dietCreator;

import javafx.scene.control.ComboBox;

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
    private JComboBox genderBox;
    private JComboBox exerciseBox;
    private JButton hideDietListButton;
    private JTextArea mondayDiet;
    private JTextArea wednesdayDiet;
    private JTextArea tuesdayDiet;
    private JTextArea thursdayDiet;
    private JTextArea fridayDiet;
    private JTextArea saturdayDiet;
    private JTextArea sundayDiet;

    //Todo: Write a database or at least an  array that contains food and their calorie values and make daily chart for it.
    //Todo: Make a limitation for maximum and minimum height and weight.
    public dietCreatorApp() //Constructor
    { add(rootPanel);
        setTitle("Diet Creator");
        setSize(255,200); //Attention: Size has been set much more smaller than the normal temporarily. Ratio 16:9 must be.
        setVisible(true);
        DecimalFormat dFormat = new DecimalFormat("#.00"); //Format to  see less decimal part.
        String[] exerciseStatus = {"sedentary (little or no exercise)","lightly active (sports 1-3 days/week)",
                "partly active (sports 3-5 days/week)","very active (sports 6-7 days/week)",
                "extra active (very hard exercise)"};
        for (int i = 0;i <exerciseStatus.length;i++)
        {
            exerciseBox.addItem(exerciseStatus[i]);
        }

        genderBox.addItem("Male");
        genderBox.addItem("Female");
        //Listener for calculate button.
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setSize(255,420);
                informationArea.setText("");
                double heightTemp = Integer.parseInt(heightText.getText());
                heightTemp /= 100;
                double BMI = Integer.parseInt(weightText.getText())/Math.pow(heightTemp,2);
                String BMIString = dFormat.format(BMI);

                informationArea.append("Your BMI is:" + BMIString);
                String statusReport = personStatus(BMI, heightTemp,Integer.parseInt(weightText.getText()));
                informationArea.append(statusReport);//To show status of the person.
                if(statusReport.equals("\nYou\'re underweight\n") || statusReport.equals("\nYou\'re overweight\n")|| statusReport.equals("\nYou\'re obese\n"))
                    informationArea.append(idealKilo(BMI, heightTemp,Integer.parseInt(weightText.getText())));//To show ideal weight of the person.
                String selectedGender = genderBox.getSelectedItem().toString();
                int selectedExercise = exerciseBox.getSelectedIndex();
                double minimumCal = minimumCalorie(Integer.parseInt(heightText.getText()),Integer.parseInt(weightText.getText()),Integer.parseInt(ageText.getText()),selectedGender,selectedExercise);
                String minimumCalS = dFormat.format(minimumCal);
                informationArea.append("\nMinimum Calories per day." + minimumCalS); //To show minimum calorie intake of a person.

            }
        }); // End of the calculate button

        //To display dietList
        showDietButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
        setSize(1650,500);
            }
        });//End of the showDiet button.

        hideDietListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setSize(255,420);
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

    public static double minimumCalorie(double height, double weight,int age, String gender, int exerciseStatusIndex)
    { //calculating the BMR (Basal Metabolic Rate) with Harris-Benedict equation
   double bmr;
    if(gender.equals("Male"))
    {
         bmr  = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
    }
    else
    {
         bmr  = 447.593 + (9.247 * weight ) + (3.098 * height) - (4.330 *age);
    }
        double[] basicActivityFactor = {1.2,1.375,1.55,1.725,1.9};

    for (int i= 0; i<basicActivityFactor.length;i++)
    {
        if (exerciseStatusIndex==i)
        {
            bmr*=basicActivityFactor[i];
        }
    }
return bmr;
    }


}
