package com.wordpress.michaelkyazze.codeperspective101.MongoHQ;

import com.wordpress.michaelkyazze.codeperspective101.MyContact;

public class QueryBuilder {
	
	/**
	 * Specify your database name here
	 * @return
	 */
	public String getDatabaseName() {
		return "code101";
	}

	/**
	 * Specify your MongoLab API here
	 * @return
	 */
	public String getApiKey() {
		return "wUz-MRi673wOezm7pSOmFW3gGMnLqYTQ";
	}
	
	/**
	 * This constructs the URL that allows you to manage your database, 
	 * collections and documents
	 * @return
	 */
	public String getBaseUrl()
	{

		return "https://api.mongolab.com/api/1/databases/"+getDatabaseName()+"/collections/";
	}
	
	/**
	 * Completes the formating of your URL and adds your API key at the end
	 * @return
	 */
	public String docApiKeyUrl()
	{
		return "?apiKey="+getApiKey();
	}

	public String docApiKeyUrl(String docid)
	{
		return "/"+docid+"?apiKey="+getApiKey();
	}
	
	/**
	 * Returns the docs101 collection
	 * @return
	 */
	public String documentRequest()
	{
		return "docs101";
	}
	
	/**
	 * Builds a complete URL using the methods specified above
	 * @return
	 */
	public String buildContactsSaveURL()
	{
		return getBaseUrl()+documentRequest()+docApiKeyUrl();
	}

	/**
	 * This method is identical to the one above.
	 * @return
	 */
	public String buildContactsGetURL()
	{
		return getBaseUrl()+documentRequest()+docApiKeyUrl();
	}

	/**
	 * Get a Mongodb document that corresponds to the given object id
	 * @param doc_id
	 * @return
	 */
	public String buildContactsUpdateURL(String doc_id)
	{
		return getBaseUrl()+documentRequest()+docApiKeyUrl(doc_id);
	}


	/**
	 * Formats the contact details for MongoHLab Posting
	 * @param contact: Details of the person
	 * @return
	 */

	public String createContact(MyContact contact)
	{
		return String
		.format("{\"Mes\": \"%s\", "
				+ "\"Dia\": \"%s\", \"Ano\": \"%s\",\"Hora\": \"%s\", \"Descripcion\": \"%s\", "
				+ "\"Nombre\": \"%s\"}, \"safe\" : true}",
				contact.Mes, contact.Dia,contact.Ano,contact.Hora, contact.Descripcion, contact.Nombre);
	}


	/**
	 * Update a given contact record
	 * @param contact
	 * @return
	 */
	public String setContactData(MyContact contact) {
		return String.format("{ \"$set\" : "
						+ "{\"Mes\" : \"%s\", "
						+ "\"Dia\" : \"%s\", "
						+ "\"Ano\" : \"%s\", "
						+ "\"Hora\" : \"%s\", \"Descripcion\": \"%s\", \"Nombre\": \"%s\" }" + "}",
				contact.getMes(),
				contact.getDia(), contact.getAno(),
				contact.getHora(), contact.getDescripcion(), contact.getNombre());
	}
	
	

}
