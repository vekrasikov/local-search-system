package ru.vkrasikov.iit.local.search.system.persist;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import ru.vkrasikov.iit.local.search.system.template.IndexerTemplate;

public class FilePersistManager implements PersistManager {

  @Value("${file.store.path}")
  private String fileStore;
  private ObjectMapper mapper;
  private Gson gson;

  public FilePersistManager(){
    mapper = new ObjectMapper();
    gson = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();
  }

  @Override
  public void saveIfNotExists(IndexerTemplate body) {
    ArrayList<IndexerTemplate> indexes = loadIndexes();
    long count = indexes.stream().filter(x->x.equalsText(body.getText())).count();
    if (count == 0){
      indexes.add(body);
      saveIndexes(indexes);
    }
  }

  @Override
  public List<IndexerTemplate> searchByTokens(HashSet<String> tokens) {
    return loadIndexes().stream().filter(x->x.containsAnyToken(tokens)).collect(Collectors.toList());
  }

  @Override
  public Long countDocumentWithToken(String token) {
    return loadIndexes().stream().filter(x->x.containsToken(token)).count();
  }

  @Override
  public Long countAllDocument() {
    return loadIndexes().stream().count();
  }

  private void saveIndexes(ArrayList<IndexerTemplate> indexes){
    try {
      File file = new File(fileStore);
      OutputStream outputStream = outputStream = new FileOutputStream(file);
      BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
      gson.toJson(indexes, bufferedWriter);
      bufferedWriter.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private ArrayList<IndexerTemplate> loadIndexes() {
    ArrayList<IndexerTemplate> indexes = null;

    File file = new File(fileStore);
    InputStream inputStream = null;
    try {
      inputStream = new FileInputStream(file);
      InputStreamReader streamReader;
      streamReader = new InputStreamReader(inputStream, "UTF-8");

      indexes = new ArrayList<>(Arrays.asList(gson.fromJson(streamReader,IndexerTemplate[].class)));
      streamReader.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return indexes;
  }
}
