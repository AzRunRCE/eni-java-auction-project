package fr.eni.ecole.DAL.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import fr.eni.ecole.DAL.AbstractDAOFactory;
import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.Interface.IDAOEnchere;
import fr.eni.ecole.DAL.Interface.IDAOUtilisateur;
import fr.eni.ecole.beans.Enchere;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.rest.mo.AccueilDashboardTile;
import fr.eni.ecole.rest.mo.AccueilFilters;
import fr.eni.ecole.util.AccesBase;

public class EnchereDAO implements IDAOEnchere {

		private final String SELECT_ALL_WITHOUT_PARAM = "SELECT av.nom_article, av.date_fin_encheres, av.prix_vente, u.pseudo, u.no_utilisateur, av.no_article, av.chemin_image " + 
													"FROM ARTICLES_VENDUS av " +
													"LEFT JOIN UTILISATEURS u ON av.no_utilisateur = u.no_utilisateur ";
	
	private final String CLAUSE_WHERE = "WHERE ";
	//on doit doubler les % attendus par SQL sinon UnknownFormatConversionException lors du String.format()
	private final String FILTER_NAME ="UPPER(av.nom_article) LIKE '%%%s%%' "; 
	private final String FILTER_CATEGORIE = "av.no_categorie = %d ";
	private final String AND = "AND ";
	private final String VENTES = "";
	private final String UNION = "UNION ";
	
	private final String LEFT_JOIN_ENCHERES = "LEFT JOIN ENCHERES e ON av.no_article = e.no_article "; 
	private final String TOUTES_ENCHERES_OUVERTES = "av.date_debut_encheres < GETDATE() AND av.date_fin_encheres > GETDATE() ";
	private final String MES_ENCHERES = "e.no_utilisateur = %d ";
	private final String MES_ENCHERES_OU_VENTES_COURS = "av.date_debut_encheres < GETDATE() AND av.date_fin_encheres > GETDATE() ";
	private final String MES_ENCHERES_REMPORTEES = "e.montant_enchere = av.prix_vente AND av.date_fin_encheres < GETDATE() ";
	private final String ACHATS = "av.no_utilisateur <> %d ";
	private final String MES_VENTES = "av.no_utilisateur = %d ";
	private final String MES_VENTES_NON_COMMENCEES = "av.date_debut_encheres > GETDATE() ";
	private final String MES_VENTES_TERMINEES = "av.date_fin_encheres < GETDATE() ";
	private final String GROUP_BY_ARTICLE_ID = "GROUP BY av.no_article, av.nom_article, av.date_fin_encheres, av.prix_vente, u.pseudo, u.no_utilisateur, av.chemin_image ";
	
	private Boolean whereAlreadySet;
	
	private final String SELECT_BY_ID = "SELECT no_utilisateur, date_enchere, montant_enchere " + 
										"FROM ENCHERES "+
										"WHERE no_article = ? "+
										"ORDER BY montant_enchere DESC";
	
	
	private final String CREATE = "INSERT INTO ENCHERES VALUES(?, ?, ?, ?)";
	
	private final String DELETE = "DELETE FROM ENCHERES WHERE no_utilisateur = ? AND no_article = ?";
					
	private DataSource dataSource = null;
	
	public EnchereDAO(DataSource _dataSource) {
		dataSource = _dataSource;
	}

	@Override
	public int create(Enchere obj) throws DALException{
		return 0;
	}

	@Override
	public int delete(Enchere obj) throws DALException {
		return 0;
	}

	@Override
	public boolean update(Enchere obj)throws DALException {
		return false;
	}

