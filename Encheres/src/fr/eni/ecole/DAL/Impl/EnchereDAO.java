package fr.eni.ecole.DAL.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.beans.Enchere;
import fr.eni.ecole.rest.mo.AccueilFilters;
import fr.eni.ecole.rest.mo.AccueilDashboardTile;
import fr.eni.ecole.rest.mo.getDetailEnchere;
import fr.eni.ecole.util.AccesBase;
import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.Interface.*;

public class EnchereDAO implements IDAOEnchere {

	private final String SELECT_ALL_WITHOUT_PARAM = "SELECT av.nom_article, av.date_fin_encheres, av.prix_vente, u.pseudo, u.no_utilisateur, av.no_article " + 
													"FROM ARTICLES_VENDUS av " +
													"LEFT JOIN UTILISATEURS u ON av.no_utilisateur = u.no_utilisateur ";
	
	private final String CLAUSE_WHERE = "WHERE ";
	//on doit doubler les % attendus par SQL sinon UnknownFormatConversionException lors du String.format()
	private final String FILTER_NAME ="UPPER(av.nom_article) LIKE '%%%s%%' "; 
	private final String FILTER_CATEGORIE = "av.no_categorie = %d ";
	private final String AND = "AND ";
	private final String VENTES = "";
	private final String UNION = "UNION ";
	
	private final String LEFT_JOIN_ENCHERES = "LEFT JOIN ENCHERES e ON av.no_utilisateur = e.no_utilisateur "; 
	private final String TOUTES_ENCHERES_OUVERTES = "av.date_debut_encheres < GETDATE() AND av.date_fin_encheres > GETDATE() ";
	private final String MES_ENCHERES = "e.no_utilisateur = %d ";
	private final String MES_ENCHERES_OU_VENTES_COURS = "av.date_debut_encheres < GETDATE() AND av.date_fin_encheres > GETDATE() ";
	private final String MES_ENCHERES_REMPORTEES = "av.date_debut_encheres < GETDATE() AND av.date_fin_encheres > GETDATE() ";
	private final String ACHATS = "av.no_utilisateur <> %d ";
	private final String MES_VENTES = "av.no_utilisateur = %d ";
	private final String MES_VENTES_NON_COMMENCEES = "av.date_debut_encheres > GETDATE() ";
	private final String MES_VENTES_TERMINEES = "av.date_fin_encheres < GETDATE() ";
	private final String GROUP_BY_ARTICLE_ID = "GROUP BY av.no_article, av.nom_article, av.date_fin_encheres, av.prix_vente, u.pseudo, u.no_utilisateur ";
	
	private Boolean whereAlreadySet;
	
	private final String SELECT_BY_ID = "SELECT av.nom_article, av.description, c.libelle, av.date_fin_encheres, av.prix_initial, av.no_utilisateur as vendeur, e.montant_enchere, e.no_utilisateur as acheteur, e.no_article, u.pseudo, r.code_postal, r.rue, r.ville " + 
										"FROM ENCHERES e " + 
										"RIGHT JOIN UTILISATEURS u ON e.no_utilisateur = u.no_utilisateur " + 
										"RIGHT JOIN ARTICLES_VENDUS av  ON e.no_article = av.no_article " + 
										"RIGHT JOIN RETRAITS r ON e.no_article = r.no_article " + 
										"RIGHT JOIN CATEGORIES c ON c.no_categorie = av.no_categorie " + 
										"WHERE e.no_article = ? " + 
										"ORDER BY e.montant_enchere DESC";
								
	@Override
	public boolean create(Enchere obj) {
		return false;
	}

	@Override
	public boolean delete(Enchere obj) {
		return false;
	}

	@Override
	public boolean update(Enchere obj) {
		return false;
	}

	@Override
	public Enchere find(int id) {
		return null;
	}
	
	@Override
	public List<AccueilDashboardTile> selectAllWithoutParameters() {
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
	    										rs.getInt("no_article")
		    									)
	    		);    
	    	}
	    	return listeMsgObjectsAccueil;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DALException e1) {
			System.out.println("Probleme dans selectAllWithoutParameters");
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AccueilDashboardTile> selectAllwithParameters(AccueilFilters accueilFilters, Integer idUtilisateur) {
		
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
	    										rs.getInt("no_article")
		    									)
	    		);    
	    	}
	    	return listeMsgObjectsAccueil;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DALException e1) {
			System.out.println("Probleme dans selectAllWithParameters");
			e1.printStackTrace();
		}
		return null;
	}
	
	@Override
	public getDetailEnchere selectById(int noArticle) {
		getDetailEnchere enchere = null;
		ResultSet rs = null;
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(SELECT_BY_ID)) {
			preparedStatement.setInt(1,noArticle);
			rs = preparedStatement.executeQuery();
	    	if(rs.next()) {
	    		//rs.first();
	    		enchere = new getDetailEnchere(rs.getString("nom_article"),
	    										rs.getString("description"),
	    										rs.getString("libelle"),
	    										rs.getString("pseudo"),
	    										rs.getString("code_postal"),
	    										rs.getString("rue"),
	    										rs.getString("ville"),
	    										rs.getTimestamp("date_fin_encheres").toLocalDateTime(),
	    										rs.getInt("prix_initial"),
	    										rs.getInt("montant_enchere"),
	    										rs.getInt("no_article"),
	    										rs.getInt("acheteur"),
	    										rs.getInt("vendeur"));
	    	}
	    	return enchere;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (DALException e1) {
			System.out.println("Probleme dans le mÃ©thode selectById");
			e1.printStackTrace();
			return null;
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
}
