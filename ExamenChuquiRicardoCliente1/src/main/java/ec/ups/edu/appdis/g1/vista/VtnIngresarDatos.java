package ec.ups.edu.appdis.g1.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.ups.edu.appdis.g1.modelo.EnvioPaquetes;
import ec.ups.edu.appdis.g1.negocio.GestionPaqueteONRemote;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;


public class VtnIngresarDatos extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDorigen;
	private JTextField txtDdestino;
	
	private GestionPaqueteONRemote on;
	private JTextField textApellido;
	private JLabel lblNewLabel_3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VtnIngresarDatos frame = new VtnIngresarDatos();
					frame.setVisible(true);
					frame.referenciarONCliente();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VtnIngresarDatos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(20, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Direccion Origen");
		lblNewLabel_1.setBounds(20, 87, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Direccion Destino");
		lblNewLabel_2.setBounds(20, 112, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(149, 8, 154, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDorigen = new JTextField();
		txtDorigen.setBounds(149, 84, 154, 20);
		contentPane.add(txtDorigen);
		txtDorigen.setColumns(10);
		
		txtDdestino = new JTextField();
		txtDdestino.setBounds(149, 109, 154, 20);
		contentPane.add(txtDdestino);
		txtDdestino.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarPaquetes();
			}
		});
		btnGuardar.setBounds(104, 168, 89, 23);
		contentPane.add(btnGuardar);
		
		textApellido = new JTextField();
		textApellido.setBounds(159, 42, 126, 20);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Apellido");
		lblNewLabel_3.setBounds(30, 45, 46, 14);
		contentPane.add(lblNewLabel_3);
	}

	protected void guardarPaquetes() {
		// TODO Auto-generated method stub
		EnvioPaquetes p = new EnvioPaquetes();
		p.setNombre(txtNombre.getText());
		p.setApellido(textApellido.getText());
		p.setDireccionRemitente(txtDdestino.getText());
		p.setDireccionDestino(txtDorigen.getText());
		try {
			on.registrarCliente(p);
			System.out.print("Guardado OK");
		} catch (Exception e) {
			System.out.print("Error al guardar"+ e.getMessage());
		}
		}
	public void referenciarONCliente() throws Exception {
		try {  
            @SuppressWarnings("rawtypes")
			final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,"org.wildfly.naming.client.WildFlyInitialContextFactory"); 
            
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "exa");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "examen");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:/ExamenChuquiRicardoServidor/GestionPaqueteON!ec.ups.edu.appdis.g1.negocio.GestionPaqueteONRemote";  
              
            this.on = (GestionPaqueteONRemote) context.lookup(lookupName);  
              
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
}
