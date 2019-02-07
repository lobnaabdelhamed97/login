package connections;


public interface UserInterface {
	//two methods will be created 
	//2-method 1 to fill the data in the registration part 
	//inserting data in db creating object from users class this object will be inserted in db
	public int insertUser(Users u);

	//method2 when you click on login it go and get user details  from db	
	public Users getUsers(String email, String password);
}
