# flagselector

This Project can be run using the following command.

1. Import this project into Eclipse
2. The right click on Project and select "Maven -> Update Project"
3. The project should build on its own.
4. The Run this Spring boot project using the Run button "Run (tab) -> Run"
5. This will start the project at port "https://localhost:8080"
6. Import the /flag-selector-api/FlagSelectorAPI.postman_collection.json  into postman included in this project along side this README.txt
7. Run the following Requests from postman
	a) GetAllData
	b) GetAllDataByContinent
	c) GetAllDataByContinentAndCountry
8. You can get the Audit Logs from http://localhost:8080/auditevents
9. To get Performance of the Service, go to the URL, 
		http://localhost:8080/health
10. To get all the details of metrics service, go to the URL, 
		http://localhost:8080/metrics
11. To get a metrics service that can provide - number of times certain continent/country flag has been viewed,
	go to the URL,
		http://localhost:8080/metrics/counter.status.200.flags.continent.country
