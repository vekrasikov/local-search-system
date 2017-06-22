package ru.vkrasikov.iit.local.search.system.template;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.awt.print.Book;
import java.lang.reflect.Type;

public class IndexerTemplateSerialiser implements JsonSerializer<IndexerTemplate> {

  @Override
  public JsonElement serialize(final IndexerTemplate index, final Type typeOfSrc, final JsonSerializationContext context) {
    final JsonObject jsonObject = new JsonObject();

    jsonObject.addProperty("id", index.getId().toString());
    jsonObject.addProperty("text", index.getText());

    final JsonElement jsonTokenizedTextArray = context.serialize(index.getTokenizedText());
    jsonObject.add("tokenizedText", jsonTokenizedTextArray);

    final JsonElement jsonTokensArray = context.serialize(index.getTokens());
    jsonObject.add("tokens", jsonTokensArray);

    return jsonObject;
  }

}