	@Override
	public Enchere find(int noArticle) throws DALException {
		Enchere enchere = null;
		Utilisateur acheteur = null;
		IDAOUtilisateur UtilisateurDAO = null;
		ResultSet rs = null;
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(SELECT_BY_ID)) {
			preparedStatement.setInt(1,noArticle);
			rs = preparedStatement.executeQuery();
	    	if(rs.next()) {
	    		UtilisateurDAO = AbstractDAOFactory.getFactory().getUtilisateurDAO();
	    		acheteur = UtilisateurDAO.find(rs.getInt("no_utilisateur"));
	    		enchere = new Enchere(rs.getTimestamp("date_enchere").toLocalDateTime(),
	    								rs.getInt("montant_enchere"),
	    								acheteur);
	    	}
	    	return enchere;
		} catch (SQLException e) {
			throw new DALException("Problème avec la méthode selectById2", e);
		} 
	}
	
	@Override
	public List<AccueilDashboardTile> selectAllWithoutParameters() throws DALException{
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(SELECT_ALL_WITHOUT_PARAM)) {

			List<AccueilDashboardTile> listeMsgObjectsAccueil= new ArrayList<>();
			
	    	ResultSet rs = preparedStatement.executeQuery();
	    	while(rs.next()) {
	    		listeMsgObjectsAccueil.add(new AccueilDashboardTile( 
	    										rs.getString("nom_article"), 
	    										rs.getTimestamp("date_fin_encheres").toLocalDateTime().toString(), 
	    										rs.getInt("prix_vente"),
	    										rs.getString("pseudo"),	
	    										rs.getInt("no_utilisateur"), 
	    										rs.getInt("no_article"),
	    										rs.getString("chemin_image")
		    									)
	    		);    
	    	}
	    	return listeMsgObjectsAccueil;
		} catch (SQLException e) {
			throw new DALException("Erreur dans selectAllWithoutParameters", e);
		}
	}

	@Override
	public List<AccueilDashboardTile> selectAllwithParameters(AccueilFilters accueilFilters, Integer idUtilisateur) throws DALException {
		
		whereAlreadySet = false;
		StringBuilder requeteParametree = new StringBuilder();
		String requeteParametreeCopy = new String();
		Boolean encheresOuverteChecked = accueilFilters.getEnchereOuverteChecked();
		Boolean encheresEnCoursChecked = accueilFilters.getEncheresEnCoursChecked();
		Boolean encheresRemporteesChecked = accueilFilters.getEncheresRemporteesChecked();
		Boolean ventesEnCoursChecked = accueilFilters.getVentesEnCoursChecked();
		Boolean ventesNonDebuteesChecked = accueilFilters.getVentesNonDebuteesChecked();
		Boolean ventesTermineesChecked = accueilFilters.getVentesTermineesChecked();
		
		requeteParametree.append(SELECT_ALL_WITHOUT_PARAM);
		
		if(accueilFilters.getRadioButtons()!=null && accueilFilters.getRadioButtons().equals("mesVentes")) {
			System.out.println("mesVentes");
			requeteParametree.append(VENTES);
			requeteParametree = constructSQLForNameAndCategorie(requeteParametree, accueilFilters);

			if(!whereAlreadySet) {
				requeteParametree.append(CLAUSE_WHERE);
				whereAlreadySet = true;
				requeteParametree.append( String.format(MES_VENTES, idUtilisateur) );
			}else {
				requeteParametree.append(AND);
				requeteParametree.append( String.format(MES_VENTES, idUtilisateur) );
			}
			
			
			if(ventesEnCoursChecked && ventesNonDebuteesChecked && ventesTermineesChecked ) {
				//on ne rajoute rien on veut tout
			} else if (ventesEnCoursChecked && ventesNonDebuteesChecked && !ventesTermineesChecked) {
				// on va devoir faire un union
				requeteParametree = constructSQLForMesVentesWithUNION(requeteParametree,
																		accueilFilters, 
																		MES_ENCHERES_OU_VENTES_COURS, 
																		MES_VENTES_NON_COMMENCEES);				
				System.out.println(requeteParametree.toString());
				
			} else if (ventesEnCoursChecked && !ventesNonDebuteesChecked && ventesTermineesChecked) {
				// on va devoir faire un union
				requeteParametree = constructSQLForMesVentesWithUNION(requeteParametree, 
																		accueilFilters, 
																		MES_ENCHERES_OU_VENTES_COURS, 
																		MES_VENTES_TERMINEES);
				System.out.println(requeteParametree.toString());
				
			} else if (!ventesEnCoursChecked && ventesNonDebuteesChecked && ventesTermineesChecked) {
				// on va devoir faire un union
				requeteParametree = constructSQLForMesVentesWithUNION(requeteParametree, 
																		accueilFilters, 
																		MES_VENTES_NON_COMMENCEES, 
																		MES_VENTES_TERMINEES);
				System.out.println(requeteParametree.toString());
				
			} else if (ventesEnCoursChecked && !ventesNonDebuteesChecked && !ventesTermineesChecked) {
				//cas simple
				requeteParametree = constructSQLForMesVentesSimple(requeteParametree,
																	accueilFilters, 
																	MES_ENCHERES_OU_VENTES_COURS);
				System.out.println(requeteParametree.toString());
					
			} else if (!ventesEnCoursChecked && ventesNonDebuteesChecked && !ventesTermineesChecked) {
				//cas simple
				requeteParametree = constructSQLForMesVentesSimple(requeteParametree,
																	accueilFilters, 
																	MES_VENTES_NON_COMMENCEES);
				System.out.println(requeteParametree.toString());
				
			} else if (!ventesEnCoursChecked && !ventesNonDebuteesChecked && ventesTermineesChecked) {
				//cas simple
				requeteParametree = constructSQLForMesVentesSimple(requeteParametree,
																	accueilFilters, 
																	MES_VENTES_TERMINEES);
				System.out.println(requeteParametree.toString());
					
			} else {
				//aucun champ selectionne parmi les checkbox
			}

		} else if (accueilFilters.getRadioButtons() != null && accueilFilters.getRadioButtons().equals("mesAchats")) {
			System.out.println("mesAchats");
			requeteParametree.append(LEFT_JOIN_ENCHERES);
			requeteParametree = constructSQLForNameAndCategorie(requeteParametree, accueilFilters);
			if(!whereAlreadySet) {
				requeteParametree.append(CLAUSE_WHERE);
				whereAlreadySet = true;
				requeteParametree.append(String.format(ACHATS, idUtilisateur));
			} else {
				requeteParametree.append(AND);
				requeteParametree.append(String.format(ACHATS, idUtilisateur));
			}
			if ( (encheresOuverteChecked && encheresEnCoursChecked && encheresRemporteesChecked)
					|| (encheresOuverteChecked && !encheresEnCoursChecked && encheresRemporteesChecked) ) {
				//On veut toutes les encheres ouvertes + mes encheres remportees - UNION
				if(!whereAlreadySet) {
					requeteParametree.append(CLAUSE_WHERE);
					whereAlreadySet = true;
					
					requeteParametreeCopy = requeteParametree.toString();
					requeteParametree.append(TOUTES_ENCHERES_OUVERTES);
					
					requeteParametree.append(UNION);
					requeteParametree.append(requeteParametreeCopy);
					requeteParametree.delete(requeteParametree.indexOf(LEFT_JOIN_ENCHERES), requeteParametree.indexOf(LEFT_JOIN_ENCHERES)+ LEFT_JOIN_ENCHERES.length());
					requeteParametree.append( String.format(MES_ENCHERES, idUtilisateur) );
					requeteParametree.append(AND);
					requeteParametree.append(MES_ENCHERES_REMPORTEES);
				} else {
					requeteParametreeCopy = requeteParametree.toString();
		
					requeteParametree.append(AND);
					requeteParametree.append(TOUTES_ENCHERES_OUVERTES);
					
					requeteParametree.append(UNION);

					requeteParametree.append(requeteParametreeCopy);

					requeteParametree.append( String.format(MES_ENCHERES, idUtilisateur) );
					requeteParametree.append(AND);
					requeteParametree.append(MES_ENCHERES_REMPORTEES);
				}
				System.out.println(requeteParametree.toString());
			} else if (!encheresOuverteChecked && encheresEnCoursChecked && encheresRemporteesChecked) {
				//On veut uniquement mes requetes en cours et remportees - UNION
				
				if(!whereAlreadySet) {
					requeteParametree.append(CLAUSE_WHERE);
					whereAlreadySet = true;
					requeteParametree.append( String.format(MES_ENCHERES, idUtilisateur) );
					requeteParametree.append(AND);
					
					requeteParametreeCopy = requeteParametree.toString();
					
					requeteParametree.append(MES_ENCHERES_OU_VENTES_COURS);
					
					requeteParametree.append(UNION);
					requeteParametree.append(requeteParametreeCopy);
					
					
					requeteParametree.append(MES_ENCHERES_REMPORTEES);
				} else {
					requeteParametree.append( String.format(MES_ENCHERES, idUtilisateur) );
					requeteParametree.append(AND);
					
					requeteParametreeCopy = requeteParametree.toString();
		
					requeteParametree.append(AND);
					requeteParametree.append(MES_ENCHERES_OU_VENTES_COURS);
					
					requeteParametree.append(UNION);

					requeteParametree.append(requeteParametreeCopy);

					requeteParametree.append(MES_ENCHERES_REMPORTEES);
				}
				System.out.println(requeteParametree.toString());
			} else if ( (encheresOuverteChecked && !encheresEnCoursChecked && !encheresRemporteesChecked)
					|| (encheresOuverteChecked && encheresEnCoursChecked && !encheresRemporteesChecked)) {
				//Toutes les encheres en cours
				if(!whereAlreadySet) {
					requeteParametree.append(CLAUSE_WHERE);
					whereAlreadySet = true;
					requeteParametree.append(TOUTES_ENCHERES_OUVERTES);
				} else {
					requeteParametree.append(AND);
					requeteParametree.append(TOUTES_ENCHERES_OUVERTES);
				}
				System.out.println(requeteParametree.toString());
			} else if (!encheresOuverteChecked && encheresEnCoursChecked && !encheresRemporteesChecked) {
				//cas simple
				requeteParametree = constructSQLForMesEncheresSimple(requeteParametree,
																	accueilFilters, 
																	MES_ENCHERES_OU_VENTES_COURS, 
																	idUtilisateur);
				System.out.println(requeteParametree.toString());

			} else if (!encheresOuverteChecked && !encheresEnCoursChecked && encheresRemporteesChecked) {
				//cas simple
				requeteParametree = constructSQLForMesEncheresSimple(requeteParametree,
																	accueilFilters, 
																	MES_ENCHERES_REMPORTEES, 
																	idUtilisateur);
				System.out.println(requeteParametree.toString());
			} 
		} else {
			// requete en mode non connecte
			requeteParametree = constructSQLForNameAndCategorie(requeteParametree, accueilFilters);
			System.out.println(requeteParametree.toString());
		}
		
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(
															requeteParametree.toString() + 
															GROUP_BY_ARTICLE_ID)
						) {
			System.out.println(requeteParametree.toString() + GROUP_BY_ARTICLE_ID);
			List<AccueilDashboardTile> listeMsgObjectsAccueil= new ArrayList<>();
			
	    	ResultSet rs = preparedStatement.executeQuery();
	    	while(rs.next()) {
	    		listeMsgObjectsAccueil.add(new AccueilDashboardTile( 
	    										rs.getString("nom_article"), 
	    										rs.getTimestamp("date_fin_encheres").toLocalDateTime().toString(), 
	    										rs.getInt("prix_vente"),
	    										rs.getString("pseudo"),	
	    										rs.getInt("no_utilisateur"), 
	    										rs.getInt("no_article"),
	    										rs.getString("chemin_image")
		    									)
	    		);    
	    	}
	    	return listeMsgObjectsAccueil;
		} catch (SQLException e) {
			throw new DALException("Probleme dans selectAllWithParameters", e);
		}
	}
	
	
	
	/**
	 * Cette methode permet la construction de la partie filtres mode non connecté de la requete SQL
	 * Elle gere donc les filtres sur name et categorie
	 * @param sb
	 * @param accueilFilters
	 * @return le StringBuilder avec la partie de la requete en plus
	 */
	private StringBuilder constructSQLForNameAndCategorie (StringBuilder sb, AccueilFilters accueilFilters) {
		if(accueilFilters.getNameFilter() != null && !accueilFilters.getNameFilter().isEmpty()) {
			sb.append(CLAUSE_WHERE);
			whereAlreadySet = true;
			sb.append( String.format(FILTER_NAME, accueilFilters.getNameFilter().toUpperCase()) );
		}
		if(accueilFilters.getNoCategorie() != -1 ) {
			if(!whereAlreadySet) {
				sb.append(CLAUSE_WHERE);
				whereAlreadySet = true;
				sb.append( String.format(FILTER_CATEGORIE, accueilFilters.getNoCategorie()) );
			}else {
				sb.append(AND);
				sb.append( String.format(FILTER_CATEGORIE, accueilFilters.getNoCategorie()) );
			}
		}
		return sb;
	}
	
	/**
	 ** Cette methode permet la construction de la partie filtres mode connecté (Mes ventes) de la requete SQL
	 * Elle gere le cas ou un deux filtres sont demandés
	 * @param sb
	 * @param accueilFilters
	 * @param constraint1 correspond à une constante ex : MES_ENCHERES_OU_VENTES_COURS
	 * @param constraint2 correspond à une constante ex : MES_ENCHERES_OU_VENTES_COURS
	 * @return le StringBuilder avec la partie de la requete en plus
	 */
	private StringBuilder constructSQLForMesVentesWithUNION (StringBuilder sb,
																AccueilFilters accueilFilters,
																String constraint1,
																String constraint2 ) {
		String requeteParametreeCopy = new String();
		
		if(!whereAlreadySet) {
			sb.append(CLAUSE_WHERE);
			whereAlreadySet = true;
			
			requeteParametreeCopy = sb.toString();
			sb.append(constraint1);
			
			sb.append(UNION);
			sb.append(requeteParametreeCopy);
			sb.append(constraint2);
		} else {
			requeteParametreeCopy = sb.toString();

			sb.append(AND);
			sb.append(constraint1);
			
			sb.append(UNION);

			sb.append(requeteParametreeCopy);
			
			sb.append(AND);
			sb.append(constraint2);
		}
		return sb;
	}
	
	/**
	 * Cette methode permet la construction de la partie filtres mode connecté (Mes ventes) de la requete SQL
	 * Elle gere le cas ou un seul filtre est demandé
	 * @param sb
	 * @param accueilFilters
	 * @param constraint correspond à une constante ex : MES_ENCHERES_OU_VENTES_COURS
	 * @return le StringBuilder avec la partie de la requete en plus
	 */
	private StringBuilder constructSQLForMesVentesSimple (StringBuilder sb, 
															AccueilFilters accueilFilters,
															String constraint ) {
		if(!whereAlreadySet) {
			sb.append(CLAUSE_WHERE);
			whereAlreadySet = true;
			sb.append(constraint);	
		} else {
			sb.append(AND);
			sb.append(constraint);	
		}
		return sb;
	}
	/**
	 * Cette methode permet la construction de la partie filtres mode connecté (Mes encheres) de la requete SQL
	 * Elle gere le cas ou un seul filtre est demandé
	 * @param sb
	 * @param accueilFilters
	 * @param constraint correspond à une constante ex : MES_VENTES_TERMINEES
	 * @param idUtilisateur
	 * @return le StringBuilder avec la partie de la requete en plus
	 */
	
	private StringBuilder constructSQLForMesEncheresSimple (StringBuilder sb,
															AccueilFilters accueilFilters,
															String constraint,
															Integer idUtilisateur) {
		if(!whereAlreadySet) {
			sb.append(CLAUSE_WHERE);
			whereAlreadySet = true;
			sb.append( String.format(MES_ENCHERES, idUtilisateur) );
			sb.append(AND);
			sb.append(constraint);
		} else {
			sb.append(AND);
			
			sb.append( String.format(MES_ENCHERES, idUtilisateur) );
			sb.append(AND);
			sb.append(constraint);
		}
		return sb;
	}
	
	@Override
	public int nouvelleEnchere(int noUtilisateur, int noArticle, int montant) throws DALException {
		int rs = 0;
	
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(CREATE)) {
			preparedStatement.setInt(1, noUtilisateur);
			preparedStatement.setInt(2, noArticle);
			preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
			preparedStatement.setInt(4, montant);
			rs = preparedStatement.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new DALException("Problème avec la méthode connect", e);
		}
		
	}
	
	@Override
	public int deleteEnchere(int noUtilisateur, int noArticle) throws DALException {
		int rs = 0;
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(DELETE)) {
			preparedStatement.setInt(1, noUtilisateur);
			preparedStatement.setInt(2, noArticle);
			rs = preparedStatement.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new DALException("Problème avec la méthode deleteEnchere", e);
		} 
	}
}
