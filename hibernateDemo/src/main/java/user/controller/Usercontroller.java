package user.controller;

import java.util.Scanner;

import user.dao.UserDao;
import user.dto.User;
public class Usercontroller {

	public static void main(String[] args) {
		boolean  isToRepeat = true;
		System.out.println("Welcome to User Application");
		while(isToRepeat) {
		
		System.out.println("Plz Enter 1 for Save the data");
		System.out.println("Plz Enter 2 for Update the data");
		System.out.println("Plz Enter 3 for Delete the data");
		System.out.println("Plz Enter 4 for Search/Find the data");
		System.out.println("Plz Enter 5 for Show All User data");
		System.out.println("Plz Enter 6 for EXIT");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		switch(option) {
		case 1: // save the data
		{
		
//			System.out.print("Enter the user Id :");
//			int userId = sc.nextInt();
			System.out.print("Enter user name :");
			String userName = sc.next();
			System.out.print("Enter user Address :");
			String userAddress = sc.next();
			
			User user = new User();
//			user.setId(userId);
			user.setName(userName);
			user.setAddress(userAddress);
			
			UserDao userDao = new UserDao();
			userDao.saveUser(user);
			System.out.println("SucessFully user have been saved");
		}
		break;
		case 2: // Update the data
		{
			System.out.print("Enter the user Id :");
			int userId = sc.nextInt();
			System.out.print("Enter user name :");
			String userName = sc.next();
			System.out.print("Enter user Address :");
			String userAddress = sc.next();
			
			User usertoUpdate = new User();
			usertoUpdate.setName(userName);
			usertoUpdate.setAddress(userAddress);
			
			UserDao userDao = new UserDao();
			userDao.updateUser(userId, usertoUpdate);
			System.out.println("SucessFully user have been saved");
		}
		break;
		case 3: // Delete the user
		{
			System.out.print("Enter the user Id :");
			int userId = sc.nextInt();
			
			UserDao userDao = new UserDao();
			userDao.deleteUser(userId);
			System.out.println("Data Deleted SuccesFully Thankyou");
		}
		break;
		case 4: // Find /Search user
		{
			System.out.print("Enter the user Id :");
			int userId = sc.nextInt();
			
			UserDao userDao = new UserDao();
			userDao.findUser(userId);
			System.out.println("Data Fetch SuccesFully Thankyou");
		}
		break;
		case 5:// show all User details
		{
			UserDao userDao = new UserDao();
			userDao.showAllUser();
			System.out.println("All User details has shown  Thankyou");
		}
		break;
		case 6:
		{
			isToRepeat = false;
			System.out.println("thanks For your vist !!!!!!!!!!!");
		}
		break;
		default:
			System.out.println("Invalid Input");
		}
	
	}
	}

}
