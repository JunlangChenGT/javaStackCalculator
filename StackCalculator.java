package h08;

import java.util.EmptyStackException;
import java.util.Scanner;

public class StackCalculator 
{
	//class variables
	StackInterface<Double> stack;


	// constructor
	public StackCalculator(StackInterface<Double> stack)
	{
		this.stack = stack;
	}

	//===============main===================
	public static void main(String[] args)
	{
		//scanner
		Scanner scan = new Scanner(System.in);
		
		int mode = 0;
		boolean selectMode = true;
		boolean spanishMode = false;
		StackCalculator calc = new StackCalculator(new ArrayStack<Double>());

		
		System.out.println("a");
		

		//initialize our calculator object with the specified stack type
		while(selectMode == true)
		{
			//prompt user
			//1 ArrayStack
			//2 LinkedStack
			//3 JavaStandardLibraryStack
			if(spanishMode == false)
			{
				
				System.out.println("Calculator 0.00\nUser Interface:");
				System.out.println("Press 1 for ArrayStack");
				System.out.println("Press 2 for LinkedStack");
				System.out.println("Press 3 for JavaStandardLibraryStack");
				System.out.println("Para español, por favor presione 4\n");
			}
			else
			{
				System.out.println("Calculadora 0.00\nInterfaz de usuario:");
				System.out.println("Presione 1 para ArrayStack");
				System.out.println("Presione 2 para LinkedStack");
				System.out.println("Presione 3 para JavaStandardLibraryStack");
				System.out.println("Press 4 for English\n");
			}
			String modeInput = scan.next();
			switch(modeInput)
			{
			case "0":
				if(spanishMode == true)  System.out.println("¡Ninguno seleccionado!");
				
				else System.out.println("None selected!");
				break;
				

			case "1":
				if(spanishMode == true) System.out.println("¡ArrayStack seleccionado!");
				
				else System.out.println("ArrayStack selected!");
				
				mode = 1;
				calc = new StackCalculator(new ArrayStack<Double>());
				selectMode = false;
				break;


			case "2":
				if(mode == 0) System.out.println("LinkedStack selected!");
				
				else if(mode == 4) System.out.println("¡LinkedStack seleccionado!");
				mode = 2;
				calc = new StackCalculator(new LinkedStack<Double>());
				selectMode = false;
				break;

			case "3":
				if(spanishMode == true) System.out.println("¡JavaStandardLibraryStack seleccionado!");
				
				else System.out.println("JavaStandardLibaryStack selected!");
				mode = 3;
				calc = new StackCalculator(new JavaStandardLibraryStack<Double>());
				selectMode = false;
				break;

			case "4":
				if(spanishMode == true)
				{
					System.out.println("English mode selected.");
					spanishMode = false;
				}
				else
				{
					System.out.println("Modo español seleccionado.");
					spanishMode = true;
				}
				break;
				
			default:
				if(spanishMode == true) System.out.println("Algo salió mal en el menú de selección");
				else System.out.println("something went wrong in selection menu");
				
			}
		}

		
		
		//instructions for user
		if(spanishMode == true)
		{
			System.out.println("Modo de empleo: escriba un número y pulse Intro,");
			System.out.println("Escriba otro número y presione Entrar,");
			System.out.println("A continuación, escriba el siguiente operador + - * / % ^ y pulse Intro");
			System.out.println("2 + 2 serían:\n");
			System.out.println("2\n2\n+\n\n");
		}
		else
		{
			System.out.println("How to use: type a number and press enter,");
			System.out.println("type another number and press enter,");
			System.out.println("then type in a following operator + - * / % ^ and press enter");
			System.out.println("2 + 2 would be:\n");
			System.out.println("2\n2\n+\n\n");
		}

			//while loop to continuously take user input
			Scanner reader = new Scanner(System.in);

			//print statement to indicate starting calculator
			if(spanishMode == true) 
			{
				System.out.println("Introduzca los valores de uno en uno; operadores para realizar cálculos. Introduzca '=' para salir.");
			}
			else
			{
				System.out.println("Enter values one at a time; operators to perform calculation. Enter '=' to exit.");
			}
			

			// while loop to continously take user ipnput
			while(true)
			{
				//get user input
				String input = reader.next();
				Double[] twoNumbers = {null, null};
				boolean breakout = false;

				//check to see if we're exiting the calculator
				switch(input)
				{
				case "=":
				{
					breakout = true;
					if(spanishMode == true) System.out.println("Salió");
					else System.out.println("exited");
					break;
				}

				//addition
				case "+":
				{
					if(!calc.pop(twoNumbers, spanishMode)) continue;

					//perform operation on num1 and num2
					Double result = twoNumbers[1] + twoNumbers[0];
					System.out.println("\t" + result);
					calc.stack.push(result);
					break;
				}

				//subtraction
				case "-":
				{
					if(!calc.pop(twoNumbers, spanishMode)) continue;

					//perform operation on num1 and num2
					Double result = twoNumbers[1] - twoNumbers[0];
					System.out.println("\t" + result);
					calc.stack.push(result);
					break;
				}
				
				//multiplication
				case "*":
				{
					if(!calc.pop(twoNumbers, spanishMode)) continue;

					//perform operation on num1 and num2
					Double result = twoNumbers[1] * twoNumbers[0];
					System.out.println("\t" + result);
					calc.stack.push(result);
					break;
				}

				//division
				case "/":
				{
					if(!calc.pop(twoNumbers, spanishMode)) continue;

					//perform operation on num1 and num2
					Double result = twoNumbers[1] / twoNumbers[0];
					System.out.println("\t" + result);
					calc.stack.push(result);
					break;
				}

				//modulo
				case "%":
				{
					if(!calc.pop(twoNumbers, spanishMode)) continue;

					//perform operation on num1 and num2
					Double result = twoNumbers[1] % twoNumbers[0];
					System.out.println("\t" + result);
					calc.stack.push(result);
					break;
				}

				//exponent
				case "^":
				{
					if(!calc.pop(twoNumbers, spanishMode)) continue;

					//perform operation on num1 and num2
					Double result = Math.pow(twoNumbers[1], twoNumbers[0]);
					System.out.println("\t" + result);
					calc.stack.push(result);
					break;
				}

				default:
				{
					try
					{
						Double value = Double.parseDouble(input);
						calc.stack.push(value);
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}

				}
				
				if(breakout == true) break;
			}
		}

		public boolean pop(Double[] twoNumbers, boolean spanishMode)
		{
			try
			{
				Double num1 = this.stack.pop();
				try
				{
					Double num2 = this.stack.pop();
					twoNumbers[0] = num1;
					twoNumbers[1] = num2;
					return true;
				}
				catch(EmptyStackException e)
				{
					this.stack.push(num1);
					if(spanishMode == true) System.out.println("Valores insuficientes dentro de la pila para realizar la operación.");
					else System.out.println("Insufficient values within stack to perform operation.");
					return false;
				}
			}
			catch(EmptyStackException e)
			{
				if(spanishMode == true) System.out.println("¡La pila está vacía! Agregue más valores a la pila antes de realizar la operación.");
				else System.out.println("Stack is empty! Add more values to stack before performing operation.");
				return false;
			}
		}

	}
