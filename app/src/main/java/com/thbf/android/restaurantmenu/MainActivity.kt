package com.thbf.android.restaurantmenu

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {

    var adapter:FoodAdapter?=null
    var listOfFoods = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfFoods.add(Food("Coffee","Coffee preparation is the process of turning",R.drawable.coffee_pot))
        listOfFoods.add(Food("Espresso","Espresso preparation is the process of turning",R.drawable.espresso))
        listOfFoods.add(Food("Fries","Fries preparation is the process of turning",R.drawable.french_fries))
        listOfFoods.add(Food("Honey","Honey preparation is the process of turning",R.drawable.honey))
        listOfFoods.add(Food("Strawberry","Strawberry preparation is the process of turning",R.drawable.strawberry_ice_cream))
        listOfFoods.add(Food("Sugar Cubes","Coffee preparation is the process of turning",R.drawable.sugar_cubes))

        adapter = FoodAdapter(this,listOfFoods)
        gvMenu.adapter = adapter
    }

    class FoodAdapter: BaseAdapter {

        var listOfFood = ArrayList<Food>()
        var context:Context?=null

        constructor(context:Context, listOfFood:ArrayList<Food>):super(){
            this.context = context
            this.listOfFood = listOfFood
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val food = this.listOfFood[position]

            var foodView = View.inflate(context,R.layout.food_ticket,null)
            foodView.iv_food_ticket.setImageResource(food.image!!)
            foodView.tv_food_ticket.text = food.name!!


            return foodView
        }

        override fun getItem(position: Int): Any {
            return listOfFood[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfFood.size
        }

    }
}