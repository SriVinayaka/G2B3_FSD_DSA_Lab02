/**
 * 
 */
package com.gl.floors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 */
import java.util.PriorityQueue;
import java.util.Scanner;

public class SkyScrapperConstruction {

	
	private ArrayList<Integer> floor_queue;
	private Integer[] priority;
	private String[] my_floor_values;
	
	public void read_array_data()
	{
		Scanner scr = new Scanner(System.in);
		int i = 1;
		Integer value = 0;
		int no_of_floors = 0;
		
		System.out.println("Enter the total no of floors in the building:");
		no_of_floors = scr.nextInt();
		
		priority = new Integer[no_of_floors];
		floor_queue = new ArrayList<Integer>();
		
		for(i = 1; i <= no_of_floors; i++)
		{
			System.out.println("Enter the floor size given on day : " + i);
			value = scr.nextInt();
			floor_queue.add(i-1, value);
			priority[i-1] = value;
			
		}
		Arrays.sort(priority, Comparator.reverseOrder());
		
		/*
		for(i = 0; i < no_of_floors; i++)
		{
			System.out.println(priority[i]);
		}
		*/
	}
	
	public void arrange_floor_data()
	{
		int i = 0;
		int j = 0;
		int size = 0;
		Integer max_value = 0;
		Integer floor_value1;
		//Integer floor_value2;
		
		size = priority.length;
		//System.out.println(size);
		my_floor_values = new String[size];
		
		System.out.println("\nThe order of construction is as follows:");
		
		for(i=0; i < size; i++)
		{
			my_floor_values[i] = "";
			max_value = priority[i];

			for(j=i; j < size; j++)
			{
				floor_value1 = floor_queue.get(j);
				//System.out.println("Max Value:= " + max_value);
				//System.out.println("Floor Value:= " + floor_value1);
				//floor_value2 = floor_queue.get(j+1);
				if((max_value == floor_value1))// && (i == j))
				{
						
						if((my_floor_values[i].equals("")))
						{
							my_floor_values[i] += "Completed " + floor_value1.toString();
						}
						else //if((my_floor_values[i].equals("")) && (i != size-1))
						{
							//System.out.println(1);
							my_floor_values[i] += ", Completed " + floor_value1.toString();
							//break;							
						}
						/*
						else if(!(my_floor_values[i].equals("")))// && (i == j))
						{
							//System.out.println(1);
							my_floor_values[i] += ", Waiting for " + floor_value1.toString();
							//break;							
						}
						*/
						
						/*
						else if(i == size-1)
						{
							if(my_floor_values[i].equals(""))
							{
								my_floor_values[i] += "completed " + floor_value1.toString();
							}
							else
							{
								my_floor_values[i] += ", waiting " + floor_value1.toString();
							}
						}
						else if(i < size-1)
						{
							my_floor_values[i] += ", Waiting for " + floor_value1.toString();
						}
						else
						{
							my_floor_values[i] += ", Waiting for " + floor_value1.toString();
						}
						*/
				}
				else if(max_value > floor_value1)
				{
					if(my_floor_values[i].equals(""))
					{
						my_floor_values[i] += "Waiting for " + floor_value1.toString();
					}
					else
					{
						my_floor_values[i] += ", Waiting for " + floor_value1.toString();
					}
					//
					////my_floor_values[i] += ", Waiting for " + floor_value1.toString();
					break;
				}
				else if(max_value < floor_value1)
				{
					if(my_floor_values[i].equals(""))
					{
						my_floor_values[i] += "completed " + floor_value1.toString();
					}
					else
					{
						my_floor_values[i] += ", Completed " + floor_value1.toString();
					}
					break;
				}
				else
				{
					my_floor_values[i] += ", Waiting for " + floor_value1.toString();
				}
				//System.out.println(j);

			}
			String myval = my_floor_values[i];
			System.out.printf("Day %d %s\n", i+1, myval);
		}
		
		
		
	}
	
}
