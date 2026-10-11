package Classes;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AdminUserManagement {
	private String USER_MANAGEMENT_OPTIONS = "\n----OPCIONES DE ADMINISTRADOR----\n\n1- Crear nuevo usuario\n2- Ver usuarios\n3- Eliminar usuarios\n4- Volver al menú\n\nOpción: ";

	public void showUserManagementOptions() throws FileNotFoundException {
		Session session = new Session();
		DAO conn = new DAO();
		int option = Input.getInt(USER_MANAGEMENT_OPTIONS);
		if (option == 1) {
			boolean success = session.adminSignup();
			if(!success) {
				System.out.println("\nSaliendo del gestor de usuarios...");
				return;
			}
		} else if (option == 2) {
			ArrayList<User> users = conn.getUsers();
			System.out.println("\nUsuarios en BBDD actualmente: " + users.size() + "\n");
			for(int i = 0; i < users.size(); i++) {
				System.out.print("Usuario " + (i+1) + " -");
				System.out.print(users.get(i));
			}
			int userNumber = Input.getInt("\nSelecciona numero de usuario para ver detalles o 0 para volver al menú: ");
			if(userNumber == 0) {
				System.out.println("\nSaliendo del gestor de usuarios...");
				return;
			}
			for(int i = 0; i < users.size(); i++) {
				if (i == (userNumber - 1)) {
					users.get(i).userInfo(Utils.getAge(Utils.formatDateSql(users.get(i).getBirthdate())));
				}
			}
			
			UserProfileManager m = new UserProfileManager();
			for(int i = 0; i < users.size(); i++) {
				if(i == userNumber-1) {
					m.adminUserDataMod(users.get(i).getId(), session);
				}
					
			}
					
			
		} else if (option == 3) {
			ArrayList<User> users = conn.getUsersToRemove(Session.getUser().getId());
			System.out.println("\nUsuarios para borrar en BBDD actualmente: " + users.size() + "\n");
			for(int i = 0; i < users.size(); i++) {
				System.out.print("Usuario " + (i+1) + " -");
				System.out.print(users.get(i));
			}
			int userNumber = Input.getInt("\nSelecciona número de usuario para ELIMINAR LA CUENTA o 0 para volver al menú: ");
			if(userNumber == 0) {
				System.out.println("\nSaliendo del gestor de usuarios...");
				return;
			}
			String comfirm = Input.getString("Escribe Si para comfirmar acción (ELIMINAR CUENTA DE USUARIO) o No para volver al menú: ");
			if(comfirm.equalsIgnoreCase("Si")) {
				for(int i = 0; i < users.size(); i++) {
					if(i == (userNumber - 1)) {
						conn.removeUser(users.get(i).getId());
					}	
				}
				
			} else if(comfirm.equalsIgnoreCase("No")) {
				System.out.println("\nCancelando acción y volviendo al menú...");
				return;
			} else {
				System.out.println("\nOpción no válida...\nCancelando acción y volviendo al menú...");
				return;
			}
		} else if (option == 4) {
			return;
		} else {
			return;
		}
	}
}
