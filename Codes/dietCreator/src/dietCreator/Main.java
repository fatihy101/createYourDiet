package dietCreator;


import javax.swing.*;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //Change look of the UI
        messageBox();
    dietCreatorApp form = new dietCreatorApp();
    form.setVisible(true); // To see the form elements.
    }
    public static void messageBox()
    {
        JOptionPane.showMessageDialog(null,
                "BMI is not used for muscle builders, long distance athletes,\n" +
                        "pregnant women, the elderly or young children.\n" +
                        "This is because BMI does not take into account whether the \n" +
                        "weight is carried as muscle or fat, just the number.\n" +
                        "Those with a higher muscle mass, such as athletes,\n" +
                        "may have a high BMI but not be at greater health risk.\n" +
                        "Those with a lower muscle mass, such as children\n" +
                        "who have not completed their growth or the \n" +
                        "elderly who may be losing some muscle mass may have a lower BMI.\n" +
                        "During pregnancy and lactation, a woman's body composition\n" +
                        "changes, so using BMI is not appropriate.\n" +
                        "ref: https://www.diabetes.ca","ATTENTION!",JOptionPane.INFORMATION_MESSAGE);
    }


}
