package dietCreator;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class foodList {
    public ArrayList<food> foodArrayList = new ArrayList<food>();
    ArrayList<food> selectedBreakfastItems = new ArrayList<food>();
    ArrayList<food> selectedLunchDinnerItems = new ArrayList<food>();


    String[] type = {"Breakfast","Lunch","Dinner"};
    food food0 = new food("Beans on Toast 118 g", 210, type[1]);
    food food1 = new food("Egg, 50 g", 100, type[0]);
    food food2 = new food("Nonfat greek yogurt 100 g",59, type[0]);
    food food3 = new food("Whole-fat greek yogurt 100 g",141,type[0]);
    food food4 = new food("Nonfat milk 100 g",41, type[0]);
    food food5 = new food("Bran Cereal 100 g",287, type[0]);
    food food6 = new food("Seedless raisins 20 g",60, type[0]);
    food food7 = new food("Oatmeal bread 1 slice (27 g)",72, type[0]);
    food food8 = new food("Hazelnuts 25 g (18 nuts)",157, type[0]);
    food food9 = new food("Cottage cheese 50 g",60, type[0]);
    food food10 = new food("Olives 50 g",58, type[0]);
    food food11 = new food("Egg and Cheese sandwich 200 g",392, type[1]);
    food food12 = new food("Creamy Tomato Soup 275 g",349, type[1]);
    food food13 = new food("Cheese Quesadilla 193 g",557, type[1]);
    food food14= new food("Egg Noodles with Brown Butter and Feta 175 g",74, type[1]);
    food food15= new food("Sweet Corn Salad",102, type[1]);
    food food16= new food("Basic Chicken Quesadilla 324 g",852, type[1]);
    food food17 = new food("Chicken club sandwich 375 g",676, type[1]);
    food food18 = new food("Caesar salad 359 g",461, type[1]);
    food food19 = new food("Pearl Couscous Salad 260 g",171, type[1]);
    food food20 = new food("Fish and chips 195 g",260, type[1]);
    food food21 = new food("Cucumber Crab Sushi 113 g",77, type[1]);
    food food22 = new food("White Rice 275 g",343, type[2]);
    food food23 = new food("Grilled chicken mediterranean 325 g",420, type[2]);
    food food24 = new food("Mashed Potato 280 g",342, type[2]);
    food food25 = new food("Perfect Beef Burger 300 g",749, type[2]);
    food food26 = new food("Fish Burger 325 g",407, type[2]);
    food food27 = new food("Chicken Kebabs 210 g",225, type[2]);




//Karıştır - Tara - verileri al - tabloya gönder - karıştır!

    public foodList(double intakeTotal)
    {
        foodArrayList.addAll(Arrays.asList(food0 ,food1 ,food2 ,food3,food4 ,food5,food6  ,food7 ,food8 ,food9 ,food10, food11,food12,food13,food14,
                food15,food16,food17,food18,food19,food20  ,food21 ,food22,food23,food24 ,food25 ,food26,food27));
       selectedBreakfastItems.addAll(forBreakfast(intakeTotal,foodArrayList));
     selectedLunchDinnerItems.addAll(forLunchDinner(intakeTotal,foodArrayList));



    }
//BREAKFAST
    public static ArrayList<food> forBreakfast(double intakeTotal, ArrayList<food> arrayFoods)
    { //This method will calculate, a person's daily calorie requirement for breakfast. Then it'll filter the foods in database we have with breakfast parameter.
        ArrayList<food> nArrayFoods = new ArrayList<food>();
        nArrayFoods.addAll(arrayFoods);
        Collections.shuffle(nArrayFoods);
        ArrayList<food> selectedBreakfast = new ArrayList<food>();
        double totalCalorie= 0;
      double  maxCalForBreakfast = intakeTotal * 0.2;
      for (int i = 0; i<nArrayFoods.size();i++)
      {

          if(totalCalorie<maxCalForBreakfast && nArrayFoods.get(i).type == "Breakfast") {
              double tempCal = nArrayFoods.get(i).caloriesOfFood + totalCalorie;
              if(tempCal<maxCalForBreakfast && totalCalorie<maxCalForBreakfast)
              {
              totalCalorie += nArrayFoods.get(i).caloriesOfFood;
              selectedBreakfast.add(nArrayFoods.get(i));
              }
           }
      }
    return selectedBreakfast;
    }
//LUNCH AND DINNER
    public static ArrayList<food> forLunchDinner(double intakeTotal, ArrayList<food> arrayFoods)
    { //This method will calculate, a person's daily calorie requirement for lunch.
        ArrayList<food> nArrayFoods = new ArrayList<food>();
        nArrayFoods.addAll(arrayFoods);
        Collections.shuffle(nArrayFoods);
        ArrayList<food> selectedMeal = new ArrayList<food>();
        double totalCalorie= 0;
        double  maxCal = intakeTotal * 0.8;
        for (int i = 0; i<nArrayFoods.size();i++)
        {

            if(totalCalorie<maxCal && (nArrayFoods.get(i).type == "Lunch")|| nArrayFoods.get(i).type == "Dinner") {
                double tempCal = nArrayFoods.get(i).caloriesOfFood + totalCalorie;
                if(tempCal<maxCal && totalCalorie<maxCal)
                {
                    totalCalorie += nArrayFoods.get(i).caloriesOfFood;
                    selectedMeal.add(nArrayFoods.get(i));
                }
            }
        }
        return selectedMeal;
    }

}
