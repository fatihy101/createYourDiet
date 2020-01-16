package dietCreator;
import java.util.ArrayList;
import java.util.Hashtable;

public class foodList {
String[] type = {"Breakfast","Lunch","Dinner"};
  food food1 = new food("Egg, 50 g", 100,true,type[0]);
  food food2 = new food("Nonfat greek yogurt 100 g",59,true,type[0]);
  food food3 = new food("Whole-fat greek yogurt 100 g",141,false,type[0]);
  food food4 = new food("Nonfat milk 100 g",41,true,type[0]);
  food food5 = new food("Bran Cereal 100 g",287, true,type[0]);
  food food6 = new food("Seedless raisins 20 g",60, true, type[0]);
    food food7 = new food("Oatmeal bread 1 slice (27 g)",72, true, type[0]);
    food food8 = new food("Hazelnuts 25 g (18 nuts)",157, true, type[0]);
    food food9 = new food("Cottage cheese 50 g",60, true, type[0]);
    food food10 = new food("Olives 50 g",58, true, type[0]);
    food food11 = new food("Egg and Cheese sandwich 200 g",392, true, type[1]);
    food food12 = new food("Creamy Tomato Soup 275 g",349, true, type[1]);
    food food13 = new food("Cheese Quesadilla 193 g",557, true, type[1]);
    food food14= new food("Egg Noodles with Brown Butter and Feta 175 g",74, true, type[1]);
    food food15= new food("Sweet Corn Salad",102, true, type[1]);
    food food16= new food("Basic Chicken Quesadilla 324 g",852, false, type[1]);
    food food17 = new food("Chicken club sandwich 375 g",676, true, type[1]);
    /*food food18 = new food("",, true, type[1]);
    food food19 = new food("",, true, type[1]);
    food food20 = new food("",, true, type[1]);
    food food21 = new food("",, true, type[2]);
    food food22 = new food("",, true, type[2]);
    food food23 = new food("",, true, type[2]);
    food food24 = new food("",, true, type[2]);
    food food25 = new food("",, true, type[2]);
    food food26 = new food("",, true, type[2]);*/

    ArrayList<food> foodArrayList = new ArrayList<food>();

//Tara - verileri al - tabloya gönder - karıştır!

    public foodList(double intakeTotal)
    {
       ArrayList<food> selectedBreakfastItems =  forBreakfast(intakeTotal,foodArrayList);
       ArrayList<food> selectedLunchItems = forLunch(intakeTotal,foodArrayList);
       ArrayList<food> selectedDinnerItems = forDinner(intakeTotal,foodArrayList);

    }

    public static ArrayList<food> forBreakfast(double intakeTotal, ArrayList<food> arrayFoods)
    { //This method will calculate, a person's daily calorie requirement for breakfast. Then it'll filter the foods in database we have with breakfast parameter.
        ArrayList<food> selectedBreakfast = new ArrayList<food>();
        double totalCalorie= 0;
      double  maxCalForBreakfast = intakeTotal * 0.2;
      for (int i = 0; i<arrayFoods.size();i++)
      {
          if(totalCalorie<maxCalForBreakfast || arrayFoods.get(i).type.equals("Breakfast")) {
              totalCalorie += arrayFoods.get(i).caloriesOfFood;
             selectedBreakfast.add(arrayFoods.get(i));
           }
      }
    return selectedBreakfast;
    }

    public static ArrayList<food> forLunch(double intakeTotal, ArrayList<food> arrayFoods)
    { //This method will calculate, a person's daily calorie requirement for lunch.
        ArrayList<food> selectedLunch = new ArrayList<food>();
        double totalCalorie= 0;
        double  maxCalForLunch = intakeTotal * 0.4;
        for (int i = 0; i<arrayFoods.size();i++)
        {
            if(totalCalorie<maxCalForLunch || arrayFoods.get(i).type.equals("Lunch")) {
                totalCalorie += arrayFoods.get(i).caloriesOfFood;
                selectedLunch.add(arrayFoods.get(i));
            }
        }
        return selectedLunch;
    }


    public static ArrayList<food> forDinner(double intakeTotal, ArrayList<food> arrayFoods)
    { //This method will calculate, a person's daily calorie requirement for dinner.
        ArrayList<food> selectedDinner = new ArrayList<food>();
        double totalCalorie= 0;
        double  maxCalForDinner = intakeTotal * 0.4;
        for (int i = 0; i<arrayFoods.size();i++)
        {
            if(totalCalorie<maxCalForDinner || arrayFoods.get(i).type.equals("Dinner")) {
                totalCalorie += arrayFoods.get(i).caloriesOfFood;
                selectedDinner.add(arrayFoods.get(i));
            }
        }
        return selectedDinner;
    }
}
