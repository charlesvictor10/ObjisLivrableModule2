import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {
	
	public Server() {}
	
	@Override
	public String sayHello() throws RemoteException {
		return "Hello, Objis!";
	}
	
	public static void main(String[] args) {
		try {
			Server obj = new Server();
			Hello stub = (Hello) UnicastRemoteObject.exportObject(obj,0);
			
			// Brancher le 'stub' de l'objet distant dans l'annuaire
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("Hello", stub);
			
			System.err.println("Server disponible");
		} catch (Exception e) {
			System.err.println("Server exception: "+e.toString());
			e.printStackTrace();
		}
	}
}
