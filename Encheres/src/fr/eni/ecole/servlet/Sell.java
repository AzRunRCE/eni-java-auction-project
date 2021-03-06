package fr.eni.ecole.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fr.eni.ecole.beans.ArticleVendu;
import fr.eni.ecole.beans.Categorie;
import fr.eni.ecole.beans.Retrait;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.bll.BLLException;
import fr.eni.ecole.bll.CategoriesManager;
import fr.eni.ecole.bll.UtilisateursManager;
import fr.eni.ecole.bll.VentesManager;
import fr.eni.ecole.util.Constantes;
import fr.eni.ecole.util.Utils;

/**
 * Servlet implementation class Sell
 */
@WebServlet("/Sell")
@MultipartConfig
public class Sell extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_FICHIER     = "inputImage";
	
    private final static Logger LOGGER = 
            Logger.getLogger(Sell.class.getCanonicalName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sell() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
				
		Boolean isLogged = request.getSession().getAttribute(Constantes.SESS_NUM_UTILISATEUR) != null;
		if (!isLogged) {
			response.sendRedirect(Constantes.URL_ACCUEIL);
			return;
		}
		
		Integer no_utilisateur = (Integer)request.getSession().getAttribute(Constantes.SESS_NUM_UTILISATEUR);
		
		UtilisateursManager usersManager = new UtilisateursManager();
		CategoriesManager categoriesManager = new CategoriesManager();
		
	
		try {
			request.setAttribute("listeCategories", categoriesManager.getListeCategories());
			Utilisateur user = usersManager.getUtilisateur(no_utilisateur);
		
			request.setAttribute(Constantes.ATT_UTILISATEUR, user);
		} catch (BLLException e) {
			response.sendError(500);
		}
		request.getRequestDispatcher(Constantes.PAGE_SELL).forward(request, response);
	}
	
	/**
	 * Methode qui gere la soumission du formulaire de sell.jsp avec fileupload ( multipart )
	 * Va chercher dans config.properties le chemin pour la cr�ation des fichiers images
	 * Si le dossier n'existe pas alors il est cr��
	 * Ensuite si tout le reste est ok alors on �crit le fichier dans le dossier en question
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//multipart 
    	response.setContentType("text/html;charset=UTF-8");
    	
    	String path = "";
    	 try (InputStream input = Sell.class.getClassLoader().getResourceAsStream("fr/eni/ecole/config/config.properties")) {

             Properties prop = new Properties();

             if (input == null) {
                 return;
             }

             //load a properties file from class path, inside static method
             prop.load(input);

             //get the property value and print it out
             path = prop.getProperty("file_upload_path");

         } catch (IOException ex) {
             ex.printStackTrace();
         }
    	 
        final Part filePart = request.getPart("inputImage");
        final String fileName = getFileName(filePart);
        final String fileType = filePart.getHeader("content-type").split("/")[1];

        String newFileName = LocalDateTime
        		.now()
        		.format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
        newFileName +="."+fileType;
        /////////
	    
		Boolean isLogged = request.getSession().getAttribute(Constantes.SESS_NUM_UTILISATEUR) != null;
		if (!isLogged) {
			request.getRequestDispatcher(Constantes.PAGE_INDEX).forward(request, response);
			return;
		}
		Integer no_utilisateur = (Integer)request.getSession().getAttribute(Constantes.SESS_NUM_UTILISATEUR);
	
		VentesManager ventesManagers = new VentesManager() ;
		CategoriesManager categoriesManager = new CategoriesManager();
		
		ArticleVendu new_ArticleVendu = new ArticleVendu();
		Utilisateur user = new Utilisateur();
		user.setNoUtilisateur(no_utilisateur);
		
		Retrait retrait = new Retrait(0,request.getParameter("inputRue"),request.getParameter("inputCodePostal"),
				request.getParameter("inputVille"));
		
		new_ArticleVendu.setNomArticle(request.getParameter("inputNomArticle"));
		new_ArticleVendu.setDescription(request.getParameter("inputDescription"));
		Categorie categorie;
		try {
			categorie = categoriesManager.getCategorie(Integer.parseInt(request.getParameter("inputCategorie")));
			new_ArticleVendu.setCategorie(categorie);
			new_ArticleVendu.setMiseAPrix(Integer.parseInt(request.getParameter("inputPrix")));
			new_ArticleVendu.setPrixVente(Integer.parseInt(request.getParameter("inputPrix")));
			new_ArticleVendu.setDateDebutEncheres(Utils.parseDateTime(request.getParameter("DateDebutEncheres")));
			new_ArticleVendu.setDateFinEncheres(Utils.parseDateTime(request.getParameter("DateFinEncheres")));
			
			
			new_ArticleVendu.setVendeur(user);
			new_ArticleVendu.setEtatVente(false);
			new_ArticleVendu.setRetrait(retrait);
			//fileupload
			
			// creates the save directory if it does not exists
	        File fileSaveDir = new File(path);
	        if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdirs();
	        }
	        
			if(filePart.getInputStream().available() != 0 
					&& ( fileType.equals("gif") || fileType.equals("png") 
							|| fileType.equals("jpeg") || fileType.equals("bmp")
							|| fileType.equals("jpg") || fileType.equals("webp") ) 
					) {
				try(	OutputStream out = new FileOutputStream(new File( path + File.separator
						+ newFileName));
						InputStream filecontent = filePart.getInputStream(); ) {
					int read = 0;
					final byte[] bytes = new byte[1024];
					
					while ((read = filecontent.read(bytes)) != -1) {
						out.write(bytes, 0, read);
					}
					
					LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
							new Object[]{newFileName, path});
				} catch (FileNotFoundException fne) {
					LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
							new Object[]{fne.getMessage()});
				}
							
				new_ArticleVendu.setChemin_image(newFileName);
			}
			//fileupload	
			ventesManagers.create(new_ArticleVendu);
			
			
			response.sendRedirect(Constantes.URL_ACCUEIL);
			} catch (NumberFormatException | BLLException e) {
			response.sendError(500);
		}
	}
	private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {

                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
	
}
