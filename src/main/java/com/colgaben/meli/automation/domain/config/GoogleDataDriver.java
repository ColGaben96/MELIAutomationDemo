package com.colgaben.meli.automation.domain.config;

import com.colgaben.meli.automation.domain.constants.GoogleDataConstants;
import com.colgaben.meli.automation.domain.utils.WebDriverManager;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.PageObject;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

public class GoogleDataDriver extends PageObject {

    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.DRIVE);
    private static final String APPLICATION_NAME = GoogleDataConstants.APPLICATION_NAME;
    private final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();

    public GoogleDataDriver() throws GeneralSecurityException, IOException {
    }

    public File fetchCredentials() {
        return new File("./src/test/resources/credentials/credentials.json");
    }

    public File fetchTokenAPIGoogle() {
        return new File("./src/test/resources/credentials/");
    }

    private Credential getCredentials() throws Exception {
        var apiAccess = new FileInputStream(fetchCredentials());
        if (apiAccess == null) {
            throw new FileNotFoundException("Credentials missing");
        }
        var clientSecrets = GoogleClientSecrets
                .load(JSON_FACTORY, new InputStreamReader(apiAccess));
        var flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new File(String.valueOf(fetchTokenAPIGoogle()))))
                .setAccessType("offline")
                .build();
        var reciever = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, reciever).authorize("user");
    }

    public void generateWorkbookHeader(List<List<Object>> values) {
        var cols = values.get(0).size();
        for (int i = 0; i < cols; i++) {
            WebDriverManager.data.put(values.get(0).get(i).toString(), "");
        }
    }

    public void getDataFromWorkbook(int row, DataTable gSheet) {
        try {
            WebDriverManager.data.clear();
            var dataFeature = gSheet.asMaps(String.class, String.class);
            var range = dataRange(dataFeature.get(0).get("Sheet"));
            var service = new Sheets.Builder(httpTransport, JSON_FACTORY, getCredentials())
                    .setApplicationName(APPLICATION_NAME)
                    .build();
            var response = service.spreadsheets().values()
                    .get(GoogleDataConstants.WORKBOOK_ID, range)
                    .execute();
            var values = response.getValues();
            if (values != null || !values.isEmpty()) {
                for (int i = 0; i < values.size(); i++) {
                    if (i > 0 && i == row) {
                        generateWorkbookHeader(values);
                        for (int j = 0; j < values.get(row).size(); j++) {
                            WebDriverManager.data.put(values.get(0).get(j).toString(),
                                    values.get(row).get(j).toString());
                        }
                        break;
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    public String dataRange(String sheet) {
        var rangeSheet = "";
        sheet = sheet.trim();
        switch (sheet) {
            default -> throw new IllegalStateException("Unexpected Value: "+sheet.trim().toLowerCase());
            case "Setup" -> rangeSheet = sheet+"!A:C";
            case "Cookies" -> rangeSheet = sheet+"!A:C";
            case "ProductSearch" -> rangeSheet = sheet+"!A:H";
        }
        return rangeSheet;
    }
}

